package br.com.strolker.processadorValidacaoJob.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.strolker.processadorValidacaoJob.dominio.Cliente;

@Configuration
public class ProcessadorValidacaoWriterConfig {
	@Bean
	public ItemWriter<Cliente> processadorValidacaoWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}
