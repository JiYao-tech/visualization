package com.chuweizi.script.entity.property;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {
    private int  personId;
    @ExcelProperty("小区名称")
    private String customer;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("身份证号")
    private String cardId;
    @ExcelProperty("人员类型")
    private String holderRelation;
    @ExcelProperty("户籍类型")
    private String residenceType;
    @ExcelProperty("门禁卡号")
    private String cardNo;
    @ExcelProperty("房屋信息")
    private String house;
    @ExcelProperty("车辆信息")
    private String car;
}
