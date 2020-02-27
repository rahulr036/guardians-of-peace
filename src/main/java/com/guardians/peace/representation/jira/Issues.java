package com.guardians.peace.representation.jira;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issues {

    private String expand;

    private String id;

    private String key;

    private String self;

    private Fields fields;

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class IssuesBuilder {
        private String expand;
        private String id;
        private String key;
        private String self;
        private Fields fields;

        private IssuesBuilder() {
        }

        public static IssuesBuilder anIssues() {
            return new IssuesBuilder();
        }

        public IssuesBuilder withExpand(String expand) {
            this.expand = expand;
            return this;
        }

        public IssuesBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public IssuesBuilder withKey(String key) {
            this.key = key;
            return this;
        }

        public IssuesBuilder withSelf(String self) {
            this.self = self;
            return this;
        }

        public IssuesBuilder withFields(Fields fields) {
            this.fields = fields;
            return this;
        }

        public Issues build() {
            Issues issues = new Issues();
            issues.setExpand(expand);
            issues.setId(id);
            issues.setKey(key);
            issues.setSelf(self);
            issues.setFields(fields);
            return issues;
        }
    }
}
