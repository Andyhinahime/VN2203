package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeTemplateListItemVO;

import java.util.List;

public interface IAttributeTemplateService {
    /**創建模板*/
    void addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO);
    /**根據ID刪除*/
    void deleteById(Long id);
    /**屬性模板列表*/
    List<AttributeTemplateListItemVO> list();
}
