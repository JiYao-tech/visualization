package com.chuweizi.visualization.service.impl;

import com.chuweizi.visualization.entity.NbPersonRoom;
import com.chuweizi.visualization.mapper.PersonRoomMapper;
import com.chuweizi.visualization.service.PersonRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonRoomServiceImpl implements PersonRoomService {

    @Autowired
    PersonRoomMapper personRoomMapper;

//    根据小区ID查询小区所有实有人口
    @Override
    public List<NbPersonRoom> findById(Long id) {
        return personRoomMapper.findAll(id);
    }
}
