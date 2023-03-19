package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import cn.tedu.jsdvn2203.csmall.server.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.tedu.jsdvn2203.csmall.server.web.ServiceCode.*;


@Service
@Slf4j
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private IBrandRepository brandRepository;
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        //檢查品牌名稱是否存在
        String name = brandAddNewDTO.getName();
        int count = brandMapper.countByName(name);
        if (count > 0) {
            String message = "添加失敗,品牌名稱[" + name + "]已存在";
            log.error(message);
            throw new ServiceException(ERR_CONFLICT, message);
        }
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        brand.setCommentCount(0);
        brand.setSales(0);
        brand.setProductCount(0);
        brand.setPositiveCommentCount(0);
        brand.setEnable(1);
        int rows = brandMapper.insert(brand);
        if (rows != 1) {
            String message = "添加失敗,服務器忙線中,請稍後重試!";
            log.error(message);
            throw new ServiceException(ERR_INSERT, message);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("處理刪除品牌的業務...,id:{}", id);
        BrandDetailVO brandDetailVO = brandMapper.getById(id);
        if (brandDetailVO == null) {
            String message = "刪除失敗,刪除的資料ID:" + id + "不存在";
            throw new ServiceException(ERR_NOT_FOUND, message);
        }

        //調用mapper刪除方法 並返回
        int rows = brandMapper.deleteById(id);
        if (rows != 1) {
            String message = "刪除失敗,服務器忙線中,請稍後重試!";
            throw new ServiceException(ERR_DELETE, message);
        }
    }

    @Override
    public List<BrandListItemVO> list() {
        log.debug("處理品牌列表中...");
        /*
        //1.尝试从redis中获取数据
        List<BrandListItemVO> brands = brandRepository.getList();
        //2.如果redis中没有有效的数据(集合为空)，则从mysql中获取数据
        if (brands.size() == 0) {
            //3.如果从mysql中获取到数据，则将数据写入rides
            List<BrandListItemVO> dbList = brandMapper.list();
            if (dbList.size() > 0) {
                brandRepository.putList(dbList);
                return dbList;
            }
            //4.如果从mysql中没有获取到数据，则放弃向redis中写入数据
        }
        //5.返回redis的查询结果(从mysql中查询到的有效的，写入到redis中数据)*/
        //直接返回緩存中的品牌資料
        return brandRepository.getList();
    }
}
