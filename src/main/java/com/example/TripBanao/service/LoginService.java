package com.example.TripBanao.service;

import com.example.TripBanao.dto.request.VerifyOtpRequest;
import com.example.TripBanao.resource.Resources;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    @Autowired
    private final CacheManager cacheManager;
    @Autowired
    private final JavaMailSender javaMailSender;
    @Autowired
    private final Resources resources;

    //Send otp to email
    public boolean sendOtp(String email){
        String randomOtp = resources.generateRandomOtp();
        Cache cache = cacheManager.getCache("OtpCache");
        cache.put(email,randomOtp);
        log.info("Email is {} and otp is {}",email,randomOtp);

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("TripBanao Login Otp");
            simpleMailMessage.setText("Otp for you ECommerce is " + randomOtp);
            javaMailSender.send(new SimpleMailMessage(simpleMailMessage));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //Verify otp with email
    public boolean verifyOtp(VerifyOtpRequest request){
        String email = request.getEmail();
        String otp = cacheManager.getCache("OtpCache").get(email,String.class);
        if (request.getOtp()==otp){
            return true;
        }
        return false;
    }
}
