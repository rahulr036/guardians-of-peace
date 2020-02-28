package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Inputs {

    private String intent;

    private RawInputs[] rawInputs;

    private Arguments[] arguments;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public RawInputs[] getRawInputs() {
        return rawInputs;
    }

    public void setRawInputs(RawInputs[] rawInputs) {
        this.rawInputs = rawInputs;
    }

    public Arguments[] getArguments() {
        return arguments;
    }

    public void setArguments(Arguments[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class InputsBuilder {
        private String intent;
        private RawInputs[] rawInputs;
        private Arguments[] arguments;

        private InputsBuilder() {
        }

        public static InputsBuilder anInputs() {
            return new InputsBuilder();
        }

        public InputsBuilder withIntent(String intent) {
            this.intent = intent;
            return this;
        }

        public InputsBuilder withRawInputs(RawInputs[] rawInputs) {
            this.rawInputs = rawInputs;
            return this;
        }

        public InputsBuilder withArguments(Arguments[] arguments) {
            this.arguments = arguments;
            return this;
        }

        public Inputs build() {
            Inputs inputs = new Inputs();
            inputs.setIntent(intent);
            inputs.setRawInputs(rawInputs);
            inputs.setArguments(arguments);
            return inputs;
        }
    }
}
