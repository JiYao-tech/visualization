package com.chuweizi.script.mapper.third;

import com.chuweizi.script.entity.property.House;
import com.chuweizi.script.entity.property.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface PersonMapper {
    /**
     * 根据小区id，查询小区人员信息
     * @param customerId 小区id
     * @return 人员列表
     */
    @Select("SELECT CARD_ID,PERSON_ID,NAME,CONTACT_PHONE,HOLDER_RELATION,RESIDENCE_TYPE,HOUSE_ID FROM t_grid_person WHERE CUSTOMER_ID = #{customerId} and STATUS = 1")
    @Results(id = "personList",value = {
            @Result(column = "PERSON_ID",property = "personId"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "CONTACT_PHONE",property = "phone"),
            @Result(column = "CARD_ID",property = "cardId"),
            @Result(column = "HOLDER_RELATION",property = "holderRelation"),
            @Result(column = "RESIDENCE_TYPE",property = "residenceType"),
            @Result(column = "HOUSE_ID",property = "house"),
    })
    ArrayList<Person> findByCustomerId(@Param("customerId")int customerId);

}
