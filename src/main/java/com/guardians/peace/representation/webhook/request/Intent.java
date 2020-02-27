package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Intent {

    private String name;
    private String displayName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class IntentBuilder {
        private String name;
        private String displayName;

        private IntentBuilder() {
        }

        public static IntentBuilder anIntent() {
            return new IntentBuilder();
        }

        public IntentBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public IntentBuilder withDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Intent build() {
            Intent intent = new Intent();
            intent.setName(name);
            intent.setDisplayName(displayName);
            return intent;
        }
    }
}
