package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.AlbumListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ResponseBody
//@Controller
@RestController
@RequestMapping("/albums")
@Api(tags = "3.相冊管理")
@Slf4j
public class AlbumController {
    @Autowired
    public IAlbumService albumService;

    public AlbumController() {
        System.out.println("創建控制器對象.AlbumController");
    }

    @PostMapping("add-new")
    @ApiOperation("添加相冊")
    @ApiOperationSupport(order = 10)
    public JsonResult addNew(AlbumAddNewDTO albumAddNewDTO) {
        log.debug("接收到添加相冊任務");
        albumService.addNew(albumAddNewDTO);
        return JsonResult.ok();
    }

    @PostMapping("/{id:[0-9]+}/delete")
    @ApiOperation("根據ID刪除相冊")
    @ApiOperationSupport(order = 20)
    public JsonResult deleteById(@PathVariable Long id) {
        log.debug("id:{}", id);
        albumService.deleteById(id);
        return JsonResult.ok();
    }

    @PostMapping("update-by-id")
    @ApiOperation("根據ID修改相冊")
    @ApiOperationSupport(order = 30)
    public String updateById(Long id){
        log.debug("接收到編輯相冊任務");
        return "OK";
    }

    @ApiOperation("相冊列表")
    @ApiOperationSupport(order = 40)
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('/pms/product/read')")
    public JsonResult list(){
        List<AlbumListItemVO> list = albumService.list();
        return JsonResult.ok(list);
    }






}
