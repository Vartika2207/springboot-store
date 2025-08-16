package com.codebyvartika.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("stripe")
//@Primary
public class StripePaymentService implements PaymentService {
    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.timeout:1000}")
    private int timeout;

    @Override
    public void processPayment(double amount) {
        System.out.println("STRIPE PAYMENT");
        System.out.println("Processing payment " + " amount " + amount + " paid. " );
        System.out.println("The api url for stripe is: " + apiUrl);
        System.out.println("The timeout is: " + timeout);
    }
}
