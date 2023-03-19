package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.mapper.PictureMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.PictureAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Picture;
import cn.tedu.jsdvn2203.csmall.server.service.IPictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class PictureServiceImpl implements IPictureService {

    @Autowired
    PictureMapper pictureMapper;

    @Override
    public void addNew(PictureAddNewDTO pictureAddNewDTO) {

/*
        String fileName = picFile.getOriginalFilename();
        //得到後綴名 從最後一個"."出現的位置擷取到最後
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //得到一個唯一的文件名 UUID.randomUUID() 得到一個唯一的標示符
        fileName = UUID.randomUUID() + suffix;
        System.out.println("文件名:"+fileName);
        //準備保存圖片的文件夾路徑
        String dirPath = "D:/files";
        File dirFile = new File(dirPath);
        if (!dirFile.exists()){
            dirFile.mkdirs(); //創建文件夾
        }
        //得到文件的完整路徑
        String filePath = dirPath + "/" + fileName;
        //把文件保存在此路徑中
        picFile.transferTo(new File(filePath));
*/


        Picture picture = new Picture();
        BeanUtils.copyProperties(pictureAddNewDTO,picture);
        picture.setAlbumId(0L);
        picture.setWidth(0);
        picture.setHeight(0);
        picture.setSort(0);
        picture.setIsCover(0);
        int rows = pictureMapper.insert(picture);
    }
}
