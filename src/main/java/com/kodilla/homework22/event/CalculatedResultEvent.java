package com.kodilla.homework22.event;

import org.springframework.context.ApplicationEvent;

public class CalculatedResultEvent extends ApplicationEvent {
    private int result;
    private String operation;

    public CalculatedResultEvent(Object source, int result, String operation) {
        super(source);
        this.result = result;
        this.operation = operation;
    }

    public int getResult() {
        return result;
    }

    public String getOperation() {
        return operation;
    }
}
