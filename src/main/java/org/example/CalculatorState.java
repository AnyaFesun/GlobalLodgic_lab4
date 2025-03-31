package org.example;

public class CalculatorState {
    int screen;
    int firstNumber;
    char op;
    boolean startSecondNumber;

    public CalculatorState() {
        this.screen = 0;
        this.firstNumber = 0;
        this.op = ' ';
        this.startSecondNumber = true;
    }
}