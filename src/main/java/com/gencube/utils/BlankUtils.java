package com.gencube.utils;

import com.gencube.utils.CommonValues.BlankValues;

/**
 *
 * @author gencube
 */
public class BlankUtils {

    public static boolean isEmpty(Object object) {
        return (object == null || object == BlankValues.NULL
                || object == BlankValues.BLANK_STRING);
    }

}
