package cn.tedu.jsdvn2203.csmall.server.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeTemplateDetailVO implements Serializable {
    private Long id;
    private  String name;
    private String pinyin;
    private String keywords;
    private Integer sort;

}
