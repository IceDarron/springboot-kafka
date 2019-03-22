package com.icedarron.kafka;

import com.icedarron.kafka.producer.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@Component
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootKafkaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestKafka {
    @Autowired
    private Producer sender;

    @Test
    public void aaa() {
        for (int i = 0; i < 3; i++) {
            //调用消息发送类中的消息发送方法
            sender.send();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}