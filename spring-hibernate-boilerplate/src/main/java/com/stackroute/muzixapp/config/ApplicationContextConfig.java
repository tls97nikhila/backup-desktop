package com.stackroute.muzixapp.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.muzixapp.model.Track;

@Configuration
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean
	@Autowired
	public DataSource getDataSource() {

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		//set database url, username and password
		dataSource.setUrl("jdbc:mysql://localhost:3306/muzixdb");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@123");

		return dataSource;

	}

	@Bean
	@Autowired
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) throws IOException {

		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		sessionFactoryBean.setAnnotatedClasses(Track.class);
		sessionFactoryBean.setHibernateProperties(properties);
		sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean;

	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transaction = new HibernateTransactionManager();
		transaction.setSessionFactory(sessionFactory);
		return transaction;
	}

}
