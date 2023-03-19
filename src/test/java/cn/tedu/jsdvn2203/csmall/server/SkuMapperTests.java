package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.SkuMapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Sku;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.SkuDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.SkuListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SkuMapperTests {
    @Autowired
    SkuMapper skuMapper;

    @Test
    public void testInsert() {
        Sku sku = new Sku();
        sku.setTitle("2022最強電競筆電炫光彩");
        sku.setId(202112010000003L);
        int rows = skuMapper.insert(sku);
        Long id = sku.getId();

        log.debug("插入成功,受影響的行數:{},id值:{}",rows,id);

    }

    @Test
    public void testDeleteById() {
        Long id = 4L;
        int rows = skuMapper.deleteById(id);
        log.debug("刪除完成,受影響行數:{}",rows);
    }

    @Test
    public void testDeleteByIds() {
        int rows = skuMapper.deleteByIds(5L, 8L);
        log.debug("刪除完成,受影響行數:{}" , rows);
    }

    @Test
    public void testUpdateTitleById() {
        Long id = 7L;
        String name = "realme";
        int rows = skuMapper.updateTitleById(id, name);
        log.debug("修改完成,受影響行數:{}" , rows);
    }

    @Test
    public void testUpdateById() {
        Sku sku = new Sku();
        sku.setId(6L);

        int rows = skuMapper.updateById(sku);
        System.out.println("修改完成,受影響的行數:"+rows);
    }
    @Test
    public void testCount(){
        int count = skuMapper.count();
        log.debug("統計品牌數量:{}",count);
    }
    @Test
    public void testGetById(){
        Long id = 3L;
        SkuDetailVO skuDetailVO = skuMapper.getById(id);

        System.out.println("查詢的結果:"+skuDetailVO);
    }
    @Test
    public void testList(){
        List<SkuListItemVO> list = skuMapper.list();
        System.out.println("列表完成,一共有"+list.size()+"條");
        for (SkuListItemVO skuListItemVO : list) {
            log.debug("sku:{}\n",skuListItemVO);
        }
    }

}
