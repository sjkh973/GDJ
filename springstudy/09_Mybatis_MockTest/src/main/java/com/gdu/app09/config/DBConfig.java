package com.gdu.app09.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


/*
	@PropertySource
	안녕. 난 프로퍼티 파일을 참조할 수 있는 애너테이션이야.
	github에 올리기 싫은 내용은 프로퍼티 파일에 작성하고 gitignore 처리하면 되
*/
@PropertySource(value = {"classpath:mybatis/config/mybatis.properties"})  // xml과 같은 resource는 src/main/resources에 작성해 둔다.


@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
public class DBConfig {

	
	// db.properties 파일을 읽어서 변수에 저장하기
	// ${프로퍼티명}
	@Value(value = "${hikari.driver}")
	private String driver;
	
	@Value(value="${hikari.url}")
	private String url;
	
	@Value(value="${hikari.username}")
	private String username;
	
	@Value(value="${hikari.password}")
	private String password;
	
	@Value(value="${mapper.locations}")
	private String mapperLocations;
	
	@Value(value="${config.location}")
	private String configLocation;
	
	
	// HikariConfig
	@Bean
	public HikariConfig config() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		return config;
	}
	
	
	// HikariDataSource
	@Bean(destroyMethod="close")
	public HikariDataSource dataSource() {
		return new HikariDataSource(config());
	}
	
	
	// SqlSessionFactory
	@Bean
	public SqlSessionFactory factory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
		bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLocation));
		return bean.getObject();
	}
	
	
	// SqlSessionTemplate
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(factory());
	}
	
	
	// TransactionManager
	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
	
}
