package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.config.RedisConfiguration;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;


@SpringBootTest
@Slf4j
public class RedisTemplateTests {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testOpsForValueSet1() {
        String key = "bossName";
        String value = "Andy";
        //獲取操作器,只要在redis中處理的數據的值(String類型),需要以下操作器
        ValueOperations<String, Serializable> opsForValue
                = redisTemplate.opsForValue();
        opsForValue.set(key, value);
        log.debug("已經向redis中寫入簡單的String數據");

    }

    /**
     * 可視化工具: TTL :time to live 過期時間 -1表示永久存在 -2表示過期
     */
    @Test
    public void testOpsForValueSet2() {
        String key = "email";
        String value = "aaa123456@ip.com";
        long timeOut = 1L; //設置有效期
        //獲取操作器,只要在redis中處理的數據的值(String類型),需要以下操作器
        ValueOperations<String, Serializable> opsForValue
                = redisTemplate.opsForValue();
        opsForValue.set(key, value, timeOut, TimeUnit.MINUTES);
        log.debug("已經向redis中寫入簡單的String數據,有效期為{}分鐘", timeOut);

    }

    /**
     * 存對象測試 (測試存品牌對象)
     */
    @Test
    public void testOpsForValueSet3() {
        String key = "brand:item:1";
        BrandDetailVO brandDetailVO = new BrandDetailVO();
        brandDetailVO.setId(22L);
        brandDetailVO.setName("111");
        brandDetailVO.setPinyin("蹦蹦蹦!!!!!");


        //獲取操作器,只要在redis中處理的數據的值(String類型),需要以下操作器
        //對象也會轉換成json字符串類型
        ValueOperations<String, Serializable> opsForValue
                = redisTemplate.opsForValue();
        opsForValue.set(key, brandDetailVO);

        log.debug("已經向redis中寫入品牌資料,對象:{}", brandDetailVO);

    }


    @Test
    public void testOpsForValueGet() {
        String key = "brands";
        ValueOperations<String, Serializable> opsForValue
                = redisTemplate.opsForValue();
        Serializable value = opsForValue.get(key);
        log.debug("已經從redis讀取到key:{} , value:{} ", key, value);
        log.debug("value的資料類型:{}", value.getClass().getName());

    }

    @Test
    public void testDelete() {
        String key = "username";
        Boolean delete = redisTemplate.delete(key);
        log.debug("刪除redis中的key:{}的資料 , 結果:{}", key, delete);

    }

    @Test
    public void testKeys() {
        String keyPattern = "*"; //定義查詢規則
        Set<String> keys = redisTemplate.keys(keyPattern);
        for (String key : keys) {
            ValueOperations<String, Serializable> opsForValue
                    = redisTemplate.opsForValue();
            Serializable value = opsForValue.get(key);
            log.debug("查詢到的結果 : key:{} , value:{}\n", key, value);
        }
    }

