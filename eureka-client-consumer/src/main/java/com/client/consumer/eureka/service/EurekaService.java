package com.client.consumer.eureka.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class EurekaService {

	private final DiscoveryClient discoveryClient;

    @Autowired
    public EurekaService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public URI getInstance(String serviceId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if(instances != null && instances.size() > 0) {
            return instances.get(0).getUri();
        }
        return null;
    }
}
