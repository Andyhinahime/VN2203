package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class CategoryUpdateDTO implements Serializable {
    private Long parentId;
    private String name;
    private Integer sort;
    private Integer enable;
    private Integer isDisplay;
    private String icon;
    private String keywords;
}
