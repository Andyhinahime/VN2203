package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

@Data
public class PictureAddNewDTO implements Serializable {
    @ApiModelProperty(value = "圖片路徑")
    private String url;
    @ApiModelProperty(value = "圖片簡介")
    private String description;
}
