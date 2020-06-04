package com.chuweizi.visualization.mapper;

import com.chuweizi.visualization.entity.NbPerson;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PersonMapper {

    //通过房间找人
    /*@Select("select id,name,id_code from nb_person where id in (select person_id from nb_person_room where room_id = #{roomId} AND nb_person_room.ended_at IS NULL GROUP BY nb_person_room.id ) ")
    @Results(id = "personMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "id_code",property = "idCode")
    })
    List<NbPerson> findByPersonId(@Param("roomId") Long roomId);*/


    //通过人找房间
    @Select("select id,name,id_code from nb_person where id in (select person_id from nb_person_room where district_id = #{districtId}) ")
    @Results(id = "personMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "id_code",property = "idCode"),
            @Result(column = "id",property = "roomList",many = @Many(select = "com.chuweizi.visualization.mapper.RoomMapper.findByRoomId",fetchType = FetchType.LAZY))
    })
    List<NbPerson> findBydistrictId(@Param("districtId") Long districtId);
}
