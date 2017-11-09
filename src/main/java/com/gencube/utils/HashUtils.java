package com.gencube.utils;

import com.gencube.utils.CommonValues.BlankValues;
import java.util.zip.CRC32;

/**
 *
 * @author gencube
 */
public class HashUtils {

    private static final long POLY64REV = 0xd800000000000000L;

    private static final long[] LOOKUPTABLE;

    static {
        LOOKUPTABLE = new long[0x100];
        for (int i = 0; i < 0x100; i++) {
            long v = i;
            for (int j = 0; j < 8; j++) {
                if ((v & 1) == 1) {
                    v = (v >>> 1) ^ POLY64REV;
                } else {
                    v = (v >>> 1);
                }
            }
            LOOKUPTABLE[i] = v;
        }
    }

    static long toCrc64(final byte[] data) {
        long sum = 0;
        for (final byte b : data) {
            final int lookupidx = ((int) sum ^ b) & 0xff;
            sum = (sum >>> 8) ^ LOOKUPTABLE[lookupidx];
        }
        return sum;
    }

    public static long toCrc32(CharSequence data) {
        if (data == null) {
            return BlankValues.NULL_LONG;
        }
        byte[] bytes = data.toString().getBytes();
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        return crc32.getValue();
    }

    public static long toCrc64(CharSequence data) {
        if (data == null) {
            return BlankValues.NULL_LONG;
        }
        byte[] bytes = data.toString().getBytes();
        return toCrc64(bytes);
    }
}
