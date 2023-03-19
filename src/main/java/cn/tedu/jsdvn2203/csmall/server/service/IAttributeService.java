package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AttributeAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeListItemVO;

import java.util.List;

public interface IAttributeService {
    /**創建*/
    void addNew(AttributeAddNewDTO attributeAddNewDTO);
    /**根據ID刪除*/
    void deleteById(Long id);
    /**屬性列表*/
    List<AttributeListItemVO> list();
}
