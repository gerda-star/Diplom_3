package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.RegisterPage;

public class RegisterClass extends BaseTest {
    RegisterPage registerPage;

    @Before
    @Step("Открытие страницы регистрации")
    public void openRegisterPage() {
        driver.get(register_url);
        registerPage = new RegisterPage();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registerTest(){
        waitForVisibility
    }
}
