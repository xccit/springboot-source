package io.xccit;

import io.xccit.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    private User user;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void testIoc(){
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);
    }

    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
