package co.com.runner;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Holamundo {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.pragma.com.co");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 
        String namePathScreenshot = "evidencia/1.jpg";

        FileUtils.copyFile(screenshot, new File(namePathScreenshot));

        newad.compareImage(namePathScreenshot, "evidencia/copia de 1.png");

        driver.quit();
    }
}
