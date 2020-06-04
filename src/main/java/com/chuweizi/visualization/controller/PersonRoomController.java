package com.chuweizi.visualization.controller;

import com.chuweizi.visualization.entity.NbPersonRoom;
import com.chuweizi.visualization.service.PersonRoomService;
import com.chuweizi.visualization.service.impl.PersonRoomServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "查询可视化平台接口")
@RequestMapping("/visualization")
public class PersonRoomController {

    @Autowired
    PersonRoomService personRoomService;

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation("根据小区ID查询可视化实有人口")
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "小区ID"),
           })*/
    @ApiImplicitParam(name = "id", value = "小区ID")
    public List<NbPersonRoom> findById(@PathVariable("id") Long id){
        return personRoomService.findById(id);
    }
}
