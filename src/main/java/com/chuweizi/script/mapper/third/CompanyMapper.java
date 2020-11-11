package com.chuweizi.script.mapper.third;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *查询物业公司信息
 * @author ZHANGFENG
 */
@Repository
public interface CompanyMapper {

    /**
     * 根据公司id，查询公司名称
     * @param companyId 公司id
     * @return 公司名称
     */
    @Select("SELECT name FROM t_company WHERE COMPANY_ID = #{companyId}")
    String findByCompanyId(@Param("companyId") String companyId);
}
