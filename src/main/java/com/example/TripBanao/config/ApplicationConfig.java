package com.example.TripBanao.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableCaching
public class ApplicationConfig {
    @Bean
    public CacheManager cacheManager(){
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(List.of(new ConcurrentMapCache("OtpCache")));
        return simpleCacheManager;
    }

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSender javaMailSender = new JavaMailSenderImpl();
        return javaMailSender;
    }
}
