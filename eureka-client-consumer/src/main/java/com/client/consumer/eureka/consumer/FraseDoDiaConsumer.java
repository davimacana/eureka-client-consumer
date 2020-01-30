package com.client.consumer.eureka.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.client.consumer.eureka.service.EurekaService;

@Component
public class FraseDoDiaConsumer {

    private final RestTemplate restTemplate;

    private final EurekaService eurekaService;

    @Value("${app.fraseDoDiaService.serviceId}")
    private String fraseDoDiaServiceId;
    
    @Value("${app.fraseDoDiaService.endpoint.fraseDoDia}")
    private String fraseDoDiaEndpointUri;

    @Autowired
    public FraseDoDiaConsumer(RestTemplate restTemplate, EurekaService eurekaService) {
        this.restTemplate = restTemplate;
        this.eurekaService = eurekaService;
    }

    public String getRandomFraseDoDia() {
        URI uri = eurekaService.getInstance(fraseDoDiaServiceId);
        String fraseDoDia = restTemplate.getForObject(uri.toString() + fraseDoDiaEndpointUri, String.class);
        return fraseDoDia;
    }
}
