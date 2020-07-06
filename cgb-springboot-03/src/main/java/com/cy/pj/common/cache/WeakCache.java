package com.cy.pj.common.cache;

import org.springframework.stereotype.Component;

@Component
public class WeakCache implements Cache {
    public WeakCache() {
        System.out.println("WeakCache");
    }
}
