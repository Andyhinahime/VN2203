package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.PictureMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Picture;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.PictureDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.PictureListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@SpringBootTest
public class PictureMapperTests {
    @Autowired
    PictureMapper pictureMapper;

    @Test
    public void testInsert(){
        Picture picture = new Picture();
        picture.setAlbumId(3L);
        picture.setUrl("模擬數據: 高爆手榴彈圖片URL");
        picture.setWidth(1600);
        picture.setHeight(900);
        int rows = pictureMapper.insert(picture);
        log.debug("插入完成,受影響行數:{}",rows);
    }

    @Test
    public void testDeleteById(){
        Long id = 13L;
        int rows = pictureMapper.deleteById(id);
        log.debug("刪除完成,受影響行數:{}",rows);
    }

    @Test
    public void testDeleteByIds(){
        int rows = pictureMapper.deleteByIds(11L,14L,16L);
        log.debug("刪除完成,受影響行數:{}",rows);
    }

    @Test
    public void testUpdateById(){
        Picture picture = new Picture();
        picture.setId(12L);
        picture.setUrl("模擬數據: 戰鬥突擊步槍圖片URL");
        picture.setDescription("中近距離效果極佳,有效壓制敵人,適合各類步兵使用");
        int rows = pictureMapper.updateById(picture);
        log.debug("修改完成,受影響行數:{}",rows);
    }

    @Test
    public void testCount(){
        int count = pictureMapper.count();
        log.debug("查詢完成,共有{}條數據",count);
    }

    @Test
    public void testGetById(){
        Long id = 12L;
        PictureDetailVO pictureDetailVO = pictureMapper.getById(id);
        log.debug("查詢的結果{}:",pictureDetailVO);
    }

    @Test
    public void testList(){
        List<PictureListItemVO> list = pictureMapper.list();
        log.debug("列表完成,共有{}條",list.size());
        for (PictureListItemVO pictureListItemVO : list) {
            log.debug("Brand:{}\n",pictureListItemVO);
        }
    }

}
