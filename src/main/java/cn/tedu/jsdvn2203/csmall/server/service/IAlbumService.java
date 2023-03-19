package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AlbumListItemVO;

import java.util.List;

public interface IAlbumService {
    /** 創建相冊 */
    void addNew(AlbumAddNewDTO albumAddNewDTO);
    /**根據ID刪除*/
    void deleteById(Long id);
    /**相冊列表*/
    List<AlbumListItemVO> list();
}
