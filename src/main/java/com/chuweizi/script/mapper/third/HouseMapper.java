package com.chuweizi.script.mapper.third;

import com.chuweizi.script.entity.property.House;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HouseMapper {

    /**
     * 根据小区id,查小区的所有房间
     * @param customerId 小区id
     * @return 房间列表
     */
    @Select("SELECT HOUSE_ID,HOUSE_NO,HOUSER_NAME,ADDRESS FROM t_grid_house WHERE CUSTOMER_ID = #{customerId}")
    @Results(id = "houseList",value = {
            @Result(column = "HOUSE_ID",property = "houseId"),
            @Result(column = "HOUSE_NO",property = "houseNo"),
            @Result(column = "HOUSER_NAME",property = "houseName"),
            @Result(column = "ADDRESS",property = "address")
    })
    ArrayList<House> findByCustomeId(@Param("customerId")int customerId);
}
