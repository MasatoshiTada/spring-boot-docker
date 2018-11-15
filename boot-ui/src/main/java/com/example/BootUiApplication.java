package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
public class BootUiApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(BootUiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(3000)
                .setReadTimeout(3000)
                .additionalInterceptors(new ClientHttpRequestInterceptor() {
                    @Override
                    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
                                                        ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
                        String methodValue = httpRequest.getMethodValue();
                        String uri = httpRequest.getURI().toString();
                        logger.info("ACCESSING : " + methodValue + " " + uri);
                        return clientHttpRequestExecution.execute(httpRequest, bytes);
                    }
                })
                .build();
    }
}
