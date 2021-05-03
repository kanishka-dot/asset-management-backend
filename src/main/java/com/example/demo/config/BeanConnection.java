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
        dataSourceBuilder.url("jdbc:mysql://149.56.134.121:3306/MyDB");
	    dataSourceBuilder.username("kanishka"); 
	    dataSourceBuilder.password("123456"); 
	    return  dataSourceBuilder.build().getConnection(); 
	}
}
