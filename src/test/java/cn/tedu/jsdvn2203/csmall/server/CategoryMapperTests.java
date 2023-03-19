package cn.tedu.jsdvn2203.csmall.server;


import cn.tedu.jsdvn2203.csmall.server.mapper.CategoryMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class CategoryMapperTests {
    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void testInsert(){
        Category category = new Category();
        category.setName("蝴蝶刀");
        int rows = categoryMapper.insert(category);
        log.debug("插入成功,受影響的行數:{}",rows);
    }

    @Test
    public void testDeleteById(){
        Long id = 10L;
        int rows = categoryMapper.deleteById(id);
        log.debug("刪除完成,受影響行數:{}",rows);
    }

    @Test
    public void testDeleteByIds() {
        int rows = categoryMapper.deleteByIds(12L, 15L);
        log.debug("刪除完成,受影響行數:{}", rows);
    }

    @Test
    public void testUpdateNameById(){
        Long id = 11L;
        String name = "戰鬥突擊步槍";
        int rows = categoryMapper.updateNameById(id, name);
        log.debug("編輯完成,受影響行數:{}",rows);
    }

    @Test
    public void testUpdateById(){
        Category category = new Category();
        category.setId(13L);
        category.setName("重型機槍MMM");
        category.setIsDisplay(1);
        category.setIsParent(0);
        int rows = categoryMapper.updateById(category);
        log.debug("編輯完成,受影響行數:{}",rows);
    }
    @Test
    public void testCount(){
        int rows = categoryMapper.count();
        log.debug("查詢結果:{}條",rows);
    }

    @Test
    public void testGetById(){
        Long id = 9L;
        CategoryDetailVO categoryDetailVO = categoryMapper.getById(id);
        log.debug("查詢的結果:[{}]",categoryDetailVO);
    }

    @Test
    public void testList(){
        List<CategoryListItemVO> list = categoryMapper.list();
        log.debug("列表完成,共有{}條",list.size());
        for (CategoryListItemVO categoryListItemVO : list) {
            log.debug("Category:{}\n",categoryListItemVO);
        }
    }
}




















