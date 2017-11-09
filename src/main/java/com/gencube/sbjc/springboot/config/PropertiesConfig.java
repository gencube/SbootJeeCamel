package com.gencube.sbjc.springboot.config;

import com.gencube.utils.MapUtils;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 *
 * @author gencube
 */
public class PropertiesConfig {

    private Environment env;

    private static String profile = "jee";

    @Autowired
    public void setEnvironment(Environment envProperties) {
        env = envProperties;
        profile = env.getActiveProfiles()[0];
    }

    public String getProperty(String name) {
        return env.getProperty(name);
    }

    public static Map<String, String> getProperties() {
        return MapUtils.getProperties(PropertiesConfig.class, "application-" + profile + ".properties");
    }

}
