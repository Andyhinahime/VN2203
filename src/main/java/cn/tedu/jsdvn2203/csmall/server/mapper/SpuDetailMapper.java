package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.SpuDetail;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SpuDetailMapper {
    /**插入*/
    int insert(SpuDetail spuDetail);

    /**id刪除*/
    int deleteById(Long id);

    /**若干id刪除*/
    int deleteByIds(Long... ids);



}
