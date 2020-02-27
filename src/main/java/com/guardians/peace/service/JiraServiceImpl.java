package com.guardians.peace.service;

import com.guardians.peace.exception.PeaceException;
import com.guardians.peace.representation.jira.JiraResponse;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;

import static com.guardians.peace.util.PeaceUtil.jsonToObject;
import static org.slf4j.LoggerFactory.getLogger;

@Named
public class JiraServiceImpl implements JiraService {

    private static final Logger LOGGER = getLogger(JiraServiceImpl.class);
    private static final String SEARCH_PARAM_PREFIX = "/search?jql=";

    @Inject
    private String jiraBaseUrl;

    @Inject
    private String jiraAuthorizationToken;

    @Override
    public JiraResponse searchIssue(String searchUrl, HashMap<String, String> headerMap) {
        LOGGER.info("Sending the request to Jira with search URL parameter: {}", searchUrl);
        LOGGER.info("jiraBaseUrl: {}, jiraAuthorizationToken: {}", jiraBaseUrl, jiraAuthorizationToken);
        try {
            RestAssured.baseURI = jiraBaseUrl;
            Response response = RestAssured.given().log().all().headers(headerMap).get(SEARCH_PARAM_PREFIX.concat(searchUrl));

            JiraResponse jiraResponse = jsonToObject(response.prettyPrint(), JiraResponse.class);
            LOGGER.debug("Received response from Jira is: {}", jiraResponse);
            return jiraResponse;
        } catch (Exception e) {
            throw new PeaceException("Failed to fetch the response from Jira API with error: " + e.getMessage(), e);
        }
    }

    @Override
    public void createIssue(String requestUrl, HashMap<String, String> headerMap, String body) {
        LOGGER.info("Creating new issue on Jira");
        Response response;
        try {
            RestAssured.baseURI = jiraBaseUrl;
            response = RestAssured.given().log().all().headers(headerMap).body(body).post(requestUrl);
            response.prettyPrint();
        } catch (Exception e) {
            throw new PeaceException("Failed to create new issue on Jira API with error: " + e.getMessage(), e);
        }
    }
}
