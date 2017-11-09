package com.gencube.sbjc.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * config JPA2 Models/Entities locations.
 *
 * @author gencube
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.gencube.sbjc.repos")
public class Jpa2Config {

}
