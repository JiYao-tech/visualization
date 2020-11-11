package com.chuweizi.script.service.impl;

import com.chuweizi.script.entity.property.CompanyUser;
import com.chuweizi.script.mapper.third.CompanyMapper;
import com.chuweizi.script.mapper.third.CompanyUserMapper;
import com.chuweizi.script.mapper.third.UserMapper;
import com.chuweizi.script.service.ExportCompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    @Override
    public ArrayList<CompanyUser> findByCustomerId(int customerId) {
        //查询小区物业人员信息
        ArrayList<CompanyUser> companyUserArrayList = companyUserMapper.findByCustomerId(customerId);
        for (CompanyUser companyUser : companyUserArrayList) {
            //找出员工所在公司的名称
            String companyName = companyMapper.findByCompanyId(companyUser.getCompanyName());
            companyUser.setCompanyName(companyName);

            //找出员工的身份证号
            String userCard = userMapper.findByUserId(companyUser.getCardId());
            companyUser.setCardId(userCard);

        }
        return companyUserArrayList;
    }
}
