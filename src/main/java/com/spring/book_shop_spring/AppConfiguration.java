package com.spring.book_shop_spring;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.spring.book_shop_spring")
public class AppConfiguration {
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306");

        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }
    
    
    @Bean
    public LocalSessionFactoryBean getLocalSessionFactoryBean() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("com.spring.book_shop_spring");
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        sessionFactory.setHibernateProperties(properties);
        return sessionFactory;
    }
}
