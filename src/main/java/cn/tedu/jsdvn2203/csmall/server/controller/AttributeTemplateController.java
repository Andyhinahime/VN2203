package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AttributeTemplateAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeTemplateListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.IAttributeTemplateService;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/attribute-template")
@Api(tags = "5.屬性模板管理")
@Slf4j
public class AttributeTemplateController {
    @Autowired
    private IAttributeTemplateService attributeTemplateService;

    public AttributeTemplateController() {
       log.debug("創建控制器對象:AttributeTemplateController");
    }

    @ApiOperation("添加屬性模板")
    @ApiOperationSupport(order = 10)
    @PostMapping("add-new")
    public JsonResult addNew(@RequestBody @Valid AttributeTemplateAddNewDTO attributeTemplateAddNewDTO){
        log.debug("attributeTemplateAddNewDTO:{} , add-new",attributeTemplateAddNewDTO);
        attributeTemplateService.addNew(attributeTemplateAddNewDTO);
        return JsonResult.ok();
    }
    @ApiOperation("根據ID刪除屬性模板")
    @ApiOperationSupport(order = 20)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult deleteById(@PathVariable Long id){
        attributeTemplateService.deleteById(id);
        return JsonResult.ok();
    }
    @ApiOperation("屬性模板列表")
    @ApiOperationSupport(order = 30)
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('/pms/product/read')")
    public JsonResult list(){
        List<AttributeTemplateListItemVO> list = attributeTemplateService.list();
        return JsonResult.ok(list);
    }
}
