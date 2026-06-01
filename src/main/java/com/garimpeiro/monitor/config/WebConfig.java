package com.garimpeiro.monitor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") // Libera todas as rotas da nossa API (itens, categorias, etc)
                .allowedOrigins("*") // Libera o acesso de QUALQUER site ou porta (ideal para desenvolvimento)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*"); // Libera todos os tipos de cabeçalhos
    }
}