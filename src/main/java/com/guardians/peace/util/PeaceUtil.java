package com.guardians.peace.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guardians.peace.exception.PeaceException;

import javax.inject.Named;
import java.io.IOException;

@Named
public class PeaceUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private PeaceUtil() {
    }

    public static String toJson(Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new PeaceException("Failed to convert to Json with error: " + ex.getMessage(), ex);
        }
    }

    public static <T> T jsonToObject(String jsonString, Class<T> valueType) {
        try {
            return MAPPER.readValue(jsonString, valueType);
        } catch (IOException e) {
            throw new PeaceException("Failed to convert to Object with error: " + e.getMessage(), e);
        }

    }
}
