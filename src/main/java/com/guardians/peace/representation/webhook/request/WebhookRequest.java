package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebhookRequest {

    private String responseId;

    private String session;

    private QueryResult queryResult;

    private OriginalDetectIntentRequest originalDetectIntentRequest;

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(QueryResult queryResult) {
        this.queryResult = queryResult;
    }

    public OriginalDetectIntentRequest getOriginalDetectIntentRequest() {
        return originalDetectIntentRequest;
    }

    public void setOriginalDetectIntentRequest(OriginalDetectIntentRequest originalDetectIntentRequest) {
        this.originalDetectIntentRequest = originalDetectIntentRequest;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class WebhookRequestBuilder {
        private String responseId;
        private String session;
        private QueryResult queryResult;
        private OriginalDetectIntentRequest originalDetectIntentRequest;

        private WebhookRequestBuilder() {
        }

        public static WebhookRequestBuilder aWebhookRequest() {
            return new WebhookRequestBuilder();
        }

        public WebhookRequestBuilder withResponseId(String responseId) {
            this.responseId = responseId;
            return this;
        }

        public WebhookRequestBuilder withSession(String session) {
            this.session = session;
            return this;
        }

        public WebhookRequestBuilder withQueryResult(QueryResult queryResult) {
            this.queryResult = queryResult;
            return this;
        }

        public WebhookRequestBuilder withOriginalDetectIntentRequest(OriginalDetectIntentRequest originalDetectIntentRequest) {
            this.originalDetectIntentRequest = originalDetectIntentRequest;
            return this;
        }

        public WebhookRequest build() {
            WebhookRequest webhookRequest = new WebhookRequest();
            webhookRequest.setResponseId(responseId);
            webhookRequest.setSession(session);
            webhookRequest.setQueryResult(queryResult);
            webhookRequest.setOriginalDetectIntentRequest(originalDetectIntentRequest);
            return webhookRequest;
        }
    }
}
