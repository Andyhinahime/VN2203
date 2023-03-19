package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.PictureAddNewDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPictureService {
    /**添加圖片*/
    void addNew(PictureAddNewDTO pictureAddNewDTO);
}
