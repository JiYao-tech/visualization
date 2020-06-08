package com.chuweizi.script.mapper.master;

import com.chuweizi.script.entity.visualization.NbPersonRoom;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZHANGFENG
 */
@Repository
public interface PersonRoomMapper {

    /**
     * 根据小区ID查询实有人口
     * @param districtId 小区ID
     * @return
     */
    @Select("\t#查找可视化平台某个小区所有的人口的详细信息\n" +
            "SELECT person.`name`, person.id_code, p_set.building_id, p_set.person_id,p_set.address, p_set.room_name\n" +
            "\t, p_set.address\n" +
            "FROM (\n" +
            "\tSELECT person_room.person_id, GROUP_CONCAT(room.building_id) AS building_id, GROUP_CONCAT(person_room.room_name) AS room_name\n" +
            "\t\t, GROUP_CONCAT(room.address) AS address\n" +
            "\tFROM nb_person_room person_room\n" +
            "\t\tLEFT JOIN nb_room room ON person_room.room_id = room.id\n" +
            "\tWHERE person_room.district_id = #{districtId}\n" +
            "\t\tAND room.building_name != 'COMPANY'\n" +
            "\t\tAND room.building_name != 'ESTATE'\n" +
            "\t\tAND person_room.ended_at IS NULL\n" +
            "\tGROUP BY person_room.person_id\n" +
            ") p_set\n" +
            "\tLEFT JOIN nb_person person ON p_set.person_id = person.id")
    @Results(id = "PersonRoomMap",value = {
            @Result(column = "name",property ="name" ),
            @Result(column = "id_code",property ="idCode" ),
            @Result(column = "building_id",property = "buildingId"),
            @Result(column = "ddress",property = "address"),
            @Result(column = "person_id",property = "personId"),
            @Result(column = "room_name",property = "roomName")
    })
    List<NbPersonRoom> findByDistrictId(@Param("districtId") Long districtId);
}
