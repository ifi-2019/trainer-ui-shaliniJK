package com.ifi.trainer_ui.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

public class RestConfigurationTest {
    @Test
    void restTemplate_shouldExist() {
        var restTemplate = new RestConfiguration().restTemplate();

        assertNotNull(restTemplate);
    }

    @Test
    void trainerApiRestTemplate_shouldHaveBasicAuth() {
        var restTemplate = new RestConfiguration().trainerApiRestTemplate();

        assertNotNull(restTemplate);

        var interceptors = restTemplate.getInterceptors();
        assertNotNull(interceptors);
        assertEquals(1, interceptors.size());

        var interceptor = interceptors.get(0);
        assertNotNull(interceptor);

        assertEquals(BasicAuthenticationInterceptor.class, interceptor.getClass());
    }
}
