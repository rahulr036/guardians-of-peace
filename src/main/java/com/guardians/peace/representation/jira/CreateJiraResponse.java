package com.guardians.peace.representation.jira;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateJiraResponse {

    private String id;

    private String key;

    private String self;

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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class CreateJiraResponseBuilder {
        private String id;
        private String key;
        private String self;

        private CreateJiraResponseBuilder() {
        }

        public static CreateJiraResponseBuilder aCreateJiraResponse() {
            return new CreateJiraResponseBuilder();
        }

        public CreateJiraResponseBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public CreateJiraResponseBuilder withKey(String key) {
            this.key = key;
            return this;
        }

        public CreateJiraResponseBuilder withSelf(String self) {
            this.self = self;
            return this;
        }

        public CreateJiraResponse build() {
            CreateJiraResponse createJiraResponse = new CreateJiraResponse();
            createJiraResponse.setId(id);
            createJiraResponse.setKey(key);
            createJiraResponse.setSelf(self);
            return createJiraResponse;
        }
    }
}
