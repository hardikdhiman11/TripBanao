package com.example.TripBanao.resource;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class Resources {
    public String generateRandomOtp(){
        StringBuilder sb = new StringBuilder(16);
        SecureRandom random = new SecureRandom();
        for (int i=0;i<sb.length();i++){
            sb.append(random.nextInt());
        }
        return sb.toString();
    }
}
