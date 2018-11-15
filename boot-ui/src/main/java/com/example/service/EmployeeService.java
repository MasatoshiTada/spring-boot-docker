package com.example.service;

import com.example.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final RestTemplate restTemplate;
    private final URI apiServiceUri;

    public EmployeeService(RestTemplate restTemplate,
                           @Value("${API_SERVICE_URI}") URI apiServiceUri) {
        this.restTemplate = restTemplate;
        this.apiServiceUri = apiServiceUri;
        logger.info("API_SERVICE_URI = " + apiServiceUri);
    }

    public List<Employee> findAll() {
        RequestEntity<Resources<Resource<Employee>>> requestEntity =
                new RequestEntity<>(HttpMethod.GET, apiServiceUri);
        ResponseEntity<Resources<Resource<Employee>>> responseEntity =
                restTemplate.exchange(requestEntity,
                        new ParameterizedTypeReference<Resources<Resource<Employee>>>() {});
        Resources<Resource<Employee>> resources = responseEntity.getBody();
        Collection<Resource<Employee>> resourceCollection = resources.getContent();
        List<Employee> employeeList = resourceCollection.stream()
                .map(resource -> resource.getContent())
                .peek(employee -> logger.info("id = " + employee.getId()))
                .collect(Collectors.toList());
        return employeeList;
    }
}
