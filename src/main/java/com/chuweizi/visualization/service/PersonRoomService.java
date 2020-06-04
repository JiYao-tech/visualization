package com.chuweizi.visualization.service;

import com.chuweizi.visualization.entity.NbPersonRoom;

import java.util.List;

public interface PersonRoomService {

//    根据小区ID查询小区所有实有人口
    public List<NbPersonRoom> findById(Long id);
}
