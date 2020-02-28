package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OriginalDetectIntentRequest {

    private String source;

    private String version;

    private Payload payload;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class OriginalDetectIntentRequestBuilder {
        private String source;
        private String version;
        private Payload payload;

        private OriginalDetectIntentRequestBuilder() {
        }

        public static OriginalDetectIntentRequestBuilder anOriginalDetectIntentRequest() {
            return new OriginalDetectIntentRequestBuilder();
        }

        public OriginalDetectIntentRequestBuilder withSource(String source) {
            this.source = source;
            return this;
        }

        public OriginalDetectIntentRequestBuilder withVersion(String version) {
            this.version = version;
            return this;
        }

        public OriginalDetectIntentRequestBuilder withPayload(Payload payload) {
            this.payload = payload;
            return this;
        }

        public OriginalDetectIntentRequest build() {
            OriginalDetectIntentRequest originalDetectIntentRequest = new OriginalDetectIntentRequest();
            originalDetectIntentRequest.setSource(source);
            originalDetectIntentRequest.setVersion(version);
            originalDetectIntentRequest.setPayload(payload);
            return originalDetectIntentRequest;
        }
    }
}
