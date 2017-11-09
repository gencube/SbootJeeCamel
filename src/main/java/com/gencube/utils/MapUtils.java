package com.gencube.utils;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author gencube
 */
public class MapUtils {

    public static <K, V> Map<K, V> newMap() {
        return new ConcurrentHashMap<>();
    }

    public static Map<String, String> toMap(Properties props) {
        Map<String, String> map = newMap();
        Enumeration e = props.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = props.getProperty(key);
            map.put(key, value);
        }
        return map;
    }

    public static Map<String, String> getProperties(Class<?> clazz, String clazzPath) {
        Properties props = new Properties();
        try {
            props.load(clazz.getClassLoader().getResourceAsStream(clazzPath));
        } catch (IOException e) {
            return Collections.EMPTY_MAP;
        }
        return toMap(props);
    }

}
