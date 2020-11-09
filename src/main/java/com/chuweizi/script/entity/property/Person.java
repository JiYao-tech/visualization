package com.chuweizi.script.entity.property;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Person {
    @ExcelProperty("人员id")
    private int  personId;
    @ExcelProperty("小区名称")
    private String customer;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("身份证号")
    private String cardId;
    @ExcelProperty("户主关系")
    private String holderRelation;
    @ExcelProperty("身份类型")
    private String residenceType;
    @ExcelProperty("房间号")
    private String house;
    @ExcelProperty("门禁卡号")
    private String cardNo;
    @ExcelProperty("车牌号")
    private String car;
}
