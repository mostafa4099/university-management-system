package com.mostafa.university.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {
    
    @Bean
     public HibernateTemplate hibernateTemplate(){
        return new HibernateTemplate(sessionFactory().getObject());
     }
     
     @Bean
     public LocalSessionFactoryBean sessionFactory(){
         LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
         factoryBean.setDataSource(getDataSource());
         factoryBean.setPackagesToScan(new String[]{"com.mostafa.university.domain"});
         factoryBean.setHibernateProperties(hibernateProperties());
         return factoryBean;
     }
     
     @Bean
     public DataSource getDataSource(){
         BasicDataSource dataSource=new BasicDataSource();
         dataSource.setDriverClassName("com.mysql.jdbc.Driver");
         dataSource.setUrl("jdbc:mysql://localhost:3306/university");
         dataSource.setUsername("root");
         dataSource.setPassword("123");
         return dataSource;
     }
     
     @Bean
     @Autowired
     public HibernateTransactionManager transactionManager(SessionFactory factory){
         HibernateTransactionManager txManager=new HibernateTransactionManager();
         txManager.setSessionFactory(factory);
         return txManager;
     }
     
     private Properties hibernateProperties(){
        Properties properties=new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        return properties;
     }
}
