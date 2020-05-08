package com.meipiao.ctrip_applepie.listener.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 8:15
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = SqlServerDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlServerSqlSessionFactory")
public class SqlServerDataSourceConfig {

    // 精确到 sqlserver 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.meipiao.ctrip_applepie.listener.dao.sqlserver";//sqlserver
    static final String MAPPER_LOCATION = "classpath:mapper/sqlserver/*.xml";

    @Value("${sqlserver.datasource.url}")
    private String url;

    @Value("${sqlserver.datasource.username}")
    private String user;

    @Value("${sqlserver.datasource.password}")
    private String password;

    @Value("${sqlserver.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "sqlServerDataSource")
    public DataSource sqlServerDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "sqlServeTransactionManager")
    DataSourceTransactionManager sqlServeTransactionManager() {
        return new DataSourceTransactionManager(sqlServerDataSource());
    }

    @Bean(name = "sqlServerSqlSessionFactory")
    public SqlSessionFactory sqlServeSqlSessionFactory(@Qualifier("sqlServerDataSource") DataSource sqlServeDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(sqlServeDataSource);
//        sessionFactory.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources(sqlServeDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean(name = "sqlServeSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlServerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
