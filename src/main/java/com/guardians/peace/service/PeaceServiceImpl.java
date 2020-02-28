package com.guardians.peace.service;

import com.guardians.peace.exception.PeaceException;
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
    public String getDefects(Map<String, String> requestedInputParams) {
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
}
