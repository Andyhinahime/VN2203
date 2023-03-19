package cn.tedu.jsdvn2203.csmall.server.pojo.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class BrandCategoryListItemVO implements Serializable {
    private Long id;
    private Long brandId;
    private Long categoryId;
}
