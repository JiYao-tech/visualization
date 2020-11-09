package com.chuweizi.script.service;

import com.chuweizi.script.entity.property.Person;

import java.util.List;

public interface ExportPersonService {
    /**
     * 根据小区id,查询小区人员信息
     * @param id 小区id
     * @return 人员信息列表
     */
    List<Person> findByCustomerId(int id);

    /**
     * 输出excel文件
     * @param customerId 小区id
     */
    void writeExcel(int customerId);
}
