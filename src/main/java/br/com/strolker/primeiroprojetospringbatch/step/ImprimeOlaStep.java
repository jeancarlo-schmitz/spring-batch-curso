package br.com.strolker.primeiroprojetospringbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ImprimeOlaStep {

//	@Bean
//	public Step imprimeOlaStep2(JobRepository jobRepository, PlatformTransactionManager transactionManager, Tasklet imprimeOleTasklet) {
//		return new StepBuilder("imprimeOlaStep2", jobRepository)
//				.tasklet(imprimeOleTasklet, transactionManager)
//				.build();
//	}
}
