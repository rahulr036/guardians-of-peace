package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FollowupEventInput {

    private String name;

    private String languageCode;

    private Map<String, List<String>> parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Map getParameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        if (parameters == null) {
            this.parameters = new HashMap<>();
            return;
        }
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class FollowupEventInputBuilder {
        private String name;
        private String languageCode;
        private Map parameters;

        private FollowupEventInputBuilder() {
        }

        public static FollowupEventInputBuilder aFollowupEventInput() {
            return new FollowupEventInputBuilder();
        }

        public FollowupEventInputBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FollowupEventInputBuilder withLanguageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public FollowupEventInputBuilder withParameters(Map<String, List<String>> parameters) {
            this.parameters = parameters;
            return this;
        }

        public FollowupEventInput build() {
            FollowupEventInput followupEventInput = new FollowupEventInput();
            followupEventInput.setName(name);
            followupEventInput.setLanguageCode(languageCode);
            followupEventInput.setParameters(parameters);
            return followupEventInput;
        }
    }
}
