package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.AttributeMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Attribute;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AttributeMapperTest {
    @Autowired
    AttributeMapper attributeMapper;

    @Test
    public void testInsert(){
        Attribute attribute = new Attribute();
        attribute.setName("機殼樣式");
        Long id = attribute.getId();
        int rows = attributeMapper.insert(attribute);
        log.debug("插入成功,受影響的行數:{},id值:{}",rows,id);
    }

    @Test
    public void testDeleteById(){
        Long id = 12L;
        int rows = attributeMapper.deleteById(id);
        log.debug("刪除完成,行數:{}",rows);
    }

    @Test
    public void testDeleteByIds(){
        int rows = attributeMapper.deleteByIds(13L, 15L);
        log.debug("刪除完成,受影響行數:{}",rows);
    }
    @Test
    public void testUpdateNameById(){
        Long id = 14L;
        String name = "機殼size";
        int rows = attributeMapper.updateNameById(id, name);
        log.debug("修改完成,行數:{}",rows);
    }
    @Test
    public void updateById(){
        Attribute attribute = new Attribute();
        attribute.setName("電競機殼");
        attribute.setId(11L);
        attribute.setDescription("外觀酷炫!!");
        int rows = attributeMapper.updateById(attribute);
        log.debug("修改完成,受影響行數:{}",rows);
    }

    @Test
    public void testCount(){
        int count = attributeMapper.count();
        log.debug("數量：{}",count);
    }
    @Test
    public void testList(){
        List<AttributeListItemVO> list = attributeMapper.list();
        log.debug("列表完成,共有{}條",list.size());
        for (AttributeListItemVO attributeListItemVO : list) {
            log.debug("Attribute:{}\n",attributeListItemVO);
        }
    }

}
