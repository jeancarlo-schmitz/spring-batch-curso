package br.com.strolker.jdbcCursorReaderJob.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JdbcCursorJob {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job jdbcCursorReaderJob2(Step jdbcCursorStep) {
		return jobBuilderFactory
				.get("jdbcCursorReaderJob2")
				.start(jdbcCursorStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
}
