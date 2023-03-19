package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.SkuSpecification;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.SkuSpecificationListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuSpecificationMapper {
    /**插入*/
    int insert(SkuSpecification skuSpecification);

    /**ID刪除*/
    int deleteById(Long id);

    /**若干ID刪除*/
    int deleteByIds(Long... ids);

    /**修改多個資料*/
    int updateById(SkuSpecification skuSpecification);

    /**數量*/
    int count();

    /**列表*/
    List<SkuSpecificationListItemVO> list();

}
