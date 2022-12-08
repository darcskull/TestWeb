package com.example.demo;

import jdk.internal.net.http.common.Pair;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping("/calculate")
	public Pair<Boolean, Integer> CalculateValue(
			@RequestParam(value ="firstNumber") String firstNumber,
			@RequestParam(value="secondNumber") String secondNumber) {
		try {
			int firstValue = Integer.parseInt(firstNumber);
			int secondValue = Integer.parseInt(secondNumber);

			if ( secondValue != 0){
				return new Pair<>(true, firstValue/secondValue);
			}
			else {
				return new Pair<>(false, 0);
			}

		}
		catch (Exception exception){
			return new Pair<>(false, 1);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}