package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Items {

    private SimpleResponse simpleResponse;

    public SimpleResponse getSimpleResponse() {
        return simpleResponse;
    }

    public void setSimpleResponse(SimpleResponse simpleResponse) {
        this.simpleResponse = simpleResponse;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class ItemsBuilder {
        private SimpleResponse simpleResponse;

        private ItemsBuilder() {
        }

        public static ItemsBuilder anItems() {
            return new ItemsBuilder();
        }

        public ItemsBuilder withSimpleResponse(SimpleResponse simpleResponse) {
            this.simpleResponse = simpleResponse;
            return this;
        }

        public Items build() {
            Items items = new Items();
            items.setSimpleResponse(simpleResponse);
            return items;
        }
    }
}
