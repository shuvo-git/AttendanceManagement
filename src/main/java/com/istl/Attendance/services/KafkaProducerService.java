package com.istl.Attendance.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;

@Service
@Slf4j
public class KafkaProducerService
{
    @Autowired
    KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendToKafka(String topic, String key, Object data){
        log.info("===Sending to Kafka Topic {} with key {}...",topic,key);

        try {
            ListenableFuture<SendResult<Object,Object>> future = kafkaTemplate.send(topic,key,data);
            SuccessCallback<SendResult<Object,Object>> successCallback = result -> {
                log.info("Added data "+data+" to topic-partition@offset="+result.getRecordMetadata().toString()+" with the key "+key);
            };
            FailureCallback failureCallback = throwable->{
                log.error("Sending payload='" + data + "' to topic='" + topic + "' with key='" + key + "' failed!!!");
            };
            future.addCallback(successCallback,failureCallback);
        }
        catch (Throwable t){
            log.error("===Error Sending to kafka: ",t);
        }
    }
}
