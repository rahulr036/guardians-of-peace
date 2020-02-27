package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Buttons {

    private String text;

    private String postback;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPostback() {
        return postback;
    }

    public void setPostback(String postback) {
        this.postback = postback;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class ButtonsBuilder {
        private String text;
        private String postback;

        private ButtonsBuilder() {
        }

        public static ButtonsBuilder aButtons() {
            return new ButtonsBuilder();
        }

        public ButtonsBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public ButtonsBuilder withPostback(String postback) {
            this.postback = postback;
            return this;
        }

        public Buttons build() {
            Buttons buttons = new Buttons();
            buttons.setText(text);
            buttons.setPostback(postback);
            return buttons;
        }
    }
}


