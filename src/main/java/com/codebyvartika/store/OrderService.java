package com.codebyvartika.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("----Order service created----");
    }

    @PostConstruct
    public void init() {
        System.out.println("----Order service postConstruct----");
    }
    @PreDestroy
    public void cleanup() {
        System.out.println("----Order service preDestroy----");
    }

    public void placeOrder() {
        double amount = 10;
        paymentService.processPayment(amount);
    }

//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
}
