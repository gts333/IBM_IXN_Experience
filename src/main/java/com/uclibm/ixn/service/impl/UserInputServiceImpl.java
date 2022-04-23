package com.uclibm.ixn.service.impl;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.natural_language_understanding.v1.model.*;
import com.uclibm.ixn.config.WatsonConfig;
import com.uclibm.ixn.dao.UserInputDao;
import com.uclibm.ixn.service.UserInputService;
import com.uclibm.ixn.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserInputServiceImpl implements UserInputService {

    private UserInputDao userInputDao;
    private WatsonConfig watsonConfig;

    @Override
    public void addUserInput(String string) {
        userInputDao.addContent(string);
    }

    @Autowired
    public void setWatsonConfig(WatsonConfig watsonConfig) {
        this.watsonConfig = watsonConfig;
    }

    @Override
    public Map<String, Integer> getUserReport() {
        Map<String, Integer> report = new HashMap<>();
        String content = String.join(", ", userInputDao.getAllContents());
        try {
            IamAuthenticator authenticator = new IamAuthenticator.Builder().apikey(watsonConfig.api).build();
            NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2021-08-01", authenticator);
            naturalLanguageUnderstanding.setServiceUrl(watsonConfig.url);
            KeywordsOptions keywordsOptions = new KeywordsOptions.Builder().build();
            Features features = new Features.Builder().keywords(keywordsOptions).build();
            AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(content).features(features).build();
            AnalysisResults response = naturalLanguageUnderstanding.analyze(parameters).execute().getResult();
            List<KeywordsResult> keywords = response.getKeywords();
            for (KeywordsResult result : keywords) {
                String key = result.getText();
                Integer count = Math.toIntExact(result.getCount());
                report.put(key, count);
            }
            //if the IBM Watson considers the user input to be too small, or it fails to work,we ignore the exception
        } catch (Exception ignored) {
        }
        report = MapUtil.sortByValue(report);
        return report;
    }

    @Autowired
    public void setUserInputDao(UserInputDao userInputDao) {
        this.userInputDao = userInputDao;
    }

}
