package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleResponse {

    private String textToSpeech;

    public String getTextToSpeech() {
        return textToSpeech;
    }

    public void setTextToSpeech(String textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class SimpleResponseBuilder {
        private String textToSpeech;

        private SimpleResponseBuilder() {
        }

        public static SimpleResponseBuilder aSimpleResponse() {
            return new SimpleResponseBuilder();
        }

        public SimpleResponseBuilder withTextToSpeech(String textToSpeech) {
            this.textToSpeech = textToSpeech;
            return this;
        }

        public SimpleResponse build() {
            SimpleResponse simpleResponse = new SimpleResponse();
            simpleResponse.setTextToSpeech(textToSpeech);
            return simpleResponse;
        }
    }
}
