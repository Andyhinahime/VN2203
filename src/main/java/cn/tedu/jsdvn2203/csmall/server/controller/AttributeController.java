package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AttributeAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AttributeListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.IAttributeService;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "6.屬性管理")
@Slf4j
@RestController
@RequestMapping("attributes")
public class AttributeController {
    @Autowired
    private IAttributeService attributeService;

    @ApiOperation("添加屬性")
    @ApiOperationSupport(order = 10)
    @PostMapping("add-new")
    public JsonResult addNew(@RequestBody @Valid AttributeAddNewDTO attributeAddNewDTO){
        attributeService.addNew( attributeAddNewDTO);
        log.debug("AttributeController.addNew");
        return JsonResult.ok();
    }
    @ApiOperation("根據ID刪除屬性")
    @ApiOperationSupport(order = 20)
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult deleteById(@PathVariable Long id){
        log.debug("接收到刪除屬性請求...");
        attributeService.deleteById(id);
        return JsonResult.ok();
    }

    @ApiOperation("屬性列表")
    @ApiOperationSupport(order = 30)
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('/pms/product/read')")
    public JsonResult list(){
        log.debug("接收到屬性列表請求...");
        List<AttributeListItemVO> list = attributeService.list();
        return JsonResult.ok(list);
    }
}






















