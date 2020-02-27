package test;

/*import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.SearchRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;*/

public class JiraRestClientExample {

    /*public static void main(String[] args) {
        System.out.println("START");
        final String jiraUser = "r900920";
        final String jiraPassword = "Plenty2010$";
        final String jiraBaseURL = "https://abouthere.atlassian.net";
        URI jiraServerUri = null;
        JiraRestClient client = null;
        try {
            jiraServerUri = new URI(jiraBaseURL);
            JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
            client = factory.createWithBasicHttpAuthentication(jiraServerUri, jiraUser, jiraPassword);
            IssueRestClient issueClient = client.getIssueClient();
            SearchRestClient searchClient = client.getSearchClient();

            java.net.URI uri = new URI(jiraBaseURL);

            SearchRestClient searchRestClient = factory.createWithBasicHttpAuthentication(uri, jiraUser, jiraPassword).getSearchClient();
            SearchResult result = searchRestClient.searchJql("browse/IGS-3701", 100, 0, null).claim();

            for (Issue issue : result.getIssues()) {

                System.out.println(issue.getKey());

            }

        } catch (Throwable e) {
            System.out.println("Why exception " + e);
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }*/

}