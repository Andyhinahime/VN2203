package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.config.BeanConfig;
import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.AttributeMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AttributeAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Attribute;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.IAttributeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.tedu.jsdvn2203.csmall.server.web.ServiceCode.*;

@Service
@Slf4j
public class AttributeServiceImpl implements IAttributeService {
    @Autowired
    AttributeMapper attributeMapper;
    @Autowired
    BeanConfig beanConfig;
    @Override
    public void addNew(AttributeAddNewDTO attributeAddNewDTO) {
        String name = attributeAddNewDTO.getName();
        int count = attributeMapper.countByName(name);
        if (count > 0 ){
            String message = "添加失敗,分類名稱["+name+"]已存在";
            log.error(message);
            throw new ServiceException(ERR_CONFLICT,message);
        }
        Attribute attribute = new Attribute();
        BeanUtils.copyProperties(attributeAddNewDTO,attribute);
        attribute.setGmtCreate(beanConfig.dateTime());
        int rows = attributeMapper.insert(attribute);
        if ( rows != 1){
            String message = "添加失敗,服務器忙線中,請稍後重試!";
            log.error(message);
            throw new ServiceException(ERR_INSERT,message);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("處理刪除分類業務...,id:{}",id);
        AttributeDetailVO attributeDetailVO = attributeMapper.getById(id);
        if (attributeDetailVO == null){
            String message = "刪除失敗,刪除的資料ID:"+id+"不存在";
            throw new ServiceException(ERR_NOT_FOUND,message);
        }
        int rows = attributeMapper.deleteById(id);
        if (rows != 1){
            String message = "刪除失敗,服務器忙線中,請稍後重試!";
            throw new ServiceException(ERR_DELETE,message);
        }
    }

    @Override
    public List<AttributeListItemVO> list() {
        log.debug("處理屬性列表中...");
        return attributeMapper.list();
    }
}
