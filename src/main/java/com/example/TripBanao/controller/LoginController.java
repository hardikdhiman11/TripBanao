package com.example.TripBanao.controller;

import com.example.TripBanao.dto.request.VerifyOtpRequest;
import com.example.TripBanao.resource.ResourceUtils;
import com.example.TripBanao.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private final LoginService loginService;

    @PostMapping("/sendOtp")
    public ResponseEntity<Object> sendOtp(@RequestHeader String email){
        boolean isSent = loginService.sendOtp(email);
        if (isSent){
            return new ResponseEntity<>(ResourceUtils.SEND_OTP,HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(ResourceUtils.OTP_NOT_SENT,HttpStatusCode.valueOf(400));
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<Object> verifyOtp(@RequestHeader VerifyOtpRequest request){
        boolean isSent = loginService.verifyOtp(request);
        if (isSent){
            return new ResponseEntity<>(ResourceUtils.VERIFY_OTP,HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(ResourceUtils.OTP_NOT_VERIFIED,HttpStatusCode.valueOf(400));
    }
}
