package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextMessage {

    private String[] text;

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class TextMessageBuilder {
        private String[] text;

        private TextMessageBuilder() {
        }

        public static TextMessageBuilder aTextMessage() {
            return new TextMessageBuilder();
        }

        public TextMessageBuilder withText(String[] text) {
            this.text = text;
            return this;
        }

        public TextMessage build() {
            TextMessage textMessage = new TextMessage();
            textMessage.setText(text);
            return textMessage;
        }
    }
}
