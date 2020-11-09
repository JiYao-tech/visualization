package com.chuweizi.script.mapper.third;

import com.chuweizi.script.entity.property.House;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {

    /**
     * 根据小区id，查询小区名称
     * @param customerId 小区id
     * @return 小区名称
     */
    @Select("select NAME from t_group_customer WHERE CUSTOMER_ID = #{customerId}")
    String findByCustomeId(@Param("customerId")int customerId);

}
