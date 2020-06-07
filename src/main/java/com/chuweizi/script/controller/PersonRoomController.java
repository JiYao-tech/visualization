package com.chuweizi.script.controller;

import com.chuweizi.script.entity.visualization.NbPersonRoom;
import com.chuweizi.script.service.PersonRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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

    @GetMapping("/{districtId}")
    @ResponseBody
    @ApiOperation("根据小区ID查询可视化所有实有人口")
    @ApiImplicitParam(name = "id", value = "小区ID")
    public List<NbPersonRoom> findById(@PathVariable("districtId") Long districtId){
        return personRoomService.findByDistrictId(districtId);
    }
}
