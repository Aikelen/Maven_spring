package pro.sky.counter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.counter.service.CalculateService;

@RestController()
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculateService calculateService;

    public CalculatorController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String add(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculateService.add(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @GetMapping("/minus")
    public String subtract(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculateService.subtract(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculateService.multiply(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        double result = calculateService.divide(num1, num2);
        return String.format("%d / %d = %s", num1, num2,
                result == (long) result ? String.format("%d", (long) result) : String.format("%.2f", result));
    }
}