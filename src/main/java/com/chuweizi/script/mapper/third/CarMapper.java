package com.chuweizi.script.mapper.third;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarMapper {

    @Select("select CAR_NO from t_grid_car WHERE PERSON_ID = #{personId} and CUSTOMER_ID = #{customerId}")
    ArrayList<String> findByPersonIdAndCustome(@Param("personId") int personId,@Param("customerId") int customerId);
}
