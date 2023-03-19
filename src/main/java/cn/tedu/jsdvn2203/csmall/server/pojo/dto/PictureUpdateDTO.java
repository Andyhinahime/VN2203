package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PictureUpdateDTO implements Serializable {
    @ApiModelProperty("圖片簡介")
    private String description;
    @ApiModelProperty("圖片排序")
    private Integer sort;
    @ApiModelProperty("是否顯示")
    private Integer isCover;

}
