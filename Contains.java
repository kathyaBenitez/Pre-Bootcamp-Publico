package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeContains {
    WebDriver driver;

    @BeforeMethod
    public void configurarDriver() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void chromeTest() {
        // Abre la página de prueba
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        // Localiza el botón "Make an Appointment" usando contains() y hace clic
        WebElement buttonElement = driver.findElement(By.xpath("//a[contains(@id,'btn-make-appointment')]"));
        buttonElement.click();

        // Imprime mensaje en consola
        System.out.println("Se hizo clic en el botón Make an Appointment.");
    }

    @AfterMethod
    public void cerrarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}


