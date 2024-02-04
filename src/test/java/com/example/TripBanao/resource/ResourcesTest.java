package com.example.TripBanao.resource;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ResourcesTest {

    public String generateRandomOtp(){
        SecureRandom random = new SecureRandom();
        System.out.println(random);
        return random.toString();
    }
}