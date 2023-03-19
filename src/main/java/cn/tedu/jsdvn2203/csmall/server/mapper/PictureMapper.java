package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Picture;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.PictureDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.PictureListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureMapper {
    /**插入*/
    int insert(Picture picture);

    /**ID刪除*/
    int deleteById(Long id);

    /**若干ID刪除*/
    int deleteByIds(Long... ids);

    /**編輯多個數據*/
    int updateById(Picture picture);

    /**數量*/
    int count();

    /**ID查詳情*/
    PictureDetailVO getById(Long id);

    /**列表*/
    List<PictureListItemVO> list();

}
