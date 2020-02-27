package com.guardians.peace.service;

import com.guardians.peace.representation.jira.JiraResponse;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import java.net.URLEncoder;
import java.util.HashMap;

import static org.slf4j.LoggerFactory.getLogger;

@Named
public class PeaceServiceImpl implements PeaceService {

    private static final Logger LOGGER = getLogger(PeaceServiceImpl.class);

    @Inject
    JiraService jiraService;

    @Inject
    private String jiraAuthorizationToken;

    @Override
    public String getDefects(String targetProductionRelease) {
        //"assignee='rahul.ranjan@cybg.com'&fields=id,key,summary,description"
        String jiraRequestUrlParam = "assignee='rahul.ranjan@cybg.com'&startAt=1&maxResults=10&fields=id,key,summary,description";

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", jiraAuthorizationToken);

        JiraResponse jiraResponse = jiraService.searchIssue(jiraRequestUrlParam, headerMap);

        //project = "iB Payments" AND "Target Production Release" = "iB18c - 2019" and status not in (closed,"SIT Deployment",Completed,"E2E / UAT","ready for tat deployment","deployed to tat","Deployed to Prod","TAT retest","TAT Testing","SIT retest","Ready for SIT Deployment","Ready for Prod Deployment",Cancelled,"Ready for INT deployment","INT retest","QA")
        String searchurl = "https://abouthere.atlassian.net/rest/api/2/search?jql=assignee='rahul.ranjan@cybg.com'&type=Defect&fields=id,key,summary,description,'Target Production Release'";
        return jiraResponse.getTotal().toString();
    }

    private String getUrl() {
        try {
           String out =  URLEncoder.encode("iB Payments\" AND \"Target Production Release\" = \"iB18c - 2019\" and status not in (closed,\"SIT Deployment\",Completed,\"E2E / UAT\",\"ready for tat deployment\",\"deployed to tat\",\"Deployed to Prod\",\"TAT retest\",\"TAT Testing\",\"SIT retest\",\"Ready for SIT Deployment\",\"Ready for Prod Deployment\",Cancelled,\"Ready for INT deployment\",\"INT retest\",\"QA\")", "UTF-8");
           System.out.println(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
