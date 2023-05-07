package com.example.carcurrencyservice;

import com.example.carcurrencyservice.grpc.CurrencyConverterClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarCurrencyServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CurrencyConverterClient currencyConverterClient;

    @Test
    public void testCurrencyConverterClient() {
        assertThat(currencyConverterClient.currencyConverter("USD", "EUR", 150))
                .isEqualTo(136.1903032504086);
    }

}
