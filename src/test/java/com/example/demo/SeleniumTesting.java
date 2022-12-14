package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class SeleniumTesting {

    @Test
    public void testPositiveNumbers() throws InterruptedException {
        testSelenium("12556", "55", String.valueOf(12556/55));
    }

    @Test
    public void testDivideByZero() throws InterruptedException {
        String zeroMessage = "Делене на -0- не е разрешена операция";
        testSelenium("12556", "0", zeroMessage);
    }

    @Test
    public void testInvalidFields() throws InterruptedException {
        String invalidMessage = "Невалидни числени стойности";
        testSelenium("5@34", "23!", invalidMessage);
    }

    public void testSelenium(String inputValue1, String inputValue2,
                             String expectedValue) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://localhost:8888/");
        WebElement textBox1 = driver.findElement(By.id("input-01"));
        textBox1.sendKeys(inputValue1);
        WebElement textBox2 = driver.findElement(By.id("input-02"));
        textBox2.sendKeys(inputValue2);
        Thread.sleep(4600);
        driver.findElement(By.cssSelector("button")).click();
        Thread.sleep(4600);
        String value = driver.findElement(By.id("input-03")).getAttribute("value");
        Assert.assertEquals(expectedValue, value);
        driver.quit();
    }

}
