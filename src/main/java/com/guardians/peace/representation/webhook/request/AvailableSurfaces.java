package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvailableSurfaces {

    private Capabilities[] capabilities;

    public Capabilities[] getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities[] capabilities) {
        this.capabilities = capabilities;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class AvailableSurfacesBuilder {
        private Capabilities[] capabilities;

        private AvailableSurfacesBuilder() {
        }

        public static AvailableSurfacesBuilder anAvailableSurfaces() {
            return new AvailableSurfacesBuilder();
        }

        public AvailableSurfacesBuilder withCapabilities(Capabilities[] capabilities) {
            this.capabilities = capabilities;
            return this;
        }

        public AvailableSurfaces build() {
            AvailableSurfaces availableSurfaces = new AvailableSurfaces();
            availableSurfaces.setCapabilities(capabilities);
            return availableSurfaces;
        }
    }
}
