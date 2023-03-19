package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.PictureAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.service.IPictureService;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
@Api(tags = "4.圖片管理")
@RequestMapping("/pictures")
@Slf4j
public class PictureController {
    @Autowired
    private IPictureService pictureService;
    public PictureController() {
        System.out.println("創建控制器對象.PictureController");
    }

    @ApiOperation("添加圖片")
    @ApiOperationSupport(order = 10)
    @PostMapping("add-new")
    public JsonResult addNew(PictureAddNewDTO pictureAddNewDTO){
        pictureService.addNew(pictureAddNewDTO);
        return JsonResult.ok();
    }

    @ApiOperation("ID刪除圖片")
    @ApiOperationSupport(order = 20)
    @PostMapping("/delete-by-id")
    public String deleteById(Long id){
        return "delete OK";
    }

    @ApiOperation("ID編輯圖片")
    @ApiOperationSupport(order = 30)
    @PostMapping("/update-by-id")
    public String updateById(Long id){
        return "update OK";
    }
    @ApiOperation("圖片相冊列表")
    @ApiOperationSupport(order = 40)
    @GetMapping("")
    public String list(){
        return "list OK";
    }

}












