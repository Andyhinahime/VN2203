package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Spu;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuMapper {
    /** 插入 */
    int insert(Spu spu);

    /** ID刪除 */
    int deleteById(Long id);

    /** 若干ID刪除 */
    int deleteByIds(Long... ids);

    /** 修改多項資料 */
    int updateById(Spu spu);

    /** 數量 */
    int count();
}
