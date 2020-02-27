package com.guardians.peace.representation.webhook.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiagnosticInfo {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
