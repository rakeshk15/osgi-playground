package com.adeptj.modules.examples.playground.impl;

import com.adeptj.modules.examples.playground.ConstructorActivation;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@Designate(ocd = ConstructorActivationImpl.Config.class)
@Component
public class ConstructorActivationImpl implements ConstructorActivation {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final Config config;

    @Activate
    public ConstructorActivationImpl(Config config) {
        this.config = config;
    }

    @Override
    public void test() {
        LOGGER.info("Service Name: {}", this.config.service_name());
    }

    @ObjectClassDefinition(
            name = "AdeptJ ConstructorActivation Configuration",
            description = "Configuration for ConstructorActivation service."
    )
    public @interface Config {

        @AttributeDefinition(name = "Service Name", description = "Service Name")
        String service_name() default "ConstructorActivation";
    }
}
