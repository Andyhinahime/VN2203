package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.ICategoryService;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

//@ResponseBody
//@Controller
@RestController
//類加上@RequestMapping("/categories")  統一設定前綴,在類中方法既可簡略方便管理
@RequestMapping("/categories")
@Api(tags = "1.類別管理")
@Slf4j
public class CategoryController {
    @Resource
    private ICategoryService categoryService;

    public CategoryController() {
        System.out.println("創建控制器對象.CategoryController");
    }

    @ApiOperation("添加類別")
    @PostMapping("/add-new")
    //@RequestMapping(path = "add-new")
    //@RequestMapping({"add-new"})
    //@RequestMapping(value = "add-new")
    @ApiOperationSupport(order = 10)
    public JsonResult addNew(@RequestBody @Valid CategoryAddNewDTO categoryAddNewDTO) {
        System.out.println("調用添加方法CategoryController.addNew()");
        categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok();
    }

    //訪問路徑:http://localhost:9080/categories/delete
    @ApiOperation("根據ID刪除類別")
    @PostMapping("/{id:[0-9]+}/delete")
    @ApiOperationSupport(order = 20)
    public JsonResult delete(@PathVariable("id") Long id) {
        System.out.println("id = " + id);
        System.out.println("調用刪除方法CategoryController.delete()");
        categoryService.deleteById(id);
        return JsonResult.ok();
    }

    @ApiOperation("根據ID修改類別")
    @PostMapping("/{id}:[0-9]+}/update")
    @ApiOperationSupport(order = 30)
    public String update(@PathVariable("id") Long categoryId) {
        System.out.println("categoryId = " + categoryId);
        System.out.println("CategoryController.update");
        return "update";
    }

    /*@RequestMapping("/{name:[a-zA-Z]+}/delete")
    public String deleteByName(@PathVariable("name") String  categoryname) {
        System.out.println("name = " + categoryname);
        System.out.println("調用刪除方法CategoryController.delete()");
        return "del";
    }*/

    @GetMapping("")
    @ApiOperation("類別列表")
    @ApiOperationSupport(order = 40)
    public JsonResult list() {
        log.debug("接收到分類列表請求...");
        List<CategoryListItemVO> list = categoryService.list();
        return JsonResult.ok(list);
    }
}
