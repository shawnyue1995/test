package com.cy.pj.common.service;

import com.cy.pj.common.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SearchService {
    private Cache cache;

    /**
     * 构造方法注入
     */
    @Autowired
    public SearchService(@Qualifier("softcache") Cache cache) {
        this.cache = cache;
        System.out.println("this.cache=" + cache);
    }
}

