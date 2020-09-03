package com.kodilla.homework22;

import ch.qos.logback.classic.Logger;
import com.kodilla.homework22.domain.NumbersDto;
import com.kodilla.homework22.event.CalculatedResultEvent;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController implements ApplicationEventPublisherAware {
    private final static Logger logger = (Logger) LoggerFactory.getLogger(CalculatorController.class);
    private ApplicationEventPublisher publisher;

    @PostMapping(path = "addition")
    public void add(@RequestBody NumbersDto numbers) {
        int result = numbers.getFirstNumber() + numbers.getSecondNumber();
        logger.info("Result of addition: " + result);
        publishEvent(result, "addition");
    }

    @PostMapping(path = "subtraction")
    public void subtract(@RequestBody NumbersDto numbers) {
        int result = numbers.getFirstNumber() - numbers.getSecondNumber();
        logger.info("Result of subtraction: " + result);
        publishEvent(result, "subtraction");

    }

    @PostMapping(path = "multiplication")
    public void multiply(@RequestBody NumbersDto numbers) {
        int result = numbers.getFirstNumber() * numbers.getSecondNumber();
        logger.info("Result of multiplication: " + result);
        publishEvent(result, "multiplication");
    }

    @PostMapping(path = "division")
    public void divide(@RequestBody NumbersDto numbers) {
        int result = numbers.getFirstNumber() / numbers.getSecondNumber();
        logger.info("Result of division: " + result);
        publishEvent(result, "division");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    private void publishEvent(int result, String operation) {
        publisher.publishEvent(
                new CalculatedResultEvent(
                        this,
                        result,
                        operation)
        );
    }
}
