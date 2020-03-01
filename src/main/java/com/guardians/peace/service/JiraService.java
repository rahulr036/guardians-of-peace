package com.guardians.peace.service;

import com.guardians.peace.representation.jira.CreateJiraResponse;
import com.guardians.peace.representation.jira.JiraResponse;

public interface JiraService {

    JiraResponse searchIssue(String searchUrl);

    CreateJiraResponse createIssue(String body);

    void updateJira(String comment, String issueNumber);

}
