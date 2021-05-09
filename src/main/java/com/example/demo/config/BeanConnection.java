package com.example.demo.config;


import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConnection {

	
@Bean
	public Connection getDataSource() throws SQLException{ 
	    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
	    dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost/mydb");
	    dataSourceBuilder.username("root"); 
	    dataSourceBuilder.password("123456789"); 
	    return  dataSourceBuilder.build().getConnection(); 
	}
}
