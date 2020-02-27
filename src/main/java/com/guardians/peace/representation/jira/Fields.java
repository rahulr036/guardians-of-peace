package com.guardians.peace.representation.jira;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fields {

    private String description;

    private String summary;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class FieldsBuilder {
        private String description;
        private String summary;

        private FieldsBuilder() {
        }

        public static FieldsBuilder aFields() {
            return new FieldsBuilder();
        }

        public FieldsBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public FieldsBuilder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Fields build() {
            Fields fields = new Fields();
            fields.setDescription(description);
            fields.setSummary(summary);
            return fields;
        }
    }
}
