package com.example.sp07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@SpringBootApplication
@SpringCloudApplication
public class Sp07HystrixApplication {

    //新建RestTemplate实例，放入spring容器
    //注册负载均衡
    @LoadBalanced   //生成一个动态代理对象，切入负载均衡代码
    @Bean
    public RestTemplate getRestTemplate(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(1000);
        factory.setReadTimeout(1000);
        return new RestTemplate(factory);
    }

    public static void main(String[] args) {
        SpringApplication.run(Sp07HystrixApplication.class, args);
    }

}
