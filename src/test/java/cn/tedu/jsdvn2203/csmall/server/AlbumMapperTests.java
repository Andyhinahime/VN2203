package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.AlbumMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AlbumDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AlbumListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class AlbumMapperTests {
    @Autowired
    AlbumMapper albumMapper;
    @Test
    public void testInsert(){
        Album album = new Album();
        album.setName("homephotos");
        int rows = albumMapper.insert(album);
        Long id = album.getId();
        System.out.println("插入數據成功,行數:"+rows+",id:"+id);
    }
    @Test
    public void deleteById(){
        Long id = 3L;
        int rows = albumMapper.deleteById(id);
        System.out.println("刪除成功,受影響的行數:"+rows);
    }
    @Test
    public void testDeleteByIds(){
        int rows = albumMapper.deleteByIds(4L, 6L);
        log.debug("刪除完成,受影響的行數:{}",rows);
    }
    @Test
    public void testUpdateNameById(){
        Long id = 4L;
        String name = "SexHcg";
        int rows = albumMapper.updateNameById(id, name);
        System.out.println("修改成功,影響行數:"+rows);
    }
    @Test
    public void testUpdateById(){
        Album album = new Album();
        album.setId(4L);
        album.setName("AVCDDSDSFGD");
        album.setDescription("yahoooooo");
        int rows = albumMapper.updateById(album);
        log.debug("修改完成,受影響的行數:{}",rows);
    }

    @Test
    public void testCount(){
        int count = albumMapper.count();
        log.debug("相冊數量為:{}",count);
    }

    @Test
    public void testGetById(){
        Long id = 2L;
        AlbumDetailVO albumMapperById = albumMapper.getById(id);
        log.debug("查詢結果：{}",albumMapperById);
    }

    @Test
    public void testList(){
        List<AlbumListItemVO> list = albumMapper.list();
        log.debug("列表完成,共有{}條",list.size());
        for (AlbumListItemVO albumListItemVO : list) {
            log.debug("Album:{}",albumListItemVO);
        }
    }

 }
