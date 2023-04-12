package br.com.strolker.processadorValidacaoJob.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.strolker.processadorValidacaoJob.dominio.Cliente;

@Configuration
public class ProcessadorValidacaoProcessorConfig {
	
	@Bean
	public ItemProcessor<Cliente, Cliente> procesadorValidacaoProcessor() {
		BeanValidatingItemProcessor<Cliente> validation = new BeanValidatingItemProcessor<>();
		
		validation.setFilter(true);
		return validation;
	}
}
