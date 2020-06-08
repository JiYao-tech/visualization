package com.chuweizi.script.mapper.third;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Set;

/**
 * @author ZHANGFENG
 */
@Repository
public interface UserMepper {

    /**
     * 根据小区ID查询小区实有人口
     * @param customerName 小区ID
     * @return
     */
    /*@Select("select distinct(CARD_ID)from v_grid_user where CUSTOMER_ID=#{customerID}")
    List<String> findByCustomerId(@Param("customerID") Long customerID);*/

    @Select("select distinct(CARD_ID)from v_grid_user where CUSTOMER_ID=(SELECT CUSTOMER_ID FROM t_group_customer WHERE name = #{customerName})")
    Set<String> findByCustomerId(@Param("customerName") String customerName);
}
