package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.AttributeTemplate;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeTemplateDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeTemplateListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeTemplateMapper {

    /** 插入 */
    int insert(AttributeTemplate attributeTemplate);

    /** 刪除 */
    int deleteById(Long id);

    /** 刪除多個*/
    int deleteByIds(Long... ids);

    /** 修改名稱 */
    int updateNameById(Long id,String name);

    /** 修改多條資料 */
    int updateById(AttributeTemplate attributeTemplate);

    /** 數量 */
    int count();

    /**根據模板名稱統計此模板名稱數量 */
    int countByName(String name);

    /**根據ID查詳情*/
    AttributeTemplateDetailVO getById(Long id);

    /** 列表 */
    List<AttributeTemplateListItemVO> list();
}
