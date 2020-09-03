package com.kodilla.homework22.service;

import ch.qos.logback.classic.Logger;
import com.kodilla.homework22.event.CalculatedResultEvent;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatedResultListener implements ApplicationListener<CalculatedResultEvent> {
    private final static Logger logger = (Logger) LoggerFactory.getLogger(CalculatedResultListener.class);

    @Override
    public void onApplicationEvent(CalculatedResultEvent event) {
        logger.info("Logging event of " + event.getOperation() + " with result: " + event.getResult());
    }
}
