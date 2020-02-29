package com.guardians.peace.service;

import com.guardians.peace.exception.PeaceException;
import com.guardians.peace.representation.jira.CreateJiraResponse;
import com.guardians.peace.representation.jira.JiraResponse;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

import static com.guardians.peace.constant.PeaceConstant.OPEN_DEFECT_QUERY;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.slf4j.LoggerFactory.getLogger;

@Named
public class PeaceServiceImpl implements PeaceService {

    private static final Logger LOGGER = getLogger(PeaceServiceImpl.class);
    private static final String SORRY_MESSAGE_RESPONSE = "Sorry! I could not get the requested data for you.";

    @Inject
    private JiraService jiraService;

    @Override
    public String getOpenDefects(Map<String, String> requestedInputParams) {
        LOGGER.info("Fetching the list of open defects");
        String openDefect = requestedInputParams.get("open-defect.original");
        String targetProduction = requestedInputParams.get("release.original");
        LOGGER.debug("Fetching defect from Jira with requested param as openDefect: {}, targetProduction: {}", openDefect, targetProduction);
        if (isBlank(openDefect)) {
            return SORRY_MESSAGE_RESPONSE;
        }
        String jiraRequestUrlParam = OPEN_DEFECT_QUERY.replace("TARGET_PRODUCTION_VALUE", targetProduction);
        try {
            JiraResponse jiraResponse = jiraService.searchIssue(jiraRequestUrlParam);
            return "There are " +  jiraResponse.getTotal().toString() + " defects as of now";
        } catch (PeaceException e) {
            return SORRY_MESSAGE_RESPONSE;
        }
    }

    @Override
    public String getJiraDetails(Map<String, String> requestedInputParams) {
        LOGGER.info("Getting the details of the defect");

        return null;
    }

    @Override
    public String createIssue(Map<String, String> requestedInputParams) {
        String issueType = requestedInputParams.get("create-story.original");
        LOGGER.info("Creating a jira of issue type: {}", issueType);

        String createPaylod = "{\"fields\":{\"project\":{\"key\":\"IBP\"},\"summary\":\"Test REST API for creating an Story\",\"description\":\"Creating an story\",\"issuetype\":{\"name\":\"Story\"},\"priority\":{\"name\":\"Minor\"},\"customfield_10101\":{\"name\":\"Feature Team\",\"value\":\"Paymates\"}}}";
        CreateJiraResponse response = jiraService.createIssue(createPaylod);
        return "Successfully created user story with id: " + response.getKey();
    }
}
