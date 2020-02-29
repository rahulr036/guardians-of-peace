package com.guardians.peace.service;

import com.guardians.peace.exception.PeaceException;
import com.guardians.peace.representation.jira.CreateJiraResponse;
import com.guardians.peace.representation.jira.JiraResponse;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

import static com.guardians.peace.util.PeaceUtil.jsonToObject;
import static org.slf4j.LoggerFactory.getLogger;

@Named
public class JiraServiceImpl implements JiraService {

    private static final Logger LOGGER = getLogger(JiraServiceImpl.class);
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON_CONTENT_TYPE = "application/json";
    private static final String AUTHORIZATION = "Authorization";

    private static final String SEARCH_PARAM_PREFIX = "/search?jql=";
    private static final String CREATE_ISSUE_URL = "/issue";

    @Inject
    private String jiraBaseUrl;

    @Inject
    private String jiraAuthorizationToken;

    @Override
    public JiraResponse searchIssue(String searchUrl) {
        LOGGER.info("Sending the request to Jira with search URL parameter: {}", searchUrl);
        try {
            RestAssured.baseURI = jiraBaseUrl;
            Response response = RestAssured.given().log().all().headers(buildHeaders()).get(SEARCH_PARAM_PREFIX.concat(searchUrl));

            return jsonToObject(response.prettyPrint(), JiraResponse.class);
        } catch (Exception e) {
            throw new PeaceException("Failed to fetch the response from Jira API with error: " + e.getMessage(), e);
        }
    }

    @Override
    public CreateJiraResponse createIssue(String body) {
        LOGGER.info("Creating new issue on Jira");
        Response response;
        try {
            RestAssured.baseURI = jiraBaseUrl;
            response = RestAssured.given().log().all().headers(buildHeaders()).body(body).post(CREATE_ISSUE_URL);
            LOGGER.info("created issue: {}", response.prettyPrint());
            return jsonToObject(response.prettyPrint(), CreateJiraResponse.class);
        } catch (Exception e) {
            throw new PeaceException("Failed to create new issue on Jira API with error: " + e.getMessage(), e);
        }
    }

    private Map<String, String> buildHeaders() {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put(CONTENT_TYPE, APPLICATION_JSON_CONTENT_TYPE);
        headerMap.put(AUTHORIZATION, jiraAuthorizationToken);

        return headerMap;
    }
}
