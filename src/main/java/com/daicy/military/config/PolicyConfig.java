package com.daicy.military.config;


import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
public class PolicyConfig {
    @Bean
    public static YamlMapFactoryBean properties() {
        YamlMapFactoryBean yaml = new YamlMapFactoryBean();
        yaml.setResources(new ClassPathResource("policy.yml"));
        yaml.getObject();
        return yaml;
    }

}