    @Test
    public void testOpsForListRightPush() {
        String key = "brands";
        ArrayList<BrandListItemVO> brands = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BrandListItemVO brand = new BrandListItemVO();
            brand.setId(i+0L);
            brand.setName("品牌" + i);
            brands.add(brand);
        }
        //向redis寫入列表,需獲取對應操作器
        ListOperations<String, Serializable> opsForList = redisTemplate.opsForList();
        //寫入列表,隊列(先進先出),雙端隊列,棧(先進後出)
        for (BrandListItemVO brand : brands) {
            opsForList.rightPush(key, brand);
        }
        log.debug("已經向redis存入List類型資料");
    }

    @Test
    public void testOpsForListSize() {
        String key = "brands";
        ListOperations<String, Serializable> opsForList
                = redisTemplate.opsForList();
        Long size = opsForList.size(key);
        log.debug("讀取key:{}的List類型資料的長度:{}", key, size);
    }

    @Test
    public void testOpsForListIndex() {
        String key = "brand:list";
        ListOperations<String, Serializable> opsForList
                = redisTemplate.opsForList();
        //下標從0 開始,以長度為10的List為例,有效下標為[0~9] 和 [-10~-1]
        //如果下標越界,不報異常,返回null
        Long index = 1L;
        Serializable serializable = opsForList.index(key, index);
        log.debug("讀取key:{}的List類型資料的下標:{}的數據:{}", key, index, serializable);

        index = -12L;
        serializable = opsForList.index(key, index);
        log.debug("讀取key:{}的List類型資料的下標:{}的數據:{}", key, index, serializable);

    }

    @Test
    public void testOpsForListRange(){ //獲取整個列表
        String key = "brands" ;
        ListOperations<String, Serializable> opsForList
                = redisTemplate.opsForList();
        // start = 0, end = 9   >>> 全部
        // start = 0, end = 0   >>> 下標為0的資料
        // start = 0, end = -1  >>> 全部 【推薦】
        // start = 0, end = 10  >>> 全部
        // start = 0, end = -7  >>> 下標 1 ~ 4
        Long start = 0L;
        Long end = 15L;
        List<Serializable> list = opsForList.range(key, start, end);
        log.debug("讀取key:{}的List類型資料從{}到{}的資料集合:{}",key,start,end,list);

    }













    /**
     * 額外補充 : 數據類型介紹
     * */

    /**
     * 數據結構: 隊列(先進先出)
     */
    @Test
    public void testQueue() {
        // 數據結構: 隊列(先進先出)
        Queue<Integer> queue = new LinkedList<>();
        // 入隊
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        log.debug("隊列: {} ", queue);

        //出隊
        Integer pollResult = queue.poll();
        log.debug("隊首元素:{} ", pollResult);
        log.debug("隊列:{}", queue);

        //查看隊首元素(不移除)
        pollResult = queue.peek();
        log.debug("隊首元素:{} ", pollResult);
        log.debug("隊列:{}", queue);
    }

    /**
     * 數據類型 : 雙端隊列
     */
    @Test
    public void testDeque() {
        // 數據類型 : 雙端隊列
        Deque<Integer> deque = new LinkedList<>();

        // 隊尾入隊
        deque.offerLast(1);
        deque.offer(2);
        log.debug("隊列:{}", deque); //[1,2]

        // 隊首入隊
        deque.offerFirst(3);
        deque.offerFirst(4);
        deque.offerFirst(5);
        log.debug("隊列:{}", deque); //[5,4,3,1,2]

        // 隊首出隊
        Integer pollResult = deque.poll();
        log.debug("隊首:{}", pollResult); //5
        log.debug("隊列:{}", deque); //[4,3,1,2]
        pollResult = deque.pollFirst();
        log.debug("隊首:{}", pollResult); //4
        log.debug("隊列:{}", deque); //[3,1,2]

        // 隊尾出隊
        pollResult = deque.pollLast();
        log.debug("隊尾:{}", pollResult); //2
        log.debug("隊列:{}", deque); //[3,1]

        // 查看隊首元素
        pollResult = deque.peek();
        log.debug("隊首:{}", pollResult); //3
        log.debug("隊列:{}", deque); //[3,1]
        pollResult = deque.peekFirst();
        log.debug("隊首:{}", pollResult); //3
        log.debug("隊列:{}", deque); //[3,1]

        // 查看隊尾元素
        pollResult = deque.peekLast();
        log.debug("隊尾:{}", pollResult); //1
        log.debug("隊列:{}", deque); //[3,1]
    }

    /**
     * 數據類型 : 棧(先進後出)
     */
    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        // 入棧 或 壓棧
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        log.debug("棧:{}", stack);

        // 出棧 或 彈棧
        Integer popResult = stack.pop();
        log.debug("出棧元素:{}", popResult); //4
        log.debug("棧:{}", stack);
        popResult = stack.pop();
        log.debug("出棧元素:{}", popResult); //3
        log.debug("棧:{}", stack);

        // 查看棧頂元素
        popResult = stack.peek();
        log.debug("棧頂元素:{}", popResult); //2
        log.debug("棧:{}", stack);
    }
}





