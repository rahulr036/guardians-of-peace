package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Surface {

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

    public static final class SurfaceBuilder {
        private Capabilities[] capabilities;

        private SurfaceBuilder() {
        }

        public static SurfaceBuilder aSurface() {
            return new SurfaceBuilder();
        }

        public SurfaceBuilder withCapabilities(Capabilities[] capabilities) {
            this.capabilities = capabilities;
            return this;
        }

        public Surface build() {
            Surface surface = new Surface();
            surface.setCapabilities(capabilities);
            return surface;
        }
    }
}
