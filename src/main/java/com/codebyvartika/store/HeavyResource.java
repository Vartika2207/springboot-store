package com.codebyvartika.store;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class HeavyResource {
    public HeavyResource() {
        System.out.println("----Heavy Resource created-----");
    }
}
