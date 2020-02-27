package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Facebook {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class FacebookBuilder {
        private String text;

        private FacebookBuilder() {
        }

        public static FacebookBuilder aFacebook() {
            return new FacebookBuilder();
        }

        public FacebookBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public Facebook build() {
            Facebook facebook = new Facebook();
            facebook.setText(text);
            return facebook;
        }
    }
}
