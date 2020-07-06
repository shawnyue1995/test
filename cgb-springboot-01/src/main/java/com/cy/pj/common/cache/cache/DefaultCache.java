package com.cy.pj.common.cache.cache;

import org.springframework.stereotype.Component;

@Component
public class DefaultCache {
    public DefaultCache(Object defaultCache) {
        System.out.println("DeafultCache()");
    }
}

