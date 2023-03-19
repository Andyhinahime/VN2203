package cn.tedu.jsdvn2203.csmall.server.pojo.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
public class AttributeTemplateAddNewDTO implements Serializable {
    @ApiModelProperty(value = "屬性模板名稱")
    @NotNull
    private String name;
}
