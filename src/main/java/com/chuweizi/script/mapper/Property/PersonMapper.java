package com.chuweizi.script.mapper.Property;

import com.chuweizi.script.entity.property.TGridPerson;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonMapper {
    @Select("SELECT NAME,GENDER,CARD_ID,AGE,ADDRESS FROM t_grid_person WHERE CARD_ID in (SELECT DISTINCT(CARD_ID) FROM t_grid_person WHERE CUSTOMER_ID=#{districtId})")
    @Results(id = "personMap",value = {
            @Result(id = true,column = "PERSON_ID",property = "personId"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "GENDER",property = "gender"),
            @Result(column = "CARD_ID",property = "cardId"),
            @Result(column = "AGE",property = "age"),
            @Result(column = "ADDRESS",property = "address"),
    })
    List<TGridPerson> findByDistrictId(@Param("districtId") Long districtId);
}
