package com.chuweizi.script.mapper.propertyTest;

import com.chuweizi.script.excel.BeiHua;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseMepper {

    @Update("update t_grid_house set RESIDENT_ID=#{RESIDENT_ID} where CUSTOMER_ID=40 and HOUSER_NAME=#{HOUSER_NAME}")
    void updataByResidentIDAndHouserId(BeiHua beiHua);
}
