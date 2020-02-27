package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Slack {

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

    public static final class SlackBuilder {
        private String text;

        private SlackBuilder() {
        }

        public static SlackBuilder aSlack() {
            return new SlackBuilder();
        }

        public SlackBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public Slack build() {
            Slack slack = new Slack();
            slack.setText(text);
            return slack;
        }
    }
}
