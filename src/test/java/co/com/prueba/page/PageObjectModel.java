package co.com.prueba.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageObjectModel {
    public static void main(String[] args) {
        System.out.println("Hola Mundo!");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Hola Mundo!",Keys.RETURN);
    }
}
