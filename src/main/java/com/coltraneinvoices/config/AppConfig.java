package com.coltraneinvoices.config;

import java.time.Clock;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
    @Bean
    public Clock clock(){
        return Clock.systemUTC();
    }
    
    @Configuration
    public class OpenAPIConfig {
        
        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                .info(new Info()
                    .title("API REST Full / Java / Coderhouse")
                    .version("3.0.0")
                    .description("La API REST proporciona endpoints para procesar ventas del E-Commerce \"El Rincón de Coltrane\". " +
                                "Maneja comandos CRUD fundamentales. Los endpoints permiten crear y consultar clientes, " +
                                "crear y consultar facturas de ventas, y procesar las ventas en sí.")
                    .contact(new Contact()
                        .name("Tomás Pérez Mera")
                        .email("tperezmera@gmail.com")
                        .url("https://github.com/TomasPerezMera/Coltrane-Invoices/"))
                )
    			.servers(List.of(new Server()
            		.url("http://localhost:8080/")
            		.description("Servidor Local")));
        }
    }
}