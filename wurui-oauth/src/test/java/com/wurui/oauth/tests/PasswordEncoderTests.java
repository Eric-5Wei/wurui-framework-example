package com.wurui.oauth.tests;

import com.wurui.oauth.AuthApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class)
public class PasswordEncoderTests {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    public void testPasswordEncoder(){
        System.out.println(passwordEncoder.encode("dashboard"));
        System.out.println(passwordEncoder.encode("portal"));
    }
}
