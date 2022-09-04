package com.newboot.shop.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class KafkaConfig {
    @Value("${shop.kafka.topic.test-name}")
    String testName;
    @Value("${shop.kafka.topic.test-partitions}")
    int testPartitions;
    @Value("${shop.kafka.topic.test-factor}")
    short testFactor;
    @Value("${shop.kafka.topic.email-code-name}")
    String emailCodeName;
    @Value("${shop.kafka.topic.email-code-partitions}")
    int emailCodePartitions;
    @Value("${shop.kafka.topic.email-code-factor}")
    short emailCodeFactor;

    @Bean
    public NewTopic initTestTopic(){
        log.info("kafka init topic {}, {}, {}", testName, testPartitions, testFactor);
        return new NewTopic(testName, testPartitions, testFactor);
    }
    @Bean
    public NewTopic initEmailCodeTopic(){
        log.info("kafka init topic {}, {}, {}", emailCodeName, emailCodePartitions, emailCodeFactor);
        return new NewTopic(emailCodeName, emailCodePartitions, emailCodeFactor);
    }

}
