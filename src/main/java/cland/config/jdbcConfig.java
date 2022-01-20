package cland.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import cland.constant.GlobalConstant;

@Configuration
public class jdbcConfig {
	
	@Bean("dataSource")
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(GlobalConstant.DRIVER_NAME);
		dataSource.setUrl(GlobalConstant.URL);
		dataSource.setUsername(GlobalConstant.USERNAME);
		dataSource.setPassword(GlobalConstant.PASSWORD);
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

}
