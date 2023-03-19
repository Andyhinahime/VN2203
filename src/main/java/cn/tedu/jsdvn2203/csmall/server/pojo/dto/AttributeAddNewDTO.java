package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import cn.tedu.jsdvn2203.csmall.server.service.IAttributeService;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeAddNewDTO implements Serializable {
    private String name;
    private Long templateId;
    private String valueList;
    private Integer sort;
    private Integer inputType;
    private Integer type;
    private Integer isAllowCustomize;
}
