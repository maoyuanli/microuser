package com.maotion.microuser.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserAccountControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;

    private final String SETUSER_URI = "/user";

    private final String SET_USER_JSON = "{" +
            "\"user\":" +
            "{" +
            "\"user_name\": \"admin1\"," +
            "\"password\":\"pass1\"," +
            "\"email\":\"admin1@spring.com\"," +
            "\"role\":\"ADMIN\"" +
            "}" +
            "}";

    private final List<String> EXPECTED_RESPONSE_KEYWORDS = Arrays.asList("id", "userName", "email", "role", "password");

    @Test
    public void testSetUserAccount() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext, SETUSER_URI, SET_USER_JSON, 200, EXPECTED_RESPONSE_KEYWORDS);
    }
}