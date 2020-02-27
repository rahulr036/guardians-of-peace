package com.guardians.peace.representation.jira;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JiraResponse {

    private String expand;

    private Integer maxResults;

    private Integer startAt;

    private Integer total;

    private Issues[] issues;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Issues[] getIssues() {
        return issues;
    }

    public void setIssues(Issues[] issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class JiraResponseBuilder {
        private String expand;
        private Integer maxResults;
        private Integer startAt;
        private Integer total;
        private Issues[] issues;

        private JiraResponseBuilder() {
        }

        public static JiraResponseBuilder aJiraResponse() {
            return new JiraResponseBuilder();
        }

        public JiraResponseBuilder withExpand(String expand) {
            this.expand = expand;
            return this;
        }

        public JiraResponseBuilder withMaxResults(Integer maxResults) {
            this.maxResults = maxResults;
            return this;
        }

        public JiraResponseBuilder withStartAt(Integer startAt) {
            this.startAt = startAt;
            return this;
        }

        public JiraResponseBuilder withTotal(Integer total) {
            this.total = total;
            return this;
        }

        public JiraResponseBuilder withIssues(Issues[] issues) {
            this.issues = issues;
            return this;
        }

        public JiraResponse build() {
            JiraResponse jiraResponse = new JiraResponse();
            jiraResponse.setExpand(expand);
            jiraResponse.setMaxResults(maxResults);
            jiraResponse.setStartAt(startAt);
            jiraResponse.setTotal(total);
            jiraResponse.setIssues(issues);
            return jiraResponse;
        }
    }
}
