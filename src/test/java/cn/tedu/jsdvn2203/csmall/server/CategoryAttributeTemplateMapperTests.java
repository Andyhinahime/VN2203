package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.CategoryAttributeTemplateMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.CategoryAttributeTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CategoryAttributeTemplateMapperTests {

    @Autowired
    CategoryAttributeTemplateMapper categoryAttributeTemplateMapper;

    @Test
    public void testInsert() {
        CategoryAttributeTemplate categoryAttributeTemplate = new CategoryAttributeTemplate();
        categoryAttributeTemplate.setAttributeTemplateId(3L);
        int rows = categoryAttributeTemplateMapper.insert(categoryAttributeTemplate);
        Long id = categoryAttributeTemplate.getId();
        log.debug("插入成功,受影響的行數:{},id值:{}",rows,id);
    }

    @Test
    public void testDeleteById() {
        Long id = 2L;
        int rows = categoryAttributeTemplateMapper.deleteById(id);
        log.debug("刪除完成,受影響行數:{}",rows);
    }
    @Test
    public void testDeleteByIds() {
        int rows = categoryAttributeTemplateMapper.deleteByIds(1L, 3L);
        log.debug("刪除完成,受影響行數:{}" , rows);
    }

    @Test
    public void testCount(){
        int count = categoryAttributeTemplateMapper.count();
        log.debug("數量:{}",count);
    }
}
