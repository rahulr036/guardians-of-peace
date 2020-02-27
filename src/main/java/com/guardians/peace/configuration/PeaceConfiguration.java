package com.guardians.peace.configuration;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Base64;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
@ComponentScan(basePackages = { "com.guardians.peace" })
@PropertySource(value = "classpath:application.properties")
public class PeaceConfiguration {

    private static final String CREDENTIALS_SEPARATOR = ":";
    private static final String AUTHORIZATION_PREFIX = "Basic ";
    private static final Logger LOGGER = getLogger(PeaceConfiguration.class);

    @Value("${jira.base.url}")
    private String jiraBaseUrl;

    @Value("${jira.user.name}")
    private String jiraUser;

    @Value("${jira.api.auth.token}")
    private String jiraAuthToken;

    @Bean
    public String jiraBaseUrl() {
        LOGGER.info("Jira base URL is: {}", jiraBaseUrl);
        return jiraBaseUrl;
    }

    @Bean
    public String jiraAuthorizationToken() {
        LOGGER.info("Building authorization token to connect the Jira");
        String userCredentials = jiraUser.concat(CREDENTIALS_SEPARATOR).concat(jiraAuthToken);
        return AUTHORIZATION_PREFIX.concat(Base64.getEncoder().encodeToString(userCredentials.getBytes()));
    }

    @Autowired
    private Environment environment;
}
