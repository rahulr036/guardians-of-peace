package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Conversation {

    private String conversationId;

    private String type;

    private String conversationToken;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConversationToken() {
        return conversationToken;
    }

    public void setConversationToken(String conversationToken) {
        this.conversationToken = conversationToken;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class ConversationBuilder {
        private String conversationId;
        private String type;
        private String conversationToken;

        private ConversationBuilder() {
        }

        public static ConversationBuilder aConversation() {
            return new ConversationBuilder();
        }

        public ConversationBuilder withConversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        public ConversationBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public ConversationBuilder withConversationToken(String conversationToken) {
            this.conversationToken = conversationToken;
            return this;
        }

        public Conversation build() {
            Conversation conversation = new Conversation();
            conversation.setConversationId(conversationId);
            conversation.setType(type);
            conversation.setConversationToken(conversationToken);
            return conversation;
        }
    }
}
