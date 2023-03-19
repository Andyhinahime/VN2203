package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class BrandUpdateDTO implements Serializable {
    private String name;
    private String fistName;
    private String logo;
    private String type;
    private String description;
    private String keyword;
    private String sort;
}
