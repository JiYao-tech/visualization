package com.chuweizi.visualization.mapper;

import com.chuweizi.visualization.entity.NbPersonRoom;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PersonRoomMapper {
    @Select("\tSELECT person.`name`, person.id_code,GROUP_CONCAT(room.building_id) AS building_id, GROUP_CONCAT(room.address) AS ddress, person_room.person_id, GROUP_CONCAT(person_room.room_name) AS room_name\n" +
            "\tFROM nb_person_room person_room\n" +
            "\t\tLEFT JOIN nb_room room ON person_room.room_id = room.id\n" +
            "\t\tLEFT JOIN nb_person person ON person_room.person_id = person.id\n" +
            "\tWHERE person_room.district_id = 30\n" +
            "\t\tAND room.building_name != 'COMPANY'\n" +
            "\t\tAND room.building_name != 'ESTATE'\n" +
            "\t\tAND person_room.ended_at IS NULL\t\n" +
            "\t\tGROUP BY person_room.person_id")
    @Results(id = "PersonRoomMap",value = {
            @Result(column = "name",property ="name" ),
            @Result(column = "id_code",property ="idCode" ),
            @Result(column = "building_id",property = "buildingId"),
            @Result(column = "ddress",property = "address"),
            @Result(column = "person_id",property = "personId"),
            @Result(column = "room_name",property = "roomName")
    })
    List<NbPersonRoom> findAll(@Param("districtId") Long districtId);
}
