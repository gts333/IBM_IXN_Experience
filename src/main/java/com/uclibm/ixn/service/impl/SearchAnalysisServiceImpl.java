package com.uclibm.ixn.service.impl;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.natural_language_understanding.v1.model.*;
import com.uclibm.ixn.config.WatsonConfig;
import com.uclibm.ixn.domain.Info;
import com.uclibm.ixn.domain.News;
import com.uclibm.ixn.domain.Post;
import com.uclibm.ixn.domain.Project;
import com.uclibm.ixn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchAnalysisServiceImpl implements SearchAnalysisService {
    private WatsonConfig watsonConfig;
    private ForumService forumService;
    private NewsService newsService;
    private ProjectService projectService;
    private InfoService infoService;

    @Override
    //Use the IBM Watson AI to analyze the contents input by the users, followed by
    public Set<String> getWords(String content) {
        Set<String> words = new HashSet<>();
        try{
            IamAuthenticator authenticator = new IamAuthenticator.Builder().apikey(watsonConfig.api).build();
            NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2021-08-01", authenticator);
            naturalLanguageUnderstanding.setServiceUrl(watsonConfig.url);
            EntitiesOptions entitiesOptions = new EntitiesOptions.Builder().limit(5).build();
            KeywordsOptions keywordsOptions = new KeywordsOptions.Builder().limit(5).build();
            Features features = new Features.Builder().entities(entitiesOptions).keywords(keywordsOptions).build();
            AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(content).features(features).build();
            AnalysisResults response = naturalLanguageUnderstanding.analyze(parameters).execute().getResult();
            List<EntitiesResult> entities = response.getEntities();
            List<KeywordsResult> keywords = response.getKeywords();
            for(EntitiesResult result: entities){
                words.add(result.getText());
            }
            for(KeywordsResult result: keywords){
                words.add(result.getText());
            }
            //if the IBM Watson considers the user input to be too small, or it fails to work,
            //we split the words by ourselves
        }catch (Exception ignored){
            String[] splited = content.split("\\s+");
            words.add(content);
            words.addAll(Arrays.asList(splited));
        }
        return words;
    }

    @Override
    //Obtain all the matched records by searching through the database
    public Map<String, String> getResults(Set<String> words) {
        Map<String, String> result = new TreeMap<>();
        //a list of web pages for the users to visit directly, if matches the user input
        //the university guide page
        if(words.contains("university") || words.contains("college") || words.contains("colleges") || words.contains("universities")){
            result.put("See how IXN supports universities", "/university.html");
        }
        //the student guide page
        if(words.contains("student") || words.contains("students")){
            result.put("See how IXN supports students", "/student.html");
        }
        //the industry guide page
        if(words.contains("industry") || words.contains("industries") || words.contains("company") || words.contains("companies") || words.contains("enterprises") || words.contains("enterprise")){
            result.put("See how IXN supports industries", "/industry.html");
        }
        //the registration guide page
        if(words.contains("register") || words.contains("registration") || words.contains("registrations")) {
            result.put("See how to register yourself into Industry Exchange Network", "/registration.html");
        }
        for(String word : words){
            List<Post> posts = forumService.getPostsByTitle(word);
            if (posts.size() != 0){
                for(Post post:posts){
                    result.put("Post: "+ post.getTitle(), "/posts/getPage/" + post.getId());
                }
            }
            List<Info> infos = infoService.searchInfosByTopic(word);
            if (infos.size() != 0){
                for(Info info:infos){
                    String temp = info.getTopic().replace(".", "");
                    result.put("Info: "+ info.getTopic(), "/info.html#" + temp.replaceAll("\\s+",""));
                }
            }
            List<News> news = newsService.getNewsByTopic(word);
            if (news.size() != 0){
                for(News curNews: news){
                    String temp = curNews.getTitle().replace(".", "");
                    result.put("News: "+ curNews.getTitle(), "/news.html#" + temp.replaceAll("\\s+",""));
                }
            }
            List<Project> projects = projectService.getProjectsByTitle(word);
            if (projects.size() != 0){
                for(Project project:projects){
                    String temp = project.getTitle().replace(".", "");
                    result.put("Project: "+ project.getTitle(), "/projects.html#" + temp.replaceAll("\\s+",""));
                }
            }
        }
        if (result.size() == 0){
            result.put("NOMATCHINGRESULT", "NOMATCHINGRESULT");
        }
        return result;
    }


    @Autowired
    public void setWatsonConfig(WatsonConfig watsonConfig) {
        this.watsonConfig = watsonConfig;
    }
    @Autowired
    public void setForumService(ForumService forumService) {
        this.forumService = forumService;
    }
    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }
}
