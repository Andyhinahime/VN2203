package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.AttributeTemplateMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.AttributeTemplate;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class AttributeTemplateMapperTests {
    @Autowired
    AttributeTemplateMapper attributeTemplateMapper;
    @Test
    public void testInsert(){
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setName("鍵盤滑鼠組");
        int rows = attributeTemplateMapper.insert(attributeTemplate);
        Long id = attributeTemplate.getId();
        log.debug("插入成功,受影響的行數:{},id值:{}",rows,id);
    }
    @Test
    public void testDeleteById() {
        Long id = 8L;
        int rows = attributeTemplateMapper.deleteById(id);
       log.debug("刪除完成,受影響行數:{}",rows);
    }
    @Test
    public void testDeleteByIds() {
        int rows = attributeTemplateMapper.deleteByIds(7L, 10L);
       log.debug("刪除完成,受影響行數:{}" , rows);
    }
    @Test
    public void testUpdateNameById() {
        Long id = 9L;
        String name = "羅技滑鼠";
        int rows = attributeTemplateMapper.updateNameById(id, name);
        log.debug("修改完成,受影響行數:{}" , rows);
    }
    @Test
    public void testCount(){
        int count = attributeTemplateMapper.count();
        log.debug("統計品牌數量:{}",count);
    }
    @Test
    public void testList(){
        List<AttributeTemplateListItemVO> list = attributeTemplateMapper.list();
        System.out.println("列表完成,一共有"+list.size()+"條");
        for (AttributeTemplateListItemVO attributeTemplateListItemVO : list) {
            log.debug("AttributeTemplate:{}\n",attributeTemplateListItemVO);
        }
    }


}
