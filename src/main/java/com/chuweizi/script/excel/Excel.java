package com.chuweizi.script.excel;

import com.chuweizi.script.mapper.propertyTest.HouseMepper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Excel {

    @Autowired
    HouseMepper houseMepper;

    public static void main(String[] args) throws Exception {
        // 创建输入流，读取Excel
        InputStream is = new FileInputStream(new File("C:/Users/36536/Desktop/北华一号/北华壹号.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(is);
        XSSFSheet sheet = workbook.getSheetAt(0);
        List<BeiHua> list = new ArrayList<BeiHua>();
        for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
            List<String> beiHuaList = new ArrayList<String>();
            BeiHua beiHua = new BeiHua();
            XSSFRow cells = sheet.getRow(i);
            for (int j = 0; j < cells.getPhysicalNumberOfCells()-1; j++) {
                beiHuaList.add(cells.getCell(j).toString());
            }
            beiHua.setRESIDENT_ID(beiHuaList.get(0));
            beiHua.setHOUSER_NAME(beiHuaList.get(2));
            list.add(beiHua);
        }
        System.out.println(list);
        System.out.println(list.size());
        is.close();
        workbook.close();
    }
}
