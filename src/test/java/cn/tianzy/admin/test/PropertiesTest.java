package cn.tianzy.admin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Value("${test.value}")
    String testValue;
    @Value("${test.value2}")
    String testValue2;

    @Test
    public void test(){
        System.out.println(testValue);
        System.out.println(testValue2);
    }
}
