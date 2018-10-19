package com.tablet;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.tablet")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    private ConfigurableEnvironment environment;

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Value("${liquibase.changelog}")
    private String changelog;

    @Bean
    public DataSource ds() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        return ds;
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean
    public SpringLiquibase liquibase() {
        System.out.println("Start Liquibase:");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(changelog);
        liquibase.setDataSource(ds());
        return liquibase;
    }
}
