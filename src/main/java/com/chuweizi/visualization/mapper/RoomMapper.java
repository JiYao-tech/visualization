package com.chuweizi.visualization.mapper;

import com.chuweizi.visualization.entity.NbRoom;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoomMapper {

    /*@Select("select id, building_id, address,name FROM nb_room room where district_id = #{districtId} AND room.building_name != 'COMPANY' AND room.building_name != 'ESTATE'")
    @Results(id = "RoomMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "building_id",property = "buildingId"),
            @Result(column = "address",property = "address"),
            @Result(column = "name",property = "name"),
            @Result(column = "id",property ="personList",many = @Many(select = "com.chuweizi.visualization.mapper.PersonMapper.findByPersonId",fetchType= FetchType.LAZY))
    })
    List<NbRoom> findBydistrictId(@Param("districtId") Long districtId);*/

    @Select("select building_id, address,name FROM nb_room  where building_name != 'COMPANY' AND building_name != 'ESTATE' AND id in (select room_id from nb_person_room where person_id= #{personId} AND nb_person_room.ended_at IS NULL GROUP BY nb_person_room.id) ")
    @Results(id = "RoomMap",value = {
            @Result(column = "building_id",property = "buildingId"),
            @Result(column = "address",property = "address"),
            @Result(column = "name",property = "name"),
            @Result(column = "id",property ="personList",many = @Many(select = "com.chuweizi.visualization.mapper.PersonMapper.findByPersonId",fetchType= FetchType.LAZY))
    })
    List<NbRoom> findByRoomId(@Param("personId") Long personId);
}
