package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.CategoryMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cn.tedu.jsdvn2203.csmall.server.web.ServiceCode.*;

@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public CategoryServiceImpl() {
        System.out.println("創建業務邏輯對象.CategoryServiceImpl");
    }

    @Override
    @Transactional
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        String name = categoryAddNewDTO.getName();

        //獲取參數中的parentId
        Long parentId = categoryAddNewDTO.getParentId();
        CategoryDetailVO parentCategory = null;
        if (parentId != 0) {
            parentCategory = categoryMapper.getById(parentId);
            //判斷上級類別是否存在
            if (parentCategory == null) {
                String message = "新增類別失敗,上級類別不存在!";
                throw new ServiceException(ERR_NOT_FOUND, message);
            }
        }


        int count = categoryMapper.countByName(name);
        if (count > 0) {
            String message = "添加失敗,分類名稱[" + name + "]已存在";
            log.error(message);
            throw new ServiceException(ERR_CONFLICT, message);
        }
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewDTO, category);

        if (parentId == 0) {
            category.setDepth(1);
        } else {
            category.setDepth(parentCategory.getDepth() + 1);

        }

        //此時類別是新的類別,不會有子級,所以isParent固定為0
        category.setIsParent(0);

        int rows = categoryMapper.insert(category);
        if (rows != 1) {
            String message = "添加失敗,服務器忙線中,請稍後重試!";
            log.error(message);
            throw new ServiceException(ERR_INSERT, message);
        }
        if (parentId != 0 && parentCategory.getIsParent() == 0) {
            Category c = new Category();
            c.setId(parentId);
            c.setIsParent(1);
            rows = categoryMapper.updateById(c);
            if (rows != 1) {
                String message = "添加失敗,請稍後重試!";
                log.error(message);
                throw new ServiceException(ERR_INSERT, message);
            }
        }


    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.debug("處理刪除分類的業務..., id:{}", id);
        CategoryDetailVO categoryDetailVO = categoryMapper.getById(id);
        if (categoryDetailVO == null) {
            String message = "刪除失敗,刪除的分類ID:[" + id + "]不存在";
            throw new ServiceException(ERR_NOT_FOUND, message);
        }

        {
            //4.檢查當前類別是否存在子級類別
            int count = categoryMapper.countByParentId(id);
            if (count >0){
                String message = "刪除失敗,當前類別存在下級類別,不允許刪除!";
                log.debug(message);
                throw new ServiceException(ERR_DELETE, message);
            }
        }

        int rows = categoryMapper.deleteById(id);
        if (rows != 1) {
            String message = "刪除失敗,服務器忙線中,請稍後重試!";
            throw new ServiceException(ERR_DELETE, message);
        }

        //檢查是否有必要將上級的isParent改為0
        //1.獲取parentId
        Long parentId = categoryDetailVO.getParentId();
        //2.根據上級id統計子級類別的數量
        int parentIdCount = categoryMapper.countByParentId(parentId);
        //3.檢查是否有必要將父及類別的isParent改為0
        if (parentIdCount == 0){
            Category c = new Category();
            c.setId(parentId);
            c.setIsParent(0);
            rows = categoryMapper.updateById(c);
            if (rows != 1) {
                String message = "刪除失敗,請稍後重試!";
                throw new ServiceException(ERR_DELETE, message);
            }
        }
    }

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("處理分類列表中...");
        return categoryMapper.list();
    }
}
