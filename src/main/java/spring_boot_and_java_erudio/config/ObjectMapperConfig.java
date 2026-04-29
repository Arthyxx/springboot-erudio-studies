package spring_boot_and_java_erudio.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Configura filtros de serialização JSON para ocultar campos sensíveis
 * nas respostas da API, como CPF, senha, RG ou dados de cartão de crédito.
 * Usa-se no DTO (Respostas API).
 *
 */

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();

        SimpleFilterProvider filters = new SimpleFilterProvider()
                .addFilter("PersonFilter",
                        SimpleBeanPropertyFilter.serializeAllExcept("sensitiveData"));

        mapper.setFilterProvider(filters);

        return mapper;
    }
}
