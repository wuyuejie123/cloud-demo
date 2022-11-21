package cn.itcast.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
}
