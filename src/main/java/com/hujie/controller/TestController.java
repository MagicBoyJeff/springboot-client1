package com.hujie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("test")
    public String test(String name){

        String forObject = restTemplate.getForObject( "http://EUREKA-CLIENT2/product/product?name=" + name, String.class );

        return forObject;
    }


    //验证负载均衡
    @RequestMapping("test1")
    public Integer test1(){
        ServiceInstance serviceInstance = loadBalancerClient.choose( "EUREKA-CLIENT2" );

        int port = serviceInstance.getPort();
        String host = serviceInstance.getHost();
        System.out.println(host);
        String serviceId = serviceInstance.getServiceId();
        System.out.println(serviceId);

        return port;


    }


}
