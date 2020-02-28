package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Arguments {

    private String name;

    private String rawText;

    private String textValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class ArgumentsBuilder {
        private String name;
        private String rawText;
        private String textValue;

        private ArgumentsBuilder() {
        }

        public static ArgumentsBuilder anArguments() {
            return new ArgumentsBuilder();
        }

        public ArgumentsBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ArgumentsBuilder withRawText(String rawText) {
            this.rawText = rawText;
            return this;
        }

        public ArgumentsBuilder withTextValue(String textValue) {
            this.textValue = textValue;
            return this;
        }

        public Arguments build() {
            Arguments arguments = new Arguments();
            arguments.setName(name);
            arguments.setRawText(rawText);
            arguments.setTextValue(textValue);
            return arguments;
        }
    }
}
