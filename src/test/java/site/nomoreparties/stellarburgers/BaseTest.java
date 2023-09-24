package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.pojo.UserDTO;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.pageObject.ProfilePage;
import site.nomoreparties.stellarburgers.pageObject.RegisterPage;

import java.time.Duration;

import static site.nomoreparties.stellarburgers.api.UserStep.*;
import static site.nomoreparties.stellarburgers.driver.WebDriverCreator.createWebDriver;


public class BaseTest {

    UserDTO userDTO;

    RegisterPage registerPage;
    LoginPage loginPage;
    MainPage mainPage;
    ProfilePage profilePage;

    WebDriver driver;

    @Before
    public void init_App()
    {
        driver = createWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void clean() {
        driver.quit();
        String accessToken = getToken(userDTO);
        if (accessToken != null) {
            deleteCreatedUser(accessToken);
        }
    }

}



