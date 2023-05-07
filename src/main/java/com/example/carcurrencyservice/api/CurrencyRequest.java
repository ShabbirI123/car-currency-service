package com.example.carcurrencyservice.api;

public class CurrencyRequest {
    private String targetCurrency;
    private double amount;

    // Getters and setters for all properties
    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
