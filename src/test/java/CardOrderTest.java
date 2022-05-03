import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

class CardOrderTest {

    WebDriver driver;
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--disable-dev-shm-usage");
//    options.addArguments("--no-sandbox");
//    options.addArguments("--headless");
//    driver = new ChromeDriver(options);

    @BeforeAll
    static void setupClass() {WebDriverManager.chromedriver().setup();}
    @BeforeEach
    void setupTest() {driver = new ChromeDriver();}
    @AfterEach
    void close() {if (driver != null) {driver.quit();}
    }

    @Test
    void test() {
        // Your test logic here
    }

}