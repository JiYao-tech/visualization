package com.chuweizi.script.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author 36536
 */
@Data
public class Person {
    @ExcelProperty("*姓名")
    private String name;

    @ExcelProperty("*工号")
    private String numBer;

    @ExcelProperty("证件号码")
    private String cardId;
}
