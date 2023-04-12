package br.com.strolker.jdbcCursorReaderJob.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.strolker.jdbcCursorReaderJob.dominio.Cliente;

@Configuration
public class JdbcCursorReader {

	@Bean
	public JdbcCursorItemReader<Cliente> jdbcCursorReader2( @Qualifier("appDataSource") DataSource dataSource){
		return new JdbcCursorItemReaderBuilder<Cliente>()
				.name("jdbcCursorReader2")
				.dataSource(dataSource)
				.sql("select * from cliente")
				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
				.build();
	}
	
}
