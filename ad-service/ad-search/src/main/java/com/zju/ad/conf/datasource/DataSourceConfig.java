package com.zju.ad.conf.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: zjumic
 * @Date: created at 22:58 2019/9/20
 */
@Configuration
@MapperScan(basePackages = "com.zju.ad.dao",sqlSessionFactoryRef="sqlSessionFactory")
public class DataSourceConfig {

    @Autowired
    private Environment env;

    /**
     * 数据源dataSource配置
     * @author liuyulin
     * @data 2019年07月25日
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setInitialSize(Integer.valueOf(env.getProperty("spring.datasource.dbcp.initial-size")));
//        dataSource.setMinIdle(Integer.valueOf(env.getProperty("spring.datasource.dbcp.min-idle")));
//        dataSource.setMaxActive(Integer.valueOf(env.getProperty("spring.datasource.dbcp.max-active")));
//        dataSource.setMaxWait(Long.valueOf(env.getProperty("spring.datasource.dbcp.max-wait")));
//        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getProperty("spring.datasource.dbcp.time-between-eviction-runs-millis")));
//        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getProperty("spring.datasource.dbcp.min-evictable-idle-time-millis")));
        dataSource.setValidationQuery(env.getProperty("spring.datasource.dbcp.validation-query"));
        dataSource.setTestWhileIdle(Boolean.valueOf(env.getProperty("spring.datasource.dbcp.test-while-idle")));
        dataSource.setTestOnBorrow(Boolean.valueOf(env.getProperty("spring.datasource.dbcp.test-on-borrow")));
        dataSource.setTestOnReturn(Boolean.valueOf(env.getProperty("spring.datasource.dbcp.test-on-return")));
        return dataSource;
    }

    /**
     * 数据源sqlSessionFactory配置
     * @author liuyulin
     * @data 2019年07月25日
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, PaginationInterceptor paginationInterceptor, GlobalConfig globalConfiguration) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        /* 数据源 */
        sqlSessionFactory.setDataSource(dataSource);
        /* 枚举扫描 */
//		sqlSessionFactory.setTypeEnumsPackage("com.jgw.supercodeplatform.insurance.enums");
        /* entity扫描,mybatis的Alias功能 */
        sqlSessionFactory.setTypeAliasesPackage("com.zju.ad.entity");
        /* entity扫描,mybatis的Alias功能 */
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        /* 驼峰转下划线 */
        configuration.setMapUnderscoreToCamelCase(false);
        /* 分页插件 */
        configuration.addInterceptor(paginationInterceptor);
        /* 允许JDBC支持自动生成主键 */
        configuration.setUseGeneratedKeys(true);
        /* 乐观锁插件 */
        configuration.addInterceptor(new OptimisticLockerInterceptor());
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setGlobalConfig(globalConfiguration);
        return sqlSessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager fakeTransactionManager(@Qualifier("dataSource") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public GlobalConfig globalConfiguration() {
        GlobalConfig conf = new GlobalConfig();
        conf.setBanner(true)// 是否打印
                .setSqlInjector(new DefaultSqlInjector()) // 逻辑注入sql
                .setDbConfig(new GlobalConfig.DbConfig()
                        .setLogicDeleteValue("1")
                        .setLogicNotDeleteValue("0")
                        .setIdType(IdType.AUTO));// 使用数据库生成方式
        return conf;
    }
}
