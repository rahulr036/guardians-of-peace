package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guardians.peace.representation.webhook.Parameters;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FollowupEventInput {

    private String name;

    private String languageCode;

    private Parameters parameters;

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

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class FollowupEventInputBuilder {
        private String name;
        private String languageCode;
        private Parameters parameters;

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

        public FollowupEventInputBuilder withParameters(Parameters parameters) {
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
