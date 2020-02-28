package com.guardians.peace.service;

import com.guardians.peace.representation.jira.JiraResponse;

import java.util.HashMap;

public interface JiraService {

    JiraResponse searchIssue(String searchUrl);

    void createIssue(String requestUrl, HashMap<String, String> headerMap, String body);

}
