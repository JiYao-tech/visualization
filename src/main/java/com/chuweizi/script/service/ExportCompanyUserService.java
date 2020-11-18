package com.chuweizi.script.service;


import com.chuweizi.script.entity.property.CompanyUser;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * 导出物业人员信息
 * @author ZHANGFENG
 */
public interface ExportCompanyUserService {

    /**
     * 根据小区id，查询物业员工信息
     * @param customerId 小区id
     * @return 小区物业人员信息
     */
    ArrayList<CompanyUser> findByCustomerId(@Param("customerId")int customerId);

    /**
     * 导出物业人员信息
     * @param customerId 小区Id
     */
    void writeExcel(@Param("customerId")int customerId);
}
