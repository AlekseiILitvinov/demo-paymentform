package com.alitvinov.simple_payment.service;

import com.alitvinov.simple_payment.model.Customer;
import org.springframework.stereotype.Service;

// mock service retrieving the customer details
@Service
public class CustomerService {

    public Customer getCustomerReferenceId(String userId) {
        // get customer from api, or repository
        //mocked for now
        Customer customer = new Customer();
        customer.setReferenceId("customer-" + userId);
        return customer;
    }

}
