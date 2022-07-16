package cn.itcast.order;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication

public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
    @Bean
    @LoadBalanced// 表示通过该模板发起的请求将被ribbon拦截
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    更改负载均衡规则
//    @Bean  //全局配置，对于所有的微服务都采用相同的规则
//    public IRule iRule(){
//        return new RandomRule();
//    }
}