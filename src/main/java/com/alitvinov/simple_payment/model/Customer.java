package com.alitvinov.simple_payment.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String referenceId;
}
