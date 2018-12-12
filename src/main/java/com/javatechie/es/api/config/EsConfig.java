package com.javatechie.es.api.config;

import java.io.IOException;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.javatechie.es.api.repository")
public class EsConfig {

	@Bean
	public NodeBuilder builder() {
		return new NodeBuilder();
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws IOException {
		return new ElasticsearchTemplate(builder().local(true).node().client());
	}
}
