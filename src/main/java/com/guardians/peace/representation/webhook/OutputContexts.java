package com.guardians.peace.representation.webhook;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutputContexts {

    private String name;

    private Integer lifespanCount;

    private Parameters parameters;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLifespanCount() {
        return lifespanCount;
    }

    public void setLifespanCount(Integer lifespanCount) {
        this.lifespanCount = lifespanCount;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public static final class OutputContextsBuilder {
        private String name;
        private Integer lifespanCount;
        private Parameters parameters;

        private OutputContextsBuilder() {
        }

        public static OutputContextsBuilder anOutputContexts() {
            return new OutputContextsBuilder();
        }

        public OutputContextsBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public OutputContextsBuilder withLifespanCount(Integer lifespanCount) {
            this.lifespanCount = lifespanCount;
            return this;
        }

        public OutputContextsBuilder withParameters(Parameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public OutputContexts build() {
            OutputContexts outputContexts = new OutputContexts();
            outputContexts.setName(name);
            outputContexts.setLifespanCount(lifespanCount);
            outputContexts.setParameters(parameters);
            return outputContexts;
        }
    }
}
