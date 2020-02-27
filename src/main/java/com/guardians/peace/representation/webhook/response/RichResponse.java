package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RichResponse {

    private Items[] items;

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class RichResponseBuilder {
        private Items[] items;

        private RichResponseBuilder() {
        }

        public static RichResponseBuilder aRichResponse() {
            return new RichResponseBuilder();
        }

        public RichResponseBuilder withItems(Items[] items) {
            this.items = items;
            return this;
        }

        public RichResponse build() {
            RichResponse richResponse = new RichResponse();
            richResponse.setItems(items);
            return richResponse;
        }
    }
}
