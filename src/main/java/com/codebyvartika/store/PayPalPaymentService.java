package com.codebyvartika.store;

import org.springframework.stereotype.Service;

//@Service("paypal")
public class PayPalPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal PAYMENT");
//        System.out.println("Processing payment " + " amount " + amount + " paid. " );
    }
}
