package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PictureDeleteDTO implements Serializable {
    @ApiModelProperty("相冊ID")
    private Long albumId;
    @ApiModelProperty("圖片ID")
    private Long id;
}
