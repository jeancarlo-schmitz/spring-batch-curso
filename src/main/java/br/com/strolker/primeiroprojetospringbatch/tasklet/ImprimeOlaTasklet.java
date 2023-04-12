package br.com.strolker.primeiroprojetospringbatch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ImprimeOlaTasklet{
	
	@Bean
	@StepScope
	public Tasklet imprimeOleTasklet(@Value("#{jobParameters['name']}") String nome) {
		return (StepContribution contribution, ChunkContext chunkContext) -> {
			System.out.println(String.format("Olá mundo %s!", nome));
			return RepeatStatus.FINISHED;
		};
	}

}
