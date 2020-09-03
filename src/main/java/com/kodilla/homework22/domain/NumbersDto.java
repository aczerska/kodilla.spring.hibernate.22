package com.kodilla.homework22.domain;

public class NumbersDto {

    private int firstNumber;
    private int secondNumber;

    public NumbersDto(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }
}
