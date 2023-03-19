package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.BrandCategoryMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.BrandCategory;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandCategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import jdk.nashorn.internal.objects.annotations.SpecializedFunction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BrandCategoryMapperTests {
    @Autowired
    BrandCategoryMapper brandCategoryMapper;

    @Test
    public void testInsert() {
        BrandCategory brandCategory = new BrandCategory();
        brandCategory.setBrandId(3L);
        int rows = brandCategoryMapper.insert(brandCategory);
        Long id = brandCategory.getId();
        log.debug("插入成功,受影響的行數:{},id值:{}",rows,id);
    }
    @Test
    public void testDeleteById() {
        Long id = 10L;
        int rows = brandCategoryMapper.deleteById(id);
        log.debug("刪除完成,受影響行數:{}",rows);
    }
    @Test
    public void testDeleteByIds() {
        int rows = brandCategoryMapper.deleteByIds(9L, 11L);
        log.debug("刪除完成,受影響行數:{}" , rows);
    }
    @Test
    public void testList(){
        List<BrandCategoryListItemVO> list = brandCategoryMapper.list();
        System.out.println("列表完成,一共有"+list.size()+"條");
        for (BrandCategoryListItemVO brandCategoryListItemVO : list) {
            log.debug("Brand:{}\n",brandCategoryListItemVO);
        }
    }

}
