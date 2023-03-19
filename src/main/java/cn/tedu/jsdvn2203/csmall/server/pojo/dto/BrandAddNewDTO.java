package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import cn.tedu.jsdvn2203.csmall.server.validtion.BrandValidationConst;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;
import static cn.tedu.jsdvn2203.csmall.server.validtion.BrandValidationConst.*;
/*
*  新增商品DTO類
*  添加set/get/equals/toString方法
* */
@Data
public class BrandAddNewDTO implements Serializable {
    @ApiModelProperty(value = "品牌名稱",required = true,example = "華碩")
   // @NotNull(message = "請填寫有效的品牌名稱-null")
   // @NotEmpty(message = "請填寫有效的品牌名稱 -empty")
    @NotBlank(message = "請填寫有效的品牌名稱")
    private String name;
    @ApiModelProperty(value = "品牌拼音",required = true,example = "asus")
    @NotBlank(message = "請填寫有效的品牌拼音")
    @Pattern(regexp = REGEXP_PINYIN, message = MESSAGE_PINYIN)
    private String pinyin;
    @ApiModelProperty(value = "品牌logo",required = true)
    private String logo;
    @ApiModelProperty("類別ID")
    private Long categoryId;
    @ApiModelProperty(value = "品牌簡介",example = "台灣優良品牌")
    private String description;
    @ApiModelProperty(value = "關鍵詞列別(以逗號分隔",example = "華碩,asus")
    private String keywords;
    @ApiModelProperty(value = "自定義排序",example = "11")
    @Range(min = 1 , max = 99 ,message = "排序值長度為0~99之間")
    private Integer sort;


}
