package com.uclibm.ixn.controller;

import com.uclibm.ixn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchAnalysisService searchAnalysisService;
    private UserInputService userInputService;

    @GetMapping
    public ModelAndView search(String content){
        ModelAndView modelAndView = new ModelAndView("searchResult");
        modelAndView.addObject("content", content);
        userInputService.addUserInput(content);
        return modelAndView;
    }

    @PostMapping
    public Map<String, String> getSearchResults(String content) {
        Set<String> words = searchAnalysisService.getWords(content);
        return searchAnalysisService.getResults(words);
    }

    @Autowired
    public void setSearchAnalysisService(SearchAnalysisService searchAnalysisService) {
        this.searchAnalysisService = searchAnalysisService;
    }

    @Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

}
