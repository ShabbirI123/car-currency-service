package com.example.carcurrencyservice.grpc;

import currencyconverter.CurrencyConverterGrpc;
import currencyconverter.CurrencyConverterOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CurrencyConverterClient {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CurrencyConverterClient.class);

    private CurrencyConverterGrpc.CurrencyConverterBlockingStub currencyConverterBlockingStub;

    public double currencyConverter(String baseCurrency, String targetCurrency, double amount) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("3.66.170.209", 8080)
                .usePlaintext()
                .build();

        currencyConverterBlockingStub = CurrencyConverterGrpc.newBlockingStub(channel);

        String apiKey = "apikey1";

        CurrencyConverterOuterClass.ConversionRequest request = CurrencyConverterOuterClass.ConversionRequest.newBuilder()
                .setApiKey(apiKey)
                .setBaseCurrency(baseCurrency)
                .setTargetCurrency(targetCurrency)
                .setAmount(amount)
                .build();

        System.out.println(request);
        CurrencyConverterOuterClass.ConversionResult result =   currencyConverterBlockingStub.convert(request);

        return result.getValue();
    }
}