package pro.sky.counter.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceIml implements CalculateService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль нельзя");
        }
        return (double) a / b;
    }
}
