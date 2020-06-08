package com.chuweizi.script.service.impl;

import com.chuweizi.script.entity.visualization.NbPersonRoom;
import com.chuweizi.script.mapper.master.DistrictMepper;
import com.chuweizi.script.mapper.master.PersonRoomMapper;
import com.chuweizi.script.mapper.third.UserMepper;
import com.chuweizi.script.service.PersonRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PersonRoomServiceImpl implements PersonRoomService {

    @Autowired
    PersonRoomMapper personRoomMapper;

    @Autowired
    DistrictMepper districtMepper;

    @Autowired
    UserMepper userMepper;

    @Override
    public List<String> findByDistrictId(Long districtId) {
        //获取小区可视化实有人口
        List<NbPersonRoom> personRoomList = personRoomMapper.findByDistrictId(districtId);
        //获取小区物业实有人口
        String districtName = districtMepper.findById(districtId);
        Set<String> codeSet = userMepper.findByCustomerId(districtName);
        //获取可视化比物业多的人的身份证号
        List<String> list = new ArrayList<String>();
        for (NbPersonRoom personRoom : personRoomList) {
            if(codeSet.add(personRoom.getIdCode())){
                list.add(personRoom.getIdCode());
            }
        }
        return list;
    }
}
