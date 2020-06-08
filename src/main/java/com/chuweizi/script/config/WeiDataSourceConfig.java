package com.chuweizi.script.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = WeiDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "weiSqlSessionFactory")
public class WeiDataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.chuweizi.script.mapper.propertyTest";
    //static final String MAPPER_LOCATION = "classpath:mapper/Property/*.xml";

    @Value("${wei.datasource.url}")
    private String url;

    @Value("${wei.datasource.username}")
    private String user;

    @Value("${wei.datasource.password}")
    private String password;

    @Value("${wei.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "weiDataSource")
    public DataSource weiDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "weiTransactionManager")
    public DataSourceTransactionManager weiTransactionManager() {
        return new DataSourceTransactionManager(weiDataSource());
    }

    @Bean(name = "weiSqlSessionFactory")
    public SqlSessionFactory weiSqlSessionFactory(@Qualifier("weiDataSource") DataSource weiDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(weiDataSource);
        /*sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterDataSourceConfig.MAPPER_LOCATION));*/
        return sessionFactory.getObject();
    }
}
