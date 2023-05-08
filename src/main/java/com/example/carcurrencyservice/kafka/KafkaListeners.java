package com.example.carcurrencyservice.kafka;

import com.example.carcurrencyservice.grpc.CurrencyConverterClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.SimpleKafkaHeaderMapper;
import org.springframework.kafka.support.converter.MessagingMessageConverter;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaListeners {

    @Autowired
    private CurrencyConverterClient currencyConverterClient;

    @KafkaListener(id="server", topics = "bookingCurrencyRequests")
    @SendTo // use default replyTo expression
    public String listen(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> currencyResponseDataJson;
        try {
            currencyResponseDataJson = objectMapper.readValue(data, new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Fehler beim Konvertieren des JSON-Strings in eine Map<String, Object>.");
        }
        System.out.println("Server received: " + data);
        double convertedAmount = currencyConverterClient.currencyConverter(currencyResponseDataJson.get("baseCurrency").toString(), currencyResponseDataJson.get("targetCurrency").toString(), (double) currencyResponseDataJson.get("amount"));

        return String.valueOf(convertedAmount);
    }

    @Bean // not required if Jackson is on the classpath
    public MessagingMessageConverter simpleMapperConverter() {
        MessagingMessageConverter messagingMessageConverter = new MessagingMessageConverter();
        messagingMessageConverter.setHeaderMapper(new SimpleKafkaHeaderMapper());
        return messagingMessageConverter;
    }
}
