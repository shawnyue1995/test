package com.cy.pj.common.cache;

import org.springframework.stereotype.Component;

@Component//@Component("cache")假如没有起名,默认为类名,然后首字母小写,例如softCache
public class SoftCache implements Cache {
    public SoftCache() {
        System.out.println("SoftCache");
    }
}
