package com.chuweizi.script.mapper.master;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author ZHANGFENG
 */
@Repository
public interface DistrictMepper {

    /**
     * 小区ID查询小区名称
     * @param id 小区ID
     * @return
     */
    @Select("SELECT name FROM nb_district WHERE id = #{id}")
    String findById(@Param("id") Long id);
}
