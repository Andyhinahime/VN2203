package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.SkuSpecificationMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.SkuSpecification;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.SkuSpecificationListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SkuSpecificationMapperTests {
    @Autowired
    SkuSpecificationMapper skuSpecificationMapper;

    @Test
    public void testInsert(){
        SkuSpecification skuSpecification = new SkuSpecification();
        skuSpecification.setAttributeName("機殼大小");
        int rows = skuSpecificationMapper.insert(skuSpecification);
        Long id = skuSpecification.getId();
        log.debug("插入成功,受影響的行數:{},id值:{}",rows,id);
    }

    @Test
    public void testDeleteById(){
        Long id = 9L;
        int rows = skuSpecificationMapper.deleteById(id);
        log.debug("刪除完成,受影響行數:{}" , rows);
    }

    @Test
    public void testDeleteByIds(){
        int rows = skuSpecificationMapper.deleteByIds(7L, 10L);
        log.debug("修改完成,受影響行數:{}" , rows);
    }
    @Test
    public void testUpdateById(){
        SkuSpecification skuSpecification = new SkuSpecification();
        skuSpecification.setAttributeName("機殼尺寸");
        skuSpecification.setUnit("公分");
        skuSpecification.setId(8L);
        int rows = skuSpecificationMapper.updateById(skuSpecification);
        log.debug("修改完成! 受影響的行數：{}",rows);
    }
    @Test
    public void testCount(){
        int count = skuSpecificationMapper.count();
        log.debug("數量:{}",count);
    }
    @Test
    public void testList(){
        List<SkuSpecificationListItemVO> list = skuSpecificationMapper.list();
        log.debug("列表完成,共有{}條",list.size());
        for (SkuSpecificationListItemVO skuSpecificationListItemVO : list) {
            log.debug("SkuSpecification:{}\n",skuSpecificationListItemVO);
        }

    }

}
