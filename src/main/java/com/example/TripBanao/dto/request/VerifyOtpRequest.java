package com.example.TripBanao.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class VerifyOtpRequest {
    private String email;
    private String otp;
}
