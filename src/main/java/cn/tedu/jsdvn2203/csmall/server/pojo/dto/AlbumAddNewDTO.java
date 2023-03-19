package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class AlbumAddNewDTO implements Serializable {
    @ApiModelProperty(value = "相冊名稱",required = true, example = "iphone8S")
    private String name;
    @ApiModelProperty(value = "相冊簡介",required = true ,example = "蘋果手機")
    private String description;
    private Integer sort;

}
