package com.chuweizi.script.service.impl;

import com.alibaba.excel.EasyExcel;
import com.chuweizi.script.entity.property.CompanyUser;
import com.chuweizi.script.entity.property.Person;
import com.chuweizi.script.mapper.third.*;
import com.chuweizi.script.service.ExportCompanyUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 导出物业员工信息
 * @author ZHANGFENG
 */
@Service
public class ExportCompanyUserServiceImpl implements ExportCompanyUserService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyUserMapper companyUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public ArrayList<CompanyUser> findByCustomerId(int customerId) {
        //查询小区物业人员信息
        ArrayList<CompanyUser> companyUserArrayList = companyUserMapper.findByCustomerId(customerId);
        for (CompanyUser companyUser : companyUserArrayList) {
            //找出员工所在公司的名称
            String companyName = companyMapper.findByCompanyId(companyUser.getCompanyName());
            companyUser.setCompanyName(companyName);

            //找出小区名称
            companyUser.setCustomerName(customerMapper.findByCustomeId(customerId));

            //查卡号
            HashSet<String> cardSet = cardMapper.findByUser(companyUser.getCardId(),companyUser.getName());
            String card = StringUtils.join(cardSet, "、");
            companyUser.setCard(card);

            //找出员工的身份证号
            String userCard = userMapper.findByUserId(companyUser.getCardId());
            companyUser.setCardId(userCard);

        }
        return companyUserArrayList;
    }

    @Override
    public void writeExcel(int customerId) {
        ArrayList<CompanyUser> companyUserArrayList = findByCustomerId(customerId);

        //查询小区名称
        String custome = customerMapper.findByCustomeId(customerId);

        //创建文件保存的位置,以及文件名
        String fileName="C:\\Users\\36536\\Desktop\\江夏导入物业\\"+custome+"物业.xlsx";

        // 根据用户传入字段 假设我们要忽略 date
        Set<String> excludeColumnFiledNames = new HashSet<String>();
        excludeColumnFiledNames.add("personId");

        //将数据写到Excel的第一个sheet标签中,并且给sheet标签起名字
        EasyExcel.write(fileName,CompanyUser.class).sheet("物业信息").doWrite(companyUserArrayList);
        //文件流会自动关闭
    }
}
