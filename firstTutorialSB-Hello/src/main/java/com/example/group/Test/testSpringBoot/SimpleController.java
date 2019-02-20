package com.example.group.Test.testSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class SimpleController {
    @Autowired
    private TestService ts;
    @RequestMapping("/test")
    public String TestController()
    {
        return "<h2>hello mello</h2>";
    }


}
@Component
class TestService{

    @Bean
    public String Testmessage()
    {
        return "<h1>bu bir servisten gelme</h1>";
    }
}