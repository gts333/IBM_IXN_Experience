package com.uclibm.ixn.service;

import java.util.Map;
import java.util.Set;

public interface SearchAnalysisService {

    /**
     * Get the keywords
     * @param content the input from the users
     * @return a list of important words
     */
    Set<String> getWords(String content);

    /**
     * Get the results to be returned to front end
     * @param words a list of words
     * @return the result map, key being the description, value being the link
     */
    Map<String, String> getResults(Set<String> words);

}
