package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICategoryService {
    /**創建分類*/

    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    /**根據ID刪除*/
    void deleteById(Long id);

    /**分類列表*/
    List<CategoryListItemVO> list();

}
