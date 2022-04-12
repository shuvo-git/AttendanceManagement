package com.istl.Attendance.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfig
{
    @Value("${kafka.partition.count}")
    private int partitionCount;
    @Value("${kafka.replication.factor}")
    private short replicationFactor;

    @Bean
    public SeekToCurrentErrorHandler errorHandler(KafkaTemplate<Object, Object> template) {
        return new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
    }

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }

    @Bean
    public NewTopic topicNewBook(){
        return new NewTopic(KafkaTopics.NEW_BOOK_TOPIC,partitionCount,replicationFactor);
    }

    @Bean
    public NewTopic topicDeleteBook(){
        return new NewTopic(KafkaTopics.DELETE_BOOK_TOPIC,partitionCount,replicationFactor);
    }

}
