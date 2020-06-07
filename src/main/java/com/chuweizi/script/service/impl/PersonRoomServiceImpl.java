package com.chuweizi.script.service.impl;

import com.chuweizi.script.entity.visualization.NbPersonRoom;
import com.chuweizi.script.mapper.visualization.PersonRoomMapper;
import com.chuweizi.script.service.PersonRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRoomServiceImpl implements PersonRoomService {

    @Autowired
    PersonRoomMapper personRoomMapper;

//    根据小区ID查询可视化所有实有人口
    @Override
    public List<NbPersonRoom> findByDistrictId(Long districtId) {
        return personRoomMapper.findByDistrictId(districtId);
    }
}
