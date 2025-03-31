package org.example;

public class Calculator {

    private static String[] parse(String input) {
        return input.trim().split("\\s+");
    }

    private static void handleKeyPress(CalculatorState state, String key) throws InvalidInputException{
        if (key.matches("[0-9]")) {
            int digit = Integer.parseInt(key);

            if (state.startSecondNumber) {
                state.screen = digit;
                state.startSecondNumber = false;
            } else {
                state.screen = state.screen * 10 + digit;
            }
        } else if (key.equals("+") || key.equals("-") || key.equals("*") || key.equals("/")) {
            if (state.op == ' '){
                state.op = key.charAt(0);
                state.firstNumber = state.screen;
                state.startSecondNumber = true;
            } else {
                throw new InvalidInputException("Помилка: Ввід має містити лише одну арифметичну операцію");
            }
        } else if (key.equals("=")) {
            calculateResult(state);
        } else if (!key.isEmpty()) {
            throw new InvalidInputException("Помилка: некоректна клавіша \"" + key + "\"");
        }
    }

    private static void calculateResult(CalculatorState state) {
        if(!state.startSecondNumber){
            switch (state.op) {
                case '+':
                    state.screen = state.firstNumber + state.screen;
                    break;
                case '-':
                    state.screen = state.firstNumber - state.screen;
                    break;
                case '*':
                    state.screen = state.firstNumber * state.screen;
                    break;
                case '/':
                    if (state.screen == 0) {
                        throw new ArithmeticException("Ділення на нуль!");
                    }
                    state.screen = state.firstNumber / state.screen;
                    break;
            }
        }
    }

    public static String calculate(String input) {
        String[] keys = parse(input);
        CalculatorState state = new CalculatorState();
        try {
            for (String key : keys) {
                handleKeyPress(state, key);
            }
        } catch (InvalidInputException e) {
            return e.getMessage();
        } catch (ArithmeticException e) {
            return "Помилка: арифметична помилка - " + e.getMessage();
        }

        return String.valueOf(state.screen);
    }
}