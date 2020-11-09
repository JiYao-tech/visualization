package com.chuweizi.script.service.impl;

import com.alibaba.excel.EasyExcel;
import com.chuweizi.script.entity.property.House;
import com.chuweizi.script.entity.property.Person;
import com.chuweizi.script.mapper.third.*;
import com.chuweizi.script.service.ExportPersonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExportPersonServiceImpl implements ExportPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public ArrayList<Person> findByCustomerId(int customerId) {
        //查询人员信息
        ArrayList<Person> personList = personMapper.findByCustomerId(customerId);
        //查询小区名称
        String custome = customerMapper.findByCustomeId(customerId);
        //查询房间列表
        ArrayList<House> houseList = houseMapper.findByCustomeId(customerId);
        for (Person person : personList) {
            //设置小区名称
            person.setCustomer(custome);
            //户主关系
            if(person.getHolderRelation().equals("1")){
                person.setHolderRelation("户主");
            }else if (person.getHolderRelation().equals("2")){
                person.setHolderRelation("家人");
            }else if (person.getHolderRelation().equals("3")){
                person.setHolderRelation("租户");
            }else if (person.getHolderRelation().equals("4")){
                person.setHolderRelation("代理人");
            }else {
                person.setHolderRelation("其他");
            }

            //户口类型
            if(person.getResidenceType().equals("1")){
                person.setResidenceType("常住人口");
            }else if(person.getResidenceType().equals("2")) {
                person.setResidenceType("流动人口");
            }

            //查询人员卡号
            int personId = person.getPersonId();
            ArrayList<String> cardNoList = cardMapper.findByPersonId(personId);
            String card = StringUtils.join(cardNoList, "、");
            person.setCardNo(card);

            //查询车牌号
            ArrayList<String> carList = carMapper.findByPersonIdAndCustome(personId, customerId);
            String car = StringUtils.join(carList, "、");
            person.setCar(car);

            //修改房屋名称
            String houseId = person.getHouse();
            for (House house : houseList) {
                if(house.getHouseId().equals(houseId)){
                    person.setHouse(house.getHouseName());
                }
            }
        }
        System.out.println(personList);
        return personList;
    }

    @Override
    public void writeExcel(int customerId){

        ArrayList<Person> personArrayList = findByCustomerId(customerId);

        //创建文件保存的位置,以及文件名
        String fileName="C:\\Users\\36536\\Desktop\\Person.xlsx";

        /**
         * 构建要写入的数据
         * User类是一个自定义的特殊类,专门用来构建向Excel中写数据的类型类
         * @ExcelProperty是easyexcel提供的注解,用来定义表格的头部
         */
        //将数据写到Excel的第一个sheet标签中,并且给sheet标签起名字
        EasyExcel.write(fileName,Person.class).sheet("用户信息").doWrite(personArrayList);
        //文件流会自动关闭
    }
}
