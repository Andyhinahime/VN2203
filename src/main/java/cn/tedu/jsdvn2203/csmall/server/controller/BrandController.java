package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@ResponseBody
//@Controller
@RestController
@RequestMapping("/brands")
@Api(tags = "2.品牌管理")
@Slf4j
public class BrandController {
    @Autowired
    private IBrandService brandService;

    public BrandController() {
        System.out.println("創建控制器對象.BrandController");
    }

    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 1)
    @PostMapping("add-new")
    public JsonResult addNew(@RequestBody @Valid BrandAddNewDTO brandAddNewDTO) {
        log.debug("brandAddNewDTO = {}", brandAddNewDTO);
        log.debug("BrandController.add-new");
        brandService.addNew(brandAddNewDTO);

        return JsonResult.ok();
    }
    @ApiOperation("根據ID刪除品牌")
    @ApiOperationSupport(order = 2)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult deleteById(@PathVariable Long id) {
        log.debug("BrandController.delete");
        log.debug("id:{}" , id);
        brandService.deleteById(id);
        return JsonResult.ok();
    }

    @ApiOperation("根據ID修改品牌")
    @ApiOperationSupport(order = 3)
    @PostMapping("/update-by-id")
    public String updateById(Long id) {
        System.out.println("BrandController.update");
        System.out.println("id:" + id);
        return "BrandController.update-by-id";
    }
    @ApiOperation("品牌列表")
    @ApiOperationSupport(order = 4)
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('/pms/product/read')")
    public JsonResult list() {
        log.debug("BrandController.list");
        List<BrandListItemVO> list = brandService.list();

        return JsonResult.ok(list);

    }
}
