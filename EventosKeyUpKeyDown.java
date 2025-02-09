package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class EventosKeyUpKeyDown {
    WebDriver driver;

    @BeforeMethod
    public void configurarDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void CSSSelectorTagIdActivityTest() {
        driver.get("https://automationteststore.com/index.php?rt=account/create");

        Actions acts = new Actions(driver);

        // Localizar y escribir en mayúsculas en el campo "firstname"
        WebElement firstname = driver.findElement(By.cssSelector("input[id$='firstname']"));
        Action firstnameAct = acts.moveToElement(firstname)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("defaultfirstname")
                .keyUp(Keys.SHIFT)
                .build();
        firstnameAct.perform();

        // Localizar y escribir en mayúsculas en el campo "lastname"
        WebElement lastname = driver.findElement(By.cssSelector("input[id$='lastname']"));
        Action lastnameAct = acts.moveToElement(lastname)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("defaultlastname")
                .keyUp(Keys.SHIFT)
                .build();
        lastnameAct.perform();

        // Localizar y escribir en mayúsculas en el campo "email"
        WebElement email = driver.findElement(By.cssSelector("input[id$='email']"));
        Action emailAct = acts.moveToElement(email)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("email@default.com")
                .keyUp(Keys.SHIFT)
                .build();
        emailAct.perform();
    }

    @AfterMethod
    public void limpiarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
