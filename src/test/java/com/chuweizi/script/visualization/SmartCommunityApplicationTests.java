package com.chuweizi.script.visualization;

import com.chuweizi.script.SmartCommunityApplication;
import com.chuweizi.script.entity.property.CompanyUser;
import com.chuweizi.script.entity.property.Person;
import com.chuweizi.script.service.ExportCompanyUserService;
import com.chuweizi.script.service.ExportPersonService;
import com.chuweizi.script.service.ReadExcelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= SmartCommunityApplication.class)
public class SmartCommunityApplicationTests {

    @Autowired
    private ExportPersonService exportPersonService;

    @Autowired
    private ExportCompanyUserService exportCompanyUserService;

    @Autowired
    private ReadExcelService readExcelService;


    /**
     * 输出业主信息
     */
    @Test
    public void testWritePersonExcel(){
        //exportPersonService.writeExcel(15);
        exportPersonService.writeExcel(44);
    }

    /**
     * 查找业主信息
     */
    @Test
    public void testFindByCustomerId(){
        List<Person> personList = exportPersonService.findByCustomerId(44);
        System.out.println(personList.size());
        System.out.println(personList);
    }

    /**
     * 输出物业信息
     */
    @Test
    public void testWriteCompanyUserExcel(){
        exportCompanyUserService.writeExcel(70);
    }

    /**
     * 查找物业信息
     */
    @Test
    public void findByCustomerId(){
        ArrayList<CompanyUser> companyUserArrayList = exportCompanyUserService.findByCustomerId(44);
        System.out.println(companyUserArrayList.size());
        System.out.println(companyUserArrayList);
    }

    /**
     * 读取excel，批量修改照片名称
     */
    @Test
    public void readExcelUpdatePhotoName(){
        String path = "";
        readExcelService.readExcelUpdatePhotoName(path);
    }

    /**
     * 效验身份证合法性
     */
    @Test
    public void testVerifyIdCard(){
        String path = "";
        readExcelService.verifyIdCard(path);
    }
}
