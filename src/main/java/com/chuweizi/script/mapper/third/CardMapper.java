package com.chuweizi.script.mapper.third;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CardMapper {

    /**
     * 根据住户id，查住户拥有的卡号
     * @param personId 住户id
     * @return 卡号列表
     */
    @Select("select CARD_NO from t_grid_pass_card WHERE PERSON_ID = #{personId}")
    ArrayList<String> findByPersonId(@Param("personId") int personId);
}
