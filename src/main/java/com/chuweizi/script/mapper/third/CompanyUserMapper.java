package com.chuweizi.script.mapper.third;

import com.chuweizi.script.entity.property.CompanyUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * 查询物业公司员工信息
 * @author ZHANGFENG
 */
@Repository
public interface CompanyUserMapper {

    /**
     * 根据小区id，查询物业员工信息
     * @param customerId 小区id
     * @return 小区内所有物业员工信息
     */
    @Select("SELECT COMPANY_ID,USER_ID,NAME,PHONE,ORG_NAME,POSITION_NAME FROM t_company_org_user WHERE CUSTOMER_ID = #{customerId}")
    @Results(id = "companyUserList",value = {
            @Result(column = "COMPANY_ID",property = "companyName"),
            @Result(column = "USER_ID",property = "cardId"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "PHONE",property = "phone"),
            @Result(column = "ORG_NAME",property = "departmentName"),
            @Result(column = "POSITION_NAME",property = "jobTitle"),
    })
    ArrayList<CompanyUser> findByCustomerId(@Param("customerId")int customerId);
}
