package com.chuweizi.script.visualization;

import com.alibaba.excel.EasyExcel;
import com.chuweizi.script.SmartCommunityApplication;
import com.chuweizi.script.entity.property.CompanyUser;
import com.chuweizi.script.entity.property.House;
import com.chuweizi.script.entity.property.Person;
import com.chuweizi.script.mapper.third.HouseMapper;
import com.chuweizi.script.mapper.third.PersonMapper;
import com.chuweizi.script.service.ExportCompanyUserService;
import com.chuweizi.script.service.ExportPersonService;
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
    private HouseMapper houseMapper;

    @Autowired
    private ExportCompanyUserService exportCompanyUserService;

    @Test
    public void findPersonList(){
        //exportPersonService.writeExcel(15);
        exportPersonService.writeExcel(63);
    }

    @Test
    public void Test01(){
        List<Person> personList = exportPersonService.findByCustomerId(63);
        System.out.println(personList.size());
        System.out.println(personList);
    }

    @Test
    public void Test02(){
        ArrayList<CompanyUser> companyUserArrayList = exportCompanyUserService.findByCustomerId(65);
        System.out.println(companyUserArrayList.size());
        System.out.println(companyUserArrayList);
    }

}
