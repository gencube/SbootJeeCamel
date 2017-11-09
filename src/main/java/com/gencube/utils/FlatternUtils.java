package com.gencube.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gencube.utils.CommonValues.BlankValues;
import static com.gencube.utils.CommonValues.BlankValues.NULL;
import com.gencube.utils.CommonValues.ErrorValues;

/**
 *
 * @author gencube
 */
public class FlatternUtils {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final String LS = System.lineSeparator();

    public static String toJson(Object object) {
        if (BlankUtils.isEmpty(object)) {
            return BlankValues.BLANK_JSON;
        }
        try {
            return JSON_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException jpe) {
            return ErrorValues.ERROR_JSON;
        }
    }

    public static String toString(Throwable ex) {
        if (ex == null) {
            return NULL;
        }

        StringBuilder bldr = new StringBuilder();
        bldr.append(ex.getClass().getName());
        bldr.append(LS);
        bldr.append(ex.getMessage());
        StackTraceElement[] el = ex.getStackTrace();
        for (int i = 0; i < el.length; i++) {
            bldr.append(LS);
            bldr.append('\t');
            bldr.append(el[i]);
        }
        return bldr.toString();
    }

}
