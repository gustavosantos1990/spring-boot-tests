package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class FinancialDatabaseConfig {

	@Bean(name = "financialDS")
	@ConfigurationProperties(prefix = "financial.db")
	public DataSource mysqlDrupalDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "financialJT")
	public JdbcTemplate drupalJdbcTemplate(@Qualifier("financialDS") DataSource financialDS) {
		return new JdbcTemplate(financialDS);
	}
}