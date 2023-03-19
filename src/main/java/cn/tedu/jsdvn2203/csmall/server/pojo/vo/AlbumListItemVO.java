package cn.tedu.jsdvn2203.csmall.server.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
@Data
public class AlbumListItemVO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer sort;


}
