package com.example.carcurrencyservice.api;

import com.example.carcurrencyservice.grpc.CurrencyConverterClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URI;

@RestController
@RequestMapping("car-rental/api/v1")
public class CurrencyServiceController {

    @Autowired
    private CurrencyConverterClient currencyConverterClient;


    @PostMapping("/currencies")
    public ResponseEntity<Map<String, Object>> currencyConverter(@RequestBody CurrencyRequest currencyRequest) {

        if (currencyRequest.getTargetCurrency() != null && !currencyRequest.getTargetCurrency().isEmpty()) {
            double convertedAmount = currencyConverterClient.currencyConverter(
                    "USD",
                    currencyRequest.getTargetCurrency(),
                    currencyRequest.getAmount());

            // Return response if everything is successful
            Map<String, Object> response = new HashMap<>();
            response.put("baseCurrency", "USD");
            response.put("baseAmount", currencyRequest.getAmount());
            response.put("targetCurrency", currencyRequest.getTargetCurrency());
            response.put("targetAmount", convertedAmount);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/currencies")
    public ResponseEntity<Map<String, Object>> getCurrencyList() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://3.72.41.7:8080/?wsdl"))
                .header("Content-Type", "text/xml; charset=utf-8")
                .header("SOAPAction", "CurrencyConverter/available_currencies")
                .POST(HttpRequest.BodyPublishers.ofString("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:your=\"CurrencyConverter\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <your:available_currencies>\n" +
                        "         <your:api_key>apikey1</your:api_key>\n" +
                        "      </your:available_currencies>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>"))
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<String> currencyList = objectMapper.readValue(response.body(), new TypeReference<ArrayList<String>>() {});
        // Return response if everything is successful
        return new ResponseEntity<>(Map.of("currency_list", currencyList), HttpStatus.CREATED);
    }
}
