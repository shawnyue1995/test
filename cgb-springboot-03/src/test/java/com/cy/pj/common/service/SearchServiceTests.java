package com.cy.pj.common.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchServiceTests {
    @Autowired
    private SearchService searchService;

    @Test
    void SearchService() {
        System.out.println("searchS ervice");
    }
}
