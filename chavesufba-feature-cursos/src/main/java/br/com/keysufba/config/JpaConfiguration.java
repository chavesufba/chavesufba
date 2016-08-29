package br.com.keysufba.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"br.com.keysufba.repository"})
public class JpaConfiguration {

}
