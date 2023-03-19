package cn.tedu.jsdvn2203.csmall.server.repo;

import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;

import java.util.List;

public interface IBrandRepository {
    String kEY_PREFIX_BRAND_ITEM = "brand:item";
    String KEY_BRAND_LIST = "brand:list";

    //存資料
    void put(BrandDetailVO brandDetailVO);

    //取資料
    BrandDetailVO get(Long id);
    //刪除資料
    void deleteItem(Long id);

    //批量存資料
    void putList(List<BrandListItemVO> list);

    //批量取資料
    List<BrandListItemVO> getList();

    //批量刪除資料
    void deleteList();

}







