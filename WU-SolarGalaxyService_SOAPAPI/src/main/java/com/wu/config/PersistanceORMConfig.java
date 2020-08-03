package com.wu.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class PersistanceORMConfig {

    private static final Logger LOG = LoggerFactory.getLogger(PersistanceORMConfig.class);

    //@Value("${spring.datasource.jndi-name}")
    //private String msSqlServerJndiName;

    
	/*
	 * @Bean("dataSource") public DataSource createDataSource() {
	 * 
	 * DataSource dataSource = null; try {
	 * 
	 * JndiTemplate jndi = new JndiTemplate(); dataSource = jndi.lookup(
	 * msSqlServerJndiName, DataSource.class);
	 * 
	 * } catch (NamingException ex) {
	 * LOG.error("NamingException for MsSqlServerConfig: {}", msSqlServerJndiName,
	 * ex); } return dataSource; }
	 */
    @Bean
    public HikariDataSource createHikariDataSource() {
    	
    	HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername("system");
		ds.setPassword("manager");

    	return ds;
    	
    }
    
	@Bean
	public LocalSessionFactoryBean createLocalSessionFactoryBean() {
		
		LocalSessionFactoryBean bean = null;
		Properties props=null;
		
		bean = new LocalSessionFactoryBean();
		//bean.setAnnotatedClasses(ProductHLO.class);
		bean.setPackagesToScan("com.wu.dao","com.wu.entity","com.wu.models");
		bean.setDataSource(createHikariDataSource());
		
		props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.formate_sql", "true");
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		bean.setHibernateProperties(props);
		
		return bean;
		
	}
	
	@Bean("sesFact")
	@Primary
	public SessionFactory createSessionFactory() {
		
		return createLocalSessionFactoryBean().getObject();
		
	}
	
	@Bean("ht")
	public HibernateTemplate createHibernateTemplete() {
		
		return new HibernateTemplate(createSessionFactory());
	
	}
	
	@Bean("hibernateTransactionManager")
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(createLocalSessionFactoryBean().getObject());
		return transactionManager;
	}
	
}
