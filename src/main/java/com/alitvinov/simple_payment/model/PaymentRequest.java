package com.alitvinov.simple_payment.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public final class PaymentRequest {
    @Positive
    private final double amount;
    @NotBlank
    private final String currency;
}
