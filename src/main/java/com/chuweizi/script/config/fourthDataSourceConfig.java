//package com.chufourthzi.script.config;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//// 扫描 Mapper 接口并容器管理
//@MapperScan(basePackages = fourthDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "fourthSqlSessionFactory")
//public class fourthDataSourceConfig {
//
//    // 精确到 cluster 目录，以便跟其他数据源隔离
//    static final String PACKAGE = "com.chufourthzi.script.mapper.fourth";
//    //static final String MAPPER_LOCATION = "classpath:mapper/fourth/*.xml";
//
//    @Value("${fourth.datasource.url}")
//    private String url;
//
//    @Value("${fourth.datasource.username}")
//    private String user;
//
//    @Value("${fourth.datasource.password}")
//    private String password;
//
//    @Value("${fourth.datasource.driverClassName}")
//    private String driverClass;
//
//    @Bean(name = "fourthDataSource")
//    public DataSource fourthDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(url);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean(name = "fourthTransactionManager")
//    public DataSourceTransactionManager fourthTransactionManager() {
//        return new DataSourceTransactionManager(fourthDataSource());
//    }
//
//    @Bean(name = "fourthSqlSessionFactory")
//    public SqlSessionFactory fourthSqlSessionFactory(@Qualifier("fourthDataSource") DataSource fourthDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(fourthDataSource);
//        /*sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(MasterDataSourceConfig.MAPPER_LOCATION));*/
//        return sessionFactory.getObject();
//    }
//}
