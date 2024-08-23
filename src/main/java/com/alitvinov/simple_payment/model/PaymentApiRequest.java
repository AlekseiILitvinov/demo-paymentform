package com.alitvinov.simple_payment.model;

import lombok.Data;

@Data
public class PaymentApiRequest {
    private String paymentType = PaymentType.DEPOSIT.toString();
    private double amount;
    private String currency;
    private String paymentMethod = PaymentMethod.BASIC_CARD.toString();
    private Customer customer;

    public PaymentApiRequest(double amount, String currency, Customer customer) {
        this.amount = amount;
        this.currency = currency;
        this.customer = customer;
    }
}
