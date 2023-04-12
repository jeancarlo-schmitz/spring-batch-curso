package br.com.strolker.jdbcCursorReaderJob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.strolker.jdbcCursorReaderJob.dominio.Cliente;

@Configuration
public class JdbcCursorStep {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public Step jdbcCursorStep2(ItemReader<Cliente> itemReader, ItemWriter<Cliente> itemWrite) {
		return stepBuilderFactory
				.get("jdbcCursorStep2")
				.<Cliente, Cliente>chunk(1)
				.reader(itemReader)
				.writer(itemWrite)
				.build();
	}
}
