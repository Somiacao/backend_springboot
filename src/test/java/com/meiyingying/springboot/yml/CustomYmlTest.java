package com.meiyingying.springboot.yml;

import com.meiyingying.springboot.model.yml.Family;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomYmlTest {
    @Autowired
    Family family;

    @Test
    public void hello(){
        System.out.println(family.toString());
    }
}
