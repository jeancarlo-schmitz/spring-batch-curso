package br.com.strolker.jdbcCursorReaderJob.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.strolker.jdbcCursorReaderJob.dominio.Cliente;

@Configuration
public class JdbcPagingItemReader {

	@Bean
	public org.springframework.batch.item.database.JdbcPagingItemReader<Cliente> jdbcPagingItemReader2(@Qualifier("appDataSource") DataSource dataSource, PagingQueryProvider queryProvider) {
		return new JdbcPagingItemReaderBuilder<Cliente>()
				.name("jdbcPagingItemReader2")
				.dataSource(dataSource)
				.queryProvider(queryProvider)
				.pageSize(2)
				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
				.build();
	}
	
	@Bean
	public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource dataSource) {
		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
		queryProvider.setDataSource(dataSource);
		queryProvider.setSelectClause("SELECT *");
		queryProvider.setFromClause("FROM cliente");
		queryProvider.setSortKey("email");
		
		return queryProvider;
	}
	
}
