package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    /**插入*/
    int insert(Category category);

    /**ID刪除*/
    int deleteById(Long id);

    /**若干ID刪除*/
    int deleteByIds(Long... ids);

    /**ID修改名稱*/
    int updateNameById(Long id,String name);

    /**修改多條數據*/
    int updateById(Category category);

    /**數量*/
    int count();

    /** 根據名稱統計此名稱數量 */
    int countByName(String name);

    /** 根據上級ID統計上級的子級數量 */
    int countByParentId(Long parentId);

    /**ID查詳情*/
    CategoryDetailVO getById(Long id);

    /**列表*/
    List<CategoryListItemVO> list();

}
