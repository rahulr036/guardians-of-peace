package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payload {

    @JsonProperty(value = "isInSandbox")
    private boolean inSandbox;

    private String requestType;

    private Conversation conversation;

    private User user;

    private Surface surface;

    private AvailableSurfaces[] availableSurfaces;

    private Inputs[] inputs;

    public boolean isInSandbox() {
        return inSandbox;
    }

    public void setInSandbox(boolean inSandbox) {
        this.inSandbox = inSandbox;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Surface getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public AvailableSurfaces[] getAvailableSurfaces() {
        return availableSurfaces;
    }

    public void setAvailableSurfaces(AvailableSurfaces[] availableSurfaces) {
        this.availableSurfaces = availableSurfaces;
    }

    public Inputs[] getInputs() {
        return inputs;
    }

    public void setInputs(Inputs[] inputs) {
        this.inputs = inputs;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class PayloadBuilder {
        private boolean inSandbox;
        private String requestType;
        private Conversation conversation;
        private User user;
        private Surface surface;
        private AvailableSurfaces[] availableSurfaces;
        private Inputs[] inputs;

        private PayloadBuilder() {
        }

        public static PayloadBuilder aPayload() {
            return new PayloadBuilder();
        }

        public PayloadBuilder withIsInSandbox(boolean inSandbox) {
            this.inSandbox = inSandbox;
            return this;
        }

        public PayloadBuilder withRequestType(String requestType) {
            this.requestType = requestType;
            return this;
        }

        public PayloadBuilder withConversation(Conversation conversation) {
            this.conversation = conversation;
            return this;
        }

        public PayloadBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public PayloadBuilder withSurface(Surface surface) {
            this.surface = surface;
            return this;
        }

        public PayloadBuilder withAvailableSurfaces(AvailableSurfaces[] availableSurfaces) {
            this.availableSurfaces = availableSurfaces;
            return this;
        }

        public PayloadBuilder withInputs(Inputs[] inputs) {
            this.inputs = inputs;
            return this;
        }

        public Payload build() {
            Payload payload = new Payload();
            payload.setRequestType(requestType);
            payload.setConversation(conversation);
            payload.setUser(user);
            payload.setSurface(surface);
            payload.setAvailableSurfaces(availableSurfaces);
            payload.setInputs(inputs);
            payload.inSandbox = this.inSandbox;
            return payload;
        }
    }
}
