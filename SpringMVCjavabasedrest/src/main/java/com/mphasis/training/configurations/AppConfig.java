package com.mphasis.training.configurations;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mphasis.training.entities.Car;
import com.mphasis.training.entities.Fuser;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.mphasis.training.*")
public class AppConfig {
	
	
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		driverManagerDataSource.setUsername("shwe");
		driverManagerDataSource.setPassword("123");
		return driverManagerDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
	localSessionFactoryBean.setDataSource(getDriverManagerDataSource());
	localSessionFactoryBean.setPackagesToScan("com.mphasis.training.entities");
	localSessionFactoryBean.setAnnotatedClasses(Fuser.class);
	localSessionFactoryBean.setAnnotatedClasses(Car.class);
	Properties hibernateProperties=new Properties();
	hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
	hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	hibernateProperties.put("hibernate.show_sql", "true");
	hibernateProperties.put("hibernate.format_sql","true");
	localSessionFactoryBean.setHibernateProperties(hibernateProperties);
	return localSessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
}
