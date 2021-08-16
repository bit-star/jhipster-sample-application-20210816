package com.kyanite.sample;

import com.kyanite.sample.JhipsterSampleApplication20210816App;
import com.kyanite.sample.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { JhipsterSampleApplication20210816App.class, TestSecurityConfiguration.class })
public @interface IntegrationTest {
}
