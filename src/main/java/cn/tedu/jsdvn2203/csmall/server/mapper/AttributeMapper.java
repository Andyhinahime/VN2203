package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Attribute;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeMapper {

    /** 插入屬性資料 */
    int insert(Attribute attribute);

    /** 根據ID刪除 */
    int deleteById(Long id);

    /** 根據Id刪除多條資料 */
    int deleteByIds(Long... ids);

    /** 根據id修改名稱 */
    int updateNameById(Long id,String name);

    /** 多種不同數據更新 */
    int updateById(Attribute attribute);

    /** 統計數量 */
    int count();

    /** 根據分類名稱統計此分類名稱數量 */
    int countByName(String name);

    /**根據ID查詳情*/
    AttributeDetailVO getById(Long id);

    /** 列表 */
    List<AttributeListItemVO> list();
}
