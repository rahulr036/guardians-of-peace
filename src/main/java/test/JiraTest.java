package test;

import com.guardians.peace.representation.jira.JiraResponse;
import com.guardians.peace.util.PeaceUtil;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import java.util.Base64;
import java.util.HashMap;

public class JiraTest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://abouthere.atlassian.net/rest/api/2"; // "https://testserver.atlassian.net/rest/api/2";
        String createIssueUrl = "/issue";
        String searchurl = "/search?jql=".concat("assignee = currentUser() AND status NOT IN (Closed, Cancelled, Done, Completed, \"In Use\", Resolved) & &fields=id,key,summary,description");
                        //concat("assignee=currentUser()&\"status not in\"(Closed,Cancelled,Done,Completed,\"In Use\",Resolved) '&fields=id,key,summary,description");//.concat("assignee='rahul.ranjan@cybg.com'&fields=id,key,summary,description");

        System.out.println("Request URL is: " + searchurl);

        String userCredentials = "vijayalakshmi.gs@cybg.com:g8S3HVFY1oPz5BvA2kUdDDC1";
       // String userCredentials = "rahul.ranjan@cybg.com:uerGHT17AYQv4lFSAefsE174";
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(userCredentials.getBytes());
        System.out.println("Basic auth is: " + basicAuth);

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", basicAuth);
        headerMap.put("Authorization", basicAuth);

        /*headerMap.put("http.proxyHost", "www-cache.eu.nag.net");
        headerMap.put("http.proxyPort", "3128");
        headerMap.put("http.proxyUser", "rahul.ranjan@cybg.com");
        headerMap.put("http.proxyPassword", "Tiger2010");
        System.getProperties().put("https.proxySet", "true");*/

        String createPaylod = "{\"fields\":{\"project\":{\"key\":\"IBP\"},\"summary\":\"Test REST API for creating an Story\",\"description\":\"Creating an issue\",\"assignee\":{\"name\":\"currentUser()\"},\"issuetype\":{\"name\":\"Story\"},\"priority\":{\"name\":\"Minor\"},\"customfield_10101\":{\"name\":\"Feature Team\",\"value\":\"Paymates\"}}}";
        //String createPaylod = "{\"fields\":{\"project\":{\"key\":\"IBP\"},\"summary\":\"Creating a subtask\",\"description\":\"Creating an issue\",\"issuetype\":{\"name\":\"Sub-task\"},\"priority\":{\"name\":\"Minor\"},\"customfield_10101\":{\"name\":\"Feature Team\",\"value\":\"Paymates\"}, \"parent\":{\"key\":\"IBP-3895\"}}}";

       // searchIssue(searchurl, headerMap);
        //createIssue(createIssueUrl, headerMap, createPaylod);

        String updateIssueUrl = "/issue/IBP-3895";
        String updatePayload = "{ \"update\": { \"Assignee\": [ {\"Set\": \"rahul.ranjan@cybg.com\"} ] } }";
        updateIssue(updateIssueUrl, headerMap, updatePayload);

    }

    public static void createIssue(String url, HashMap<String, String> headerMap, String body) {
        Response response = null;
        try {
            response = RestAssured.given().log().all().headers(headerMap).body(body).post(url);
            response.prettyPrint();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void searchIssue(String url, HashMap<String, String> headerMap) {
        Response response;
        try {
            response = RestAssured.given().log().all().headers(headerMap).get(url);

            JiraResponse jiraResponse = PeaceUtil.jsonToObject(response.prettyPrint(), JiraResponse.class);

            System.out.println("There are total defect: " + jiraResponse.getTotal());
        } catch (Throwable e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void updateIssue(String url, HashMap<String, String> headerMap, String body) {
        Response response = null;
        try {
            response = RestAssured.given().log().all().headers(headerMap).body(body).put(url);
            response.prettyPrint();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
