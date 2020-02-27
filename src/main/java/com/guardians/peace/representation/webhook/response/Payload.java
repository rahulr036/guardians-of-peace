package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload {

    private Google google;

    private Facebook facebook;

    private Slack slack;

    public Google getGoogle() {
        return google;
    }

    public void setGoogle(Google google) {
        this.google = google;
    }

    public Facebook getFacebook() {
        return facebook;
    }

    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

    public Slack getSlack() {
        return slack;
    }

    public void setSlack(Slack slack) {
        this.slack = slack;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class PayloadBuilder {
        private Google google;
        private Facebook facebook;
        private Slack slack;

        private PayloadBuilder() {
        }

        public static PayloadBuilder aPayload() {
            return new PayloadBuilder();
        }

        public PayloadBuilder withGoogle(Google google) {
            this.google = google;
            return this;
        }

        public PayloadBuilder withFacebook(Facebook facebook) {
            this.facebook = facebook;
            return this;
        }

        public PayloadBuilder withSlack(Slack slack) {
            this.slack = slack;
            return this;
        }

        public Payload build() {
            Payload payload = new Payload();
            payload.setGoogle(google);
            payload.setFacebook(facebook);
            payload.setSlack(slack);
            return payload;
        }
    }
}
