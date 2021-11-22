package br.com.devpradev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.devpradev.utils.Endpoints;

@Configuration
public class CorsConfigurations implements WebMvcConfigurer {

    
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        
        // Front-End
        corsRegistry.addMapping("/**").allowedOrigins(Endpoints.CROSS_ORIGINS_FRONT).allowedMethods("GET", "POST",
                "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }

}
