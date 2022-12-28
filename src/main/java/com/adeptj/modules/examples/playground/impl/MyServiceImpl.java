package com.adeptj.modules.examples.playground.impl;

import com.adeptj.modules.examples.playground.MyService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@Component(immediate = true)
public class MyServiceImpl implements MyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void hello() {
        LOGGER.info("Invoked Hello Method!!");
    }

    @Activate
    protected void start() {
        LOGGER.info("@@@@@ MyServiceImpl start @@@@@");
    }

    @Deactivate
    protected void stop() {
        LOGGER.info("@@@@@ MyServiceImpl stop @@@@@");
    }
}
