package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @CrossOrigin
    @GetMapping("/calculate")
    public ResponseEntity<String> CalculateValue(
            @RequestParam(value = "firstNumber") String firstNumber,
            @RequestParam(value = "secondNumber") String secondNumber) {
        try {
            int firstValue = Integer.parseInt(firstNumber);
            int secondValue = Integer.parseInt(secondNumber);

            if (secondValue == 0) {
                return ResponseEntity.ok("Делене на -0- не е разрешена операция");
            }

            return ResponseEntity.ok(String.valueOf(firstValue / secondValue));

        } catch (Exception exception) {
            return ResponseEntity.ok("Невалидни числени стойности");
        }
    }
}
