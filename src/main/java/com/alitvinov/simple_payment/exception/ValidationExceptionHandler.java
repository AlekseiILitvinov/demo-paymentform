package com.alitvinov.simple_payment.exception;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(BindException.class)
    public String handleValidationException(BindException e, Model model) {
        model.addAttribute("error", "Invalid value in field: " +
                Optional.ofNullable(e.getFieldError()).map(FieldError::getField).orElse("unknown"));
        return "error-page";
    }

}
