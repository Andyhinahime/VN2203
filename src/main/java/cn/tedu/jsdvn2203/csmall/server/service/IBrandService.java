package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IBrandService {

    /**
     *  創建品牌
     * @param
     */
    void addNew(BrandAddNewDTO brandAddNewDTO);

    /**
     * 根據ID刪除
     * @param
     */
    void deleteById(Long id);

    /**
     *  查詢品牌列表
     * @return 列表
     */
    List<BrandListItemVO>list();



}
