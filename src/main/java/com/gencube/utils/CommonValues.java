package com.gencube.utils;

/**
 *
 * @author gencube
 */
public interface CommonValues {

    public interface BlankValues {

        public static final String NULL = "NULL";
        public static final long NULL_LONG = HashUtils.toCrc32(NULL);
        public static final int NULL_INT = (int) NULL_LONG;
        public static final double NULL_DOUBLE = NULL_LONG;
        public static final float NULL_FLOAT = NULL_LONG;

        public static final String BLANK_JSON = "{}";

        public static final String BLANK_STRING = "";
        public static final long BLANK_LONG = NULL_LONG;
        public static final int BLANK_INT = (int) NULL_LONG;
        public static final double BLANK_DOUBLE = NULL_LONG;
        public static final float BLANK_FLOAT = NULL_LONG;

    }

    public interface ErrorValues {

        // use very uncommon string to generate an error signal.
        public static final String ERROR_SPECIAL = "!#ErRoR+eRrOr#!";

        // generate a very low collision HEX value. 
        public static final String ERROR = Long.toHexString(HashUtils.toCrc64(ERROR_SPECIAL));

        public static final long ERROR_LONG = HashUtils.toCrc64(ERROR_SPECIAL);
        public static final int ERROR_INT = (int) ERROR_LONG;
        public static final double ERROR_DOUBLE = ERROR_LONG;
        public static final float ERROR_FLOAT = ERROR_LONG;

        public static final String ERROR_JSON = "{'error':'true'}";

    }

}
