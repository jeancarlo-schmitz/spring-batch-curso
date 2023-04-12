package br.com.strolker.parimparjob;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ParImparBatchConfig {
//
//	@Bean
//	public Job imprimeParImparJob(JobRepository jobRepository, Step step) {
//		return new JobBuilder("parImparJob", jobRepository)
//				.start(step)
//				.incrementer(new RunIdIncrementer())
//				.build();
//	}
//	
//	@Bean
//	public Step parImparStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//		return new StepBuilder("parImparStep", jobRepository)
//				.<Integer, String>chunk(1, transactionManager)
//				.reader(contaAteDezReader())
//				.processor(parOurImparProcessor())
//				.writer(imprimeWriter())
//				.build();
//	}
	
	private IteratorItemReader<Integer> contaAteDezReader() {
		List<Integer> itensDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		return new IteratorItemReader<>(itensDeUmAteDez.iterator());
	}
	
	private FunctionItemProcessor<Integer, String> parOurImparProcessor(){
		return new FunctionItemProcessor<>
			(item -> item % 2 == 0 ? String.format("O Numero: %s! é par", item) : String.format("O Numero: %s! é impar", item));
	}
	
	private ItemWriter<String> imprimeWriter(){
		return itens -> itens.forEach(System.out::println);
	}
	
}
