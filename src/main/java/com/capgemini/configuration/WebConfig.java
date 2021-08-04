package com.capgemini.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.capgemini","com.capgemini.persistence"})
@EnableTransactionManagement
@EnableJpaRepositories("com.capgemini.persistence")
public class WebConfig {

	   @Bean
	   public ViewResolver getInternalResourceViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	   }
	   
	   @Bean
	    public DataSource dataSource() {
	        return new EmbeddedDatabaseBuilder()
	                .setType(EmbeddedDatabaseType.HSQL)
	                .addScript("classpath:schemaGDT.sql")
	                .generateUniqueName(true)
	                .build();
	    }

	   @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean factoryBean
	                = new LocalContainerEntityManagerFactoryBean();
	        factoryBean.setDataSource(dataSource());
	        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
	        factoryBean.setPackagesToScan("com.capgemini.model");
	        factoryBean.setPersistenceUnitName("spring-data-pun");
	        
	        Map<String, String> props = new HashMap<>();
	        props.put("hibernate.format_sql", "true");
	        
	        factoryBean.setJpaPropertyMap(props);
	        
	        return factoryBean;
	    }

	   @Bean
	    public JpaVendorAdapter jpaVendorAdapter() {
	        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	        jpaVendorAdapter.setGenerateDdl(false);
	        jpaVendorAdapter.setDatabase(Database.HSQL);
	        jpaVendorAdapter.setShowSql(true);
	        return jpaVendorAdapter;
	    }

	   @Bean
	    public PlatformTransactionManager transactionManager() {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	        return transactionManager;
	    }

}
