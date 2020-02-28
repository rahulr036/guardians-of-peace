package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RawInputs {

    private String inputType;

    private String query;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class RawInputsBuilder {
        private String inputType;
        private String query;

        private RawInputsBuilder() {
        }

        public static RawInputsBuilder aRawInputs() {
            return new RawInputsBuilder();
        }

        public RawInputsBuilder withInputType(String inputType) {
            this.inputType = inputType;
            return this;
        }

        public RawInputsBuilder withQuery(String query) {
            this.query = query;
            return this;
        }

        public RawInputs build() {
            RawInputs rawInputs = new RawInputs();
            rawInputs.setInputType(inputType);
            rawInputs.setQuery(query);
            return rawInputs;
        }
    }
}
