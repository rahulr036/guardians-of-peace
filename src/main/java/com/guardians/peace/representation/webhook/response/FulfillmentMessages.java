package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FulfillmentMessages {

    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class FulfillmentMessagesBuilder {
        private Card card;

        private FulfillmentMessagesBuilder() {
        }

        public static FulfillmentMessagesBuilder aFulfillmentMessages() {
            return new FulfillmentMessagesBuilder();
        }

        public FulfillmentMessagesBuilder withCard(Card card) {
            this.card = card;
            return this;
        }

        public FulfillmentMessages build() {
            FulfillmentMessages fulfillmentMessages = new FulfillmentMessages();
            fulfillmentMessages.setCard(card);
            return fulfillmentMessages;
        }
    }
}
