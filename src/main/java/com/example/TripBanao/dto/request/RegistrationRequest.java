package com.example.TripBanao.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationRequest {
    private String email;
    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String address;
    private String emergencyContact;
}
