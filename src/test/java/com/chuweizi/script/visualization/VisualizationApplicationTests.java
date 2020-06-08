package com.chuweizi.script.visualization;

import com.chuweizi.script.VisualizationApplication;
import com.chuweizi.script.entity.property.TGridPerson;
import com.chuweizi.script.entity.visualization.NbPersonRoom;
import com.chuweizi.script.excel.BeiHua;
import com.chuweizi.script.mapper.Property.PersonMapper;
import com.chuweizi.script.mapper.propertyTest.HouseMepper;
import com.chuweizi.script.mapper.visualization.PersonRoomMapper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= VisualizationApplication.class)
public class VisualizationApplicationTests {

    @Autowired
    PersonRoomMapper personRoomMapper;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    HouseMepper houseMepper;

    //可视化实有人口
    @Test
    public void testFindByDistrictIdVisualization(){
        List<NbPersonRoom> personRoomList = personRoomMapper.findByDistrictId(30L);
        System.out.println(personRoomList);
        System.out.println(personRoomList.size());
    }

    //物业实有人口
    @Test
    public void testFindByDistrictIdProperty(){
        List<TGridPerson> personList = personMapper.findByDistrictId(40L);
        System.out.println(personList);
        System.out.println(personList.size());
    }

    @Test
    public void testUpdataByResidentIDAndHouserId() throws Exception {
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
            beiHua.setRESIDENT_ID(beiHuaList.get(2));
            beiHua.setHOUSER_NAME(beiHuaList.get(0));
            list.add(beiHua);
        }
        for (int i = 0; i < list.size(); i++) {
            houseMepper.updataByResidentIDAndHouserId(list.get(i));
            System.out.println(list.get(i));
        }
        //workbook.close();
    }
}
