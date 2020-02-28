package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Capabilities {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class CapabilitiesBuilder {
        private String name;

        private CapabilitiesBuilder() {
        }

        public static CapabilitiesBuilder aCapabilities() {
            return new CapabilitiesBuilder();
        }

        public CapabilitiesBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Capabilities build() {
            Capabilities capabilities = new Capabilities();
            capabilities.setName(name);
            return capabilities;
        }
    }
}
