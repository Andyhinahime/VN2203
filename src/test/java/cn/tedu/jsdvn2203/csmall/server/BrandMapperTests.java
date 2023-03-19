package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BrandMapperTests {
    @Autowired
    BrandMapper brandMapper;

    @Test
    public void testInsert() {
        Brand brand = new Brand();
        brand.setName("SAMSUNG");
        int rows = brandMapper.insert(brand);
        Long id = brand.getId();
        log.info("插入成功,受影響的行數:{},id值:{}",rows,id);
        log.debug("插入成功,受影響的行數:{},id值:{}",rows,id);
        System.out.println("成功,影響行數:" + rows + ",id值:" + id);
    }

    @Test
    public void testDeleteById() {
        Long id = 4L;
        int rows = brandMapper.deleteById(id);
        log.debug("刪除完成,受影響行數:{}",rows);
    }

    @Test
    public void testDeleteByIds() {
        int rows = brandMapper.deleteByIds(5L, 8L);
        log.debug("刪除完成,受影響行數:{}" , rows);
    }

    @Test
    public void testUpdateNameById() {
        Long id = 7L;
        String name = "realme";
        int rows = brandMapper.updateNameById(id, name);
        log.debug("修改完成,受影響行數:{}" , rows);
    }

    @Test
    public void testUpdateById() {
        Brand brand = new Brand();
        brand.setId(6L);
        brand.setPinyin("HHH");
        brand.setDescription("最強耐摔手機");
        int rows = brandMapper.updateById(brand);
        System.out.println("修改完成,受影響的行數:"+rows);
    }
    @Test
    public void testCount(){
        int count = brandMapper.count();
       log.debug("統計品牌數量:{}",count);
    }

    @Test
    public void testCountByName(){
        String name = "小米123";
        int rows = brandMapper.countByName(name);


    }

    @Test
    public void testGetById(){
        Long id = 3L;
        BrandDetailVO brandDetailVO = brandMapper.getById(id);

        log.debug("查詢的結果{}:",brandDetailVO);
    }
    @Test
    public void testList(){
        List<BrandListItemVO> list = brandMapper.list();
        log.debug("列表完成,共有{}條",list.size());
        for (BrandListItemVO brandListItemVO : list) {
            log.debug("Brand:{}\n",brandListItemVO);
        }
    }

    @Test
    public void testLogLevel(){
        log.trace("這是trace級別日誌...");
        log.debug("這是debug級別日誌...");
        log.info("這是info級別日誌...");
        log.warn("這是warn級別日誌...");
        log.error("這是error級別日誌...");
    }

}
