package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class CSSSelectorTagIdActivity {
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

        // Localizar input de firstname usando CSS Selector tag y id
        WebElement firstname = driver.findElement(By.cssSelector("input#AccountFrm_firstname"));
        firstname.sendKeys("defaultusername");

        // Localizar input de lastname usando CSS Selector tag y id
        WebElement lastname = driver.findElement(By.cssSelector("input#AccountFrm_lastname"));
        lastname.sendKeys("defaultpassword");
    }

    @AfterMethod
    public void limpiarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
