package homework.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    private static final String templateAdd = "%.2f + %.2f = %.2f";
    private static final String templateSub = "%.2f - %.2f = %.2f";
    private static final String templateMul = "%.2f * %.2f = %.2f";
    private static final String templateDiv = "%.2f / %.2f = %.2f";

    @GetMapping("calc/add")
    public String add(@RequestParam(value = "first", defaultValue = "0") double first,
                    @RequestParam(value = "second", defaultValue = "0") double second) {
        return String.format(templateAdd, first, second, first + second);
    }

    @GetMapping("calc/sub")
    public String subtract(@RequestParam(value = "first", defaultValue = "0") double first,
                      @RequestParam(value = "second", defaultValue = "0") double second) {
        return String.format(templateSub, first, second, first - second);
    }

    @GetMapping("calc/multi")
    public String multiply(@RequestParam(value = "first", defaultValue = "0") double first,
                      @RequestParam(value = "second", defaultValue = "0") double second) {
        return String.format(templateMul, first, second, first * second);
    }

    @GetMapping("calc/div")
    public String divide(@RequestParam(value = "first", defaultValue = "0") double first,
                           @RequestParam(value = "second", defaultValue = "0") double second) {
        return String.format(templateDiv, first, second, first / second);
    }
}
