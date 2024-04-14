package ru.skyproera.springbootcalchw24;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    private final CalcServiceImpl CalcServiceImpl;

    public CalcController(CalcServiceImpl calcService) {
        CalcServiceImpl = calcService;
    }

    @GetMapping(path = "/calculator")
    public String welcome(){
        return CalcServiceImpl.welcome();
    }

    @GetMapping(path = "/calculator/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer num1,
                       @RequestParam(value = "num2", required = false) Integer num2) {

        if(num1 == null || num2 == null){
            return "Ошибка! Параметры операции заданы неверно";
        }
        return num1 + " + " + num2 + " = " + CalcServiceImpl.plus(num1, num2);
    }

    @GetMapping(path = "/calculator/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer num1,
                        @RequestParam(value = "num2", required = false) Integer num2) {

        if(num1 == null || num2 == null){
            return "Ошибка! Параметры операции заданы неверно";
        }
        return num1 + " - " + num2 + " = " + CalcServiceImpl.minus(num1, num2);
    }

    @GetMapping(path = "/calculator/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer num1,
                           @RequestParam(value = "num2", required = false) Integer num2) {

        if(num1 == null || num2 == null){
            return "Ошибка! Параметры операции заданы неверно";
        }
        return num1 + " * " + num2 + " = " + CalcServiceImpl.multiply(num1, num2);
    }

    @GetMapping(path = "/calculator/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer num1,
                         @RequestParam(value = "num2", required = false) Integer num2) {

        if(num1 == null || num2 == null){
            return "Ошибка! Параметры операции заданы неверно";
        }
        return num1 + " / " + num2 + " = " + CalcServiceImpl.divide(num1, num2);
    }
}
