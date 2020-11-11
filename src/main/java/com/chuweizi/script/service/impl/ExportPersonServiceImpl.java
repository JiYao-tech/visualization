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
import java.util.HashSet;
import java.util.Set;

/**
 * @author 36536
 */
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
            if("1".equals(person.getHolderRelation())){
                person.setHolderRelation("户主");
            }else if ("2".equals(person.getHolderRelation())){
                person.setHolderRelation("家人");
            }else if ("3".equals(person.getHolderRelation())){
                person.setHolderRelation("租户");
            }else if ("4".equals(person.getHolderRelation())){
                person.setHolderRelation("代理人");
            }else if ("5".equals(person.getHolderRelation())){
                person.setHolderRelation("租户户主");
            }else {
                person.setHolderRelation("其他");
            }

            //户口类型
            if("1".equals(person.getResidenceType())){
                person.setResidenceType("常住人口");
            }else if("2".equals(person.getResidenceType())) {
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
        return personList;
    }

    @Override
    public void writeExcel(int customerId){

        ArrayList<Person> personArrayList = findByCustomerId(customerId);

        //查询小区名称
        String custome = customerMapper.findByCustomeId(customerId);

        //创建文件保存的位置,以及文件名
        String fileName="C:\\Users\\36536\\Desktop\\"+custome+".xlsx";

        // 根据用户传入字段 假设我们要忽略 date
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("personId");

        //将数据写到Excel的第一个sheet标签中,并且给sheet标签起名字
        EasyExcel.write(fileName,Person.class).sheet("用户信息").doWrite(personArrayList);
        //文件流会自动关闭
    }
}
