package com.bagas.spring.rest.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = "com.bagas.spring.rest")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {
	
	@Bean
	public DataSource dataSource()
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false&serverTimezone=UTC");
			dataSource.setUser("bestuser");
			dataSource.setPassword("bestuser");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.bagas.spring.rest.entity");
		
		Properties hibernaProperties = new Properties();
		hibernaProperties.setProperty("hibernate.dialect", 
				"org.hibernate.dialect.MySQLDialect");
		hibernaProperties.setProperty("hibernate.show_sql",
				"true");
		
		sessionFactory.setHibernateProperties(hibernaProperties);
		
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager transactionManager = 
				new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
























