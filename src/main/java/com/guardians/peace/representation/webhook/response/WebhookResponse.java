package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guardians.peace.representation.webhook.OutputContexts;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebhookResponse {

    private String fulfillmentText;

    private FulfillmentMessages[] fulfillmentMessages;

    private String source;

    private Payload payload;

    private OutputContexts[] outputContexts;

    private FollowupEventInput followupEventInput;

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public void setFulfillmentText(String fulfillmentText) {
        this.fulfillmentText = fulfillmentText;
    }

    public FulfillmentMessages[] getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public void setFulfillmentMessages(FulfillmentMessages[] fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public OutputContexts[] getOutputContexts() {
        return outputContexts;
    }

    public void setOutputContexts(OutputContexts[] outputContexts) {
        this.outputContexts = outputContexts;
    }

    public FollowupEventInput getFollowupEventInput() {
        return followupEventInput;
    }

    public void setFollowupEventInput(FollowupEventInput followupEventInput) {
        this.followupEventInput = followupEventInput;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class WebhookResponseBuilder {
        private String fulfillmentText;
        private FulfillmentMessages[] fulfillmentMessages;
        private String source;
        private Payload payload;
        private OutputContexts[] outputContexts;
        private FollowupEventInput followupEventInput;

        private WebhookResponseBuilder() {
        }

        public static WebhookResponseBuilder aWebhookResponse() {
            return new WebhookResponseBuilder();
        }

        public WebhookResponseBuilder withFulfillmentText(String fulfillmentText) {
            this.fulfillmentText = fulfillmentText;
            return this;
        }

        public WebhookResponseBuilder withFulfillmentMessages(FulfillmentMessages[] fulfillmentMessages) {
            this.fulfillmentMessages = fulfillmentMessages;
            return this;
        }

        public WebhookResponseBuilder withSource(String source) {
            this.source = source;
            return this;
        }

        public WebhookResponseBuilder withPayload(Payload payload) {
            this.payload = payload;
            return this;
        }

        public WebhookResponseBuilder withOutputContexts(OutputContexts[] outputContexts) {
            this.outputContexts = outputContexts;
            return this;
        }

        public WebhookResponseBuilder withFollowupEventInput(FollowupEventInput followupEventInput) {
            this.followupEventInput = followupEventInput;
            return this;
        }

        public WebhookResponse build() {
            WebhookResponse webhookResponse = new WebhookResponse();
            webhookResponse.setFulfillmentText(fulfillmentText);
            webhookResponse.setFulfillmentMessages(fulfillmentMessages);
            webhookResponse.setSource(source);
            webhookResponse.setPayload(payload);
            webhookResponse.setOutputContexts(outputContexts);
            webhookResponse.setFollowupEventInput(followupEventInput);
            return webhookResponse;
        }
    }
}
