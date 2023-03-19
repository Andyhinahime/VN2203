package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.config.BeanConfig;
import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.AlbumMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumUpdateDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AlbumDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AlbumListItemVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IAlbumRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.tedu.jsdvn2203.csmall.server.web.ServiceCode.*;
import static cn.tedu.jsdvn2203.csmall.server.web.ServiceCode.ERR_DELETE;

@Service
@Slf4j
public class AlbumServiceImpl implements IAlbumService {
    /*@Autowired
    public IAlbumRepository albumRepository;*/
    @Autowired
    BeanConfig beanConfig;

    @Autowired
    private AlbumMapper albumMapper;
    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO) {
        String name = albumAddNewDTO.getName();
        int count = albumMapper.countByName(name);
        if (count > 0 ){
            String message = "添加失敗,相冊名稱["+name+"]已存在";
            log.error(message);
            throw new ServiceException(ERR_CONFLICT,message);
        }
        Album album = new Album();
        BeanUtils.copyProperties(albumAddNewDTO,album);
        album.setGmtCreate(beanConfig.dateTime());
        int rows = albumMapper.insert(album);
        if (rows != 1){
            String message = "添加失敗,服務器忙線中,請稍後重試!";
            log.error(message);
            throw new ServiceException(ERR_INSERT,message);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("處理刪除相冊的業務...,id:{}",id);
        AlbumDetailVO albumDetailVO = albumMapper.getById(id);
        if (albumDetailVO == null){
            String message =  "刪除失敗,刪除的資料ID:"+id+"不存在";
            throw new ServiceException(ERR_NOT_FOUND,message);
        }
        int rows = albumMapper.deleteById(id);
        if (rows != 1){
            String message = "刪除失敗,服務器忙線中,請稍後重試!";
            throw new ServiceException(ERR_DELETE,message);
        }
    }

    @Override
    public List<AlbumListItemVO> list() {
        log.debug("處理相冊列表中...");
        return albumMapper.list();
    }
}
