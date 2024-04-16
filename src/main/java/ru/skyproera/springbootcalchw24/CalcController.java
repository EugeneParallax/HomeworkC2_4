package ru.skyproera.springbootcalchw24;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalcController {
    private final CalcServiceImpl calcServiceImpl;

    public CalcController(CalcServiceImpl calcService) {
        calcServiceImpl = calcService;
    }

    @GetMapping()
    public String welcome(){
        return calcServiceImpl.welcome();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(value = "num1", required = false) Integer num1,
                       @RequestParam(value = "num2", required = false) Integer num2) {

        if(num1 == null || num2 == null){
            return "Ошибка! Параметры операции заданы неверно";
        }
        return num1 + " + " + num2 + " = " + calcServiceImpl.plus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer num1,
                        @RequestParam(value = "num2", required = false) Integer num2) {

        if(num1 == null || num2 == null){
            return "Ошибка! Параметры операции заданы неверно";
        }
        return num1 + " - " + num2 + " = " + calcServiceImpl.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer num1,
                           @RequestParam(value = "num2", required = false) Integer num2) {

        if(num1 == null || num2 == null){
            return "Ошибка! Параметры операции заданы неверно";
        }
        return num1 + " * " + num2 + " = " + calcServiceImpl.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer num1,
                         @RequestParam(value = "num2", required = false) Integer num2) {

        if(num1 == null || num2 == null){
            return "Ошибка! Параметры операции заданы неверно";
        }
        if(num2 == 0){
            return "Ошибка! Деление на ноль невозможно";
        }
        return num1 + " / " + num2 + " = " + calcServiceImpl.divide(num1, num2);
    }
}
