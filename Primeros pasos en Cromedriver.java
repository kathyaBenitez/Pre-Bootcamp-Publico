package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PrimerosPasosEnCromedriver {
    WebDriver driver;

    @BeforeMethod
    public void configurarDriver() {
        // WebDriverManager gestiona automáticamente ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void chromeTest() {
        driver.get("http://www.automationpractice.pl/");
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Búsqueda realizada correctamente.");
    }

    @AfterMethod
    public void cerrarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
