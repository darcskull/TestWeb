package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping("/calculate")
	public ResponseEntity<String> CalculateValue(
			@RequestParam(value = "firstNumber") String firstNumber,
			@RequestParam(value = "secondNumber") String secondNumber) {
		try {
			int firstValue = Integer.parseInt(firstNumber);
			int secondValue = Integer.parseInt(secondNumber);

			if (secondValue != 0) {
				int value = firstValue / secondValue;
				return ResponseEntity.ok(String.valueOf(value));
			} else {
				return ResponseEntity.ok("Делене на -0- не е разрешена операция");
			}

		} catch (Exception exception) {
			return ResponseEntity.ok("Невалидни числени стойности");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}