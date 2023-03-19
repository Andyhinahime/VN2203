package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Sku;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.SkuDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.SkuListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuMapper {

    /** 插入 */
    int insert(Sku sku);

    /** ID刪除 */
    int deleteById(Long id);

    /** 若干ID刪除 */
    int deleteByIds(Long... ids);

    /** ID修改標題 */
    int updateTitleById(Long id,String title);

    /** 修改多個資料 */
    int updateById(Sku sku);

    /** 數量 */
    int count();

    /** ID查詢詳情 */
    SkuDetailVO getById(Long id);

    /** 列表 */
    List<SkuListItemVO> list();
}
