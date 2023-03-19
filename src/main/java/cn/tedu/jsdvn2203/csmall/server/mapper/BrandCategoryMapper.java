package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.BrandCategory;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandCategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandCategoryMapper {
    /** 插入 */
    int insert(BrandCategory brandCategory);

    /** 刪除 */
    int deleteById(Long id);

    /** 刪除多個 */
    int deleteByIds(Long... ids);

    /** 修改多條資料 */
    int updateById(BrandCategory brandCategory);

    /** 數量 */
    int count();

    /** 列表 */
    List<BrandCategoryListItemVO> list();
}
