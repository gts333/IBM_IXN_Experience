package com.uclibm.ixn.service.impl;

import com.uclibm.ixn.service.SearchAnalysisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SearchAnalysisServiceImplTest {
    @Autowired
    SearchAnalysisService searchAnalysisService;

    @Test
    void getWords() {
        System.out.println(searchAnalysisService.getWords("I had a bad day"));
    }

    @Test
    void getResults() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("bad day");
        System.out.println(searchAnalysisService.getResults(hashSet));
    }
}