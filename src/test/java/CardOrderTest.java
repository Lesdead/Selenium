import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardOrderTest {

    WebDriver driver;

    ChromeOptions options = new ChromeOptions();{
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--no-sandbox");
    options.addArguments("--headless");
    driver = new ChromeDriver(options);}

    @BeforeAll
    static void setupClass() {WebDriverManager.chromedriver().setup();}
    @BeforeEach
    void setupTest() {driver = new ChromeDriver();}
    @AfterEach
    void close() {if (driver != null) {driver.quit();}
    }

    @Test
    public void validTest() {
        driver.get("http://localhost:9999");
        
        driver.findElement(By.cssSelector("[type=\"text\"]")).sendKeys("Пупкин Вася");
        driver.findElement(By.cssSelector("[type=\"tel\"]")).sendKeys("+12345678901");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }
    @Test
    public void noValidNameTest() {
        driver.get("http://localhost:9999");

        driver.findElement(By.cssSelector("[type=\"text\"]")).sendKeys("Vasya Pupkin");
        driver.findElement(By.cssSelector("[type=\"tel\"]")).sendKeys("+12345678901");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.className("input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }
}