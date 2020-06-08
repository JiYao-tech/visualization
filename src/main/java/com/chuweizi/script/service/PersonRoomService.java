package com.chuweizi.script.service;

import com.chuweizi.script.entity.visualization.NbPersonRoom;

import java.util.List;

public interface PersonRoomService {

    /**
     * 根据小区ID获取可视化比物业多的人的身份证号
     * @param districtId 小区ID
     * @return
     */
    public List<String> findByDistrictId(Long districtId);
}
