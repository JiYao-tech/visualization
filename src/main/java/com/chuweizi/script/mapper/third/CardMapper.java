package com.chuweizi.script.mapper.third;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;

@Repository
public interface CardMapper {

    /**
     * 根据住户id，查住户拥有的卡号
     * @param personId 住户id
     * @return 卡号列表
     */
    @Select("select CARD_NO from t_grid_pass_card WHERE PERSON_ID = #{personId} and HOLDER_NAME = #{personName}")
    ArrayList<String> findByPersonId(@Param("personId") int personId,@Param("personName") String personName);

    /**
     * 根据住户id，查住户拥有的卡号
     * @param userId 用户id
     * @return 卡号列表
     */
    @Select("select CARD_NO from t_grid_pass_card WHERE USER_ID = #{userId} and HOLDER_NAME = #{name}")
    HashSet<String> findByUser(@Param("userId") String userId, @Param("name") String name);

}
