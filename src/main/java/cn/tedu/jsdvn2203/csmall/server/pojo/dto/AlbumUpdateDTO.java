package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class AlbumUpdateDTO implements Serializable {
    private String name;
    private String description;
    private Integer sort;
}
