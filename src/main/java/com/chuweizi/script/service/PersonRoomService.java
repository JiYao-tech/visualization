package com.chuweizi.script.service;

import com.chuweizi.script.entity.visualization.NbPersonRoom;

import java.util.List;

public interface PersonRoomService {

    //    根据小区ID查询可视化所有实有人口
    public List<NbPersonRoom> findByDistrictId(Long districtId);
}
