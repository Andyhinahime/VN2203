package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.CategoryAttributeTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAttributeTemplateMapper {
    /** 插入 */
    int insert(CategoryAttributeTemplate categoryAttributeTemplate);

    /** ID刪除 */
    int deleteById(Long id);

    /** 若干ID刪除 */
    int deleteByIds(Long... ids);

    /** 數量 */
    int count();



}
