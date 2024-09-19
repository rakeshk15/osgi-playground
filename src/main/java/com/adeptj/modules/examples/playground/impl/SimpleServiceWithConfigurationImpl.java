package com.adeptj.modules.examples.playground.impl;

import com.adeptj.modules.examples.playground.SimpleServiceWithConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@Designate(ocd = SimpleServiceWithConfigurationImpl.Config.class)
@Component
public class SimpleServiceWithConfigurationImpl implements SimpleServiceWithConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Config config;

    @Override
    public void test() {
        LOGGER.info("Service Name: {}", this.config.service_name());
    }

    @Activate
    protected void start(Config config) {
        this.config = config;
    }

    @ObjectClassDefinition(
            name = "AdeptJ SimpleServiceWithConfiguration Configuration",
            description = "Configuration for SimpleServiceWithConfiguration service."
    )
    public @interface Config {

        @AttributeDefinition(name = "Service Name", description = "Service Name")
        String service_name() default "SimpleServiceWithConfiguration";
    }
}
