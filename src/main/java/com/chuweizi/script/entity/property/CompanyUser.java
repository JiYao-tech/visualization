package com.chuweizi.script.entity.property;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 物业公司员工信息
 * @author ZHANGFENG
 */
@Data
public class CompanyUser {

    @ExcelProperty("物业公司名称")
    private String companyName;
    @ExcelProperty("小区名称")
    private String customerName;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("身份证号")
    private String cardId;
    @ExcelProperty("部门名称")
    private String departmentName;
    @ExcelProperty("职位名称")
    private String jobTitle;
}
