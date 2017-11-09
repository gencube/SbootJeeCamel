package com.gencube.sbjc.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * @author gencube
 */
@EntityScan(basePackages = "com.gencube.sbjc.models")
@SpringBootApplication
public class SpringBootMain
        extends SpringBootServletInitializer
        implements WebApplicationInitializer {
    // enable EJB3 loading in wildfly/weblogic/...

    private static final Class<SpringBootMain> CLASS = SpringBootMain.class;

    public static void main(String[] args) {

        // use this to run the development environment.        
        new SpringApplicationBuilder(CLASS).profiles("spr").web(true).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        // use this to run the sit/vsit/production environment.         
        return builder.sources(CLASS).profiles("jee");
    }

}
