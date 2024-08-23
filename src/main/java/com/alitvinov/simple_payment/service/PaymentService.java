package com.alitvinov.simple_payment.service;

import com.alitvinov.simple_payment.model.Customer;
import com.alitvinov.simple_payment.model.PaymentApiRequest;
import com.alitvinov.simple_payment.model.PaymentRequest;
import com.alitvinov.simple_payment.model.PaymentApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${payment.api.url}")
    private String paymentApiUrl;

    @Value("cAmmvalAikARkB81fgxgMtnMbEdNbuWa")
    private String bearerToken;

    private final CustomerService customerService;

    public PaymentApiResponse processPayment(PaymentRequest paymentRequest) {
        RestClient restClient = RestClient.create(paymentApiUrl);
        //mock customer for demo
        Customer customer = customerService.getCustomerReferenceId("test1");
        PaymentApiRequest paymentApiRequest = new PaymentApiRequest(paymentRequest.getAmount(), paymentRequest.getCurrency(), customer);
        ResponseEntity<PaymentApiResponse> entity = restClient.post().header("Authorization", "Bearer " + bearerToken)
                .contentType(MediaType.APPLICATION_JSON).body(paymentApiRequest).retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RestClientException("Sorry to say, but I'm unable to process the request. \n" +
                            "Please try again. If the problem persists please contact the support.");
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new RestClientException("Oops, something went wrong. \n" +
                            "Please don't worry, the developer will be punished.");
                })
                .toEntity(PaymentApiResponse.class);
        return entity.getBody();
    }

}
