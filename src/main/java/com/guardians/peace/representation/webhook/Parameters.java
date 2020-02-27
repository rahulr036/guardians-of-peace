package com.guardians.peace.representation.webhook;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameters {

    @JsonProperty(value = "param-name")
    private String paramName;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class ParametersBuilder {
        private String paramName;

        private ParametersBuilder() {
        }

        public static ParametersBuilder aParameters() {
            return new ParametersBuilder();
        }

        public ParametersBuilder withParamName(String paramName) {
            this.paramName = paramName;
            return this;
        }

        public Parameters build() {
            Parameters parameters = new Parameters();
            parameters.setParamName(paramName);
            return parameters;
        }
    }
}
