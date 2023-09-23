package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.api.pojo.UserDTO;

import java.time.Duration;

import static site.nomoreparties.stellarburgers.api.UserStep.*;
import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;
import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;


public class BaseTest {

    UserDTO userDTO;

    WebDriver driver;
    String register_url = APP_URL + "/register";

    @Before
    public void init()
    {
        driver = createWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void clean() {
        String accessToken = getToken(userDTO);
        if (accessToken != null) {
            deleteCreatedUser(accessToken);
        }
        driver.quit();
    }

    public void waitForVisibility(By element) {
//        new WebDriverWait(driver, Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }
}



