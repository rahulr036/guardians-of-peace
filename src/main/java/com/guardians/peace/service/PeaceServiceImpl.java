package com.guardians.peace.service;

import com.guardians.peace.exception.PeaceException;
import com.guardians.peace.representation.jira.CreateJiraResponse;
import com.guardians.peace.representation.jira.JiraResponse;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

import static com.guardians.peace.constant.PeaceConstant.OPEN_DEFECT_QUERY;
import static com.guardians.peace.constant.PeaceConstant.SORRY_MESSAGE_RESPONSE;
import static org.slf4j.LoggerFactory.getLogger;

@Named
public class PeaceServiceImpl implements PeaceService {

    private static final Logger LOGGER = getLogger(PeaceServiceImpl.class);

    @Inject
    private JiraService jiraService;

    @Override
    public String getOpenDefects(Map<String, String> requestedInputParams) {
        LOGGER.info("Fetching the list of open defects");
        String openDefect = requestedInputParams.get("open-defect.original");
        String targetProduction = requestedInputParams.get("release.original");
        LOGGER.debug("Fetching defect from Jira with requested param as openDefect: {}, targetProduction: {}", openDefect, targetProduction);

        String jiraRequestUrlParam = OPEN_DEFECT_QUERY.replace("TARGET_PRODUCTION_VALUE", targetProduction);
        try {
            JiraResponse jiraResponse = jiraService.searchIssue(jiraRequestUrlParam);
            return "There are " + jiraResponse.getTotal().toString() + " defects as of now";
        } catch (PeaceException e) {
            return SORRY_MESSAGE_RESPONSE;
        }
    }

    @Override
    public String updateIssue(Map<String, String> requestedInputParams) {
        String issueNumber = requestedInputParams.get("issue-number.original");
        String comment = requestedInputParams.get("comment.original");

        try {
            jiraService.updateJira(comment, issueNumber);
            return "Jira has been updated successfully";
        } catch (PeaceException e) {
            return SORRY_MESSAGE_RESPONSE;
        }
    }

    @Override
    public String createIssue(Map<String, String> requestedInputParams) {
        String issueType = requestedInputParams.get("create-story.original");
        LOGGER.info("Creating a jira of issue type: {}", issueType);

        String createPaylod =
                        "{\"fields\":{\"project\":{\"key\":\"IBP\"},\"summary\":\"Test REST API for creating an Story\",\"description\":\"Creating an story\",\"issuetype\":{\"name\":\"INPUT_ISSUE_TYPE\"},\"priority\":{\"name\":\"Minor\"},\"customfield_10101\":{\"name\":\"Feature Team\",\"value\":\"Paymates\"}}}";
        createPaylod = createPaylod.replace("INPUT_ISSUE_TYPE", issueType);
        CreateJiraResponse response = jiraService.createIssue(createPaylod);
        return "Successfully created user story with id: " + response.getKey();
    }
}
