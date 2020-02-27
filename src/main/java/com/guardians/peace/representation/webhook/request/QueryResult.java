package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guardians.peace.representation.webhook.OutputContexts;
import com.guardians.peace.representation.webhook.Parameters;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryResult {

    private String queryText;

    private Parameters parameters;

    private boolean allRequiredParamsPresent;

    private String fulfillmentText;

    private FulfillmentMessages[] fulfillmentMessages;

    private OutputContexts[] outputContexts;

    private Intent intent;

    private Integer intentDetectionConfidence;

    private DiagnosticInfo diagnosticInfo;

    private String languageCode;

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public boolean isAllRequiredParamsPresent() {
        return allRequiredParamsPresent;
    }

    public void setAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
        this.allRequiredParamsPresent = allRequiredParamsPresent;
    }

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public void setFulfillmentText(String fulfillmentText) {
        this.fulfillmentText = fulfillmentText;
    }

    public Integer getIntentDetectionConfidence() {
        return intentDetectionConfidence;
    }

    public void setIntentDetectionConfidence(Integer intentDetectionConfidence) {
        this.intentDetectionConfidence = intentDetectionConfidence;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public OutputContexts[] getOutputContexts() {
        return outputContexts;
    }

    public void setOutputContexts(OutputContexts[] outputContexts) {
        this.outputContexts = outputContexts;
    }

    public FulfillmentMessages[] getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public void setFulfillmentMessages(FulfillmentMessages[] fulfillmentMessages) {
        this.fulfillmentMessages = fulfillmentMessages;
    }

    public DiagnosticInfo getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(DiagnosticInfo diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class QueryResultBuilder {
        private String queryText;
        private Parameters parameters;
        private boolean allRequiredParamsPresent;
        private String fulfillmentText;
        private FulfillmentMessages[] fulfillmentMessages;
        private OutputContexts[] outputContexts;
        private Intent intent;
        private Integer intentDetectionConfidence;
        private DiagnosticInfo diagnosticInfo;
        private String languageCode;

        private QueryResultBuilder() {
        }

        public static QueryResultBuilder aQueryResult() {
            return new QueryResultBuilder();
        }

        public QueryResultBuilder withQueryText(String queryText) {
            this.queryText = queryText;
            return this;
        }

        public QueryResultBuilder withParameters(Parameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public QueryResultBuilder withAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
            this.allRequiredParamsPresent = allRequiredParamsPresent;
            return this;
        }

        public QueryResultBuilder withFulfillmentText(String fulfillmentText) {
            this.fulfillmentText = fulfillmentText;
            return this;
        }

        public QueryResultBuilder withFulfillmentMessages(FulfillmentMessages[] fulfillmentMessages) {
            this.fulfillmentMessages = fulfillmentMessages;
            return this;
        }

        public QueryResultBuilder withOutputContexts(OutputContexts[] outputContexts) {
            this.outputContexts = outputContexts;
            return this;
        }

        public QueryResultBuilder withIntent(Intent intent) {
            this.intent = intent;
            return this;
        }

        public QueryResultBuilder withIntentDetectionConfidence(Integer intentDetectionConfidence) {
            this.intentDetectionConfidence = intentDetectionConfidence;
            return this;
        }

        public QueryResultBuilder withDiagnosticInfo(DiagnosticInfo diagnosticInfo) {
            this.diagnosticInfo = diagnosticInfo;
            return this;
        }

        public QueryResultBuilder withLanguageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public QueryResult build() {
            QueryResult queryResult = new QueryResult();
            queryResult.setQueryText(queryText);
            queryResult.setParameters(parameters);
            queryResult.setAllRequiredParamsPresent(allRequiredParamsPresent);
            queryResult.setFulfillmentText(fulfillmentText);
            queryResult.setFulfillmentMessages(fulfillmentMessages);
            queryResult.setOutputContexts(outputContexts);
            queryResult.setIntent(intent);
            queryResult.setIntentDetectionConfidence(intentDetectionConfidence);
            queryResult.setDiagnosticInfo(diagnosticInfo);
            queryResult.setLanguageCode(languageCode);
            return queryResult;
        }
    }
}
