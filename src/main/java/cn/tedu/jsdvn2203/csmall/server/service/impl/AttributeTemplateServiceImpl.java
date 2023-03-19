package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.config.BeanConfig;
import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.AttributeTemplateMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.AttributeTemplate;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeTemplateDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.IAttributeTemplateService;
import cn.tedu.jsdvn2203.csmall.server.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.tedu.jsdvn2203.csmall.server.web.ServiceCode.*;

@Service
@Slf4j
public class AttributeTemplateServiceImpl implements IAttributeTemplateService {
    @Autowired
    private AttributeTemplateMapper attributeTemplateMapper;
    @Autowired
    private BeanConfig beanConfig;
    @Override
    public void addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO) {
        String name = attributeTemplateAddNewDTO.getName();
        int count = attributeTemplateMapper.countByName(name);
        if (count > 0){
            String message = "添加模板失敗,模板名稱["+name+"]已存在";
            log.error(message);
            throw new ServiceException(ERR_CONFLICT,message);
        }
        AttributeTemplate attributeTemplate = new AttributeTemplate();

        BeanUtils.copyProperties(attributeTemplateAddNewDTO,attributeTemplate);
        if (attributeTemplate.getSort() == null){
            attributeTemplate.setSort(0);
        }
        attributeTemplate.setGmtCreate(beanConfig.dateTime());
        int rows = attributeTemplateMapper.insert(attributeTemplate);
        if (rows != 1){
         String message = "添加失敗,服務器忙線中,請稍後重試!";
         log.error(message);
         throw new ServiceException(ERR_INSERT,message);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("處理刪除品牌的業務...,id:{}",id);
        AttributeTemplateDetailVO attributeTemplateDetailVO = attributeTemplateMapper.getById(id);
        if(attributeTemplateDetailVO == null){
            String message = "刪除失敗,刪除的資料ID:"+id+"不存在";
            throw new ServiceException(ERR_NOT_FOUND,message);
        }
        int rows = attributeTemplateMapper.deleteById(id);
        if (rows != 1){
            String message = "刪除失敗,服務器忙線中,請稍後重試!";
            throw new ServiceException(ERR_DELETE,message);
        }
    }

    @Override
    public List<AttributeTemplateListItemVO> list() {
        log.debug("處理屬性模板列表...");
        return attributeTemplateMapper.list();
    }
}
