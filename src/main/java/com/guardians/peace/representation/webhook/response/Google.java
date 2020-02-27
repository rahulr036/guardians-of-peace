package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Google {

    private Boolean expectUserResponse;

    private RichResponse richResponse;

    public Boolean getExpectUserResponse() {
        return expectUserResponse;
    }

    public void setExpectUserResponse(Boolean expectUserResponse) {
        this.expectUserResponse = expectUserResponse;
    }

    public RichResponse getRichResponse() {
        return richResponse;
    }

    public void setRichResponse(RichResponse richResponse) {
        this.richResponse = richResponse;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class GoogleBuilder {
        private Boolean expectUserResponse;
        private RichResponse richResponse;

        private GoogleBuilder() {
        }

        public static GoogleBuilder aGoogle() {
            return new GoogleBuilder();
        }

        public GoogleBuilder withExpectUserResponse(Boolean expectUserResponse) {
            this.expectUserResponse = expectUserResponse;
            return this;
        }

        public GoogleBuilder withRichResponse(RichResponse richResponse) {
            this.richResponse = richResponse;
            return this;
        }

        public Google build() {
            Google google = new Google();
            google.setExpectUserResponse(expectUserResponse);
            google.setRichResponse(richResponse);
            return google;
        }
    }
}
