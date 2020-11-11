package com.chuweizi.script.mapper.third;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *查询用户信息
 * @author ZHANGFENG
 */
@Repository
public interface UserMapper {

    /**
     * 根据用户id，查询用户身份证号；
     * @param userId 用户id
     * @return 用户身份证号
     */
    @Select("SELECT CARD_ID FROM t_user WHERE USER_ID = #{userId}")
    String findByUserId(@Param("userId") String userId);
}
