package cn.tedu.jsdvn2203.csmall.server.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SkuListItemVO implements Serializable {
    private Long id;
    private Long spuId;
    private String title;
    private String  barCode;
    private Long attributeTemplateId;
    private String specifications;
    private Long albumId;
    private String pictures;
    private Double price;
    private Integer stock;
    private Integer stockThreshold;
    private Integer sales;
    private Integer commentCount;
    private Integer positiveCommentCount;
    private Integer sort;
}
