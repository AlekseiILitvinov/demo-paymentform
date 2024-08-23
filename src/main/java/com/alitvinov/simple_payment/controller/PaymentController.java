package com.alitvinov.simple_payment.controller;

import com.alitvinov.simple_payment.model.PaymentRequest;
import com.alitvinov.simple_payment.model.PaymentApiResponse;
import com.alitvinov.simple_payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/")
    public String showPaymentForm(Model model) {
        return "payment-form";
    }

    @PostMapping("/process-payment")
    public String processPayment(@ModelAttribute @Valid PaymentRequest paymentRequest, Model model) {
        try {
            PaymentApiResponse response = paymentService.processPayment(paymentRequest);
            return "redirect:" + response.getResult().getRedirectUrl();
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error-page";
        }
    }
}
