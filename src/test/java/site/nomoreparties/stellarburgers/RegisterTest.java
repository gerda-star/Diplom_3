package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.RegisterPage;

import static site.nomoreparties.stellarburgers.api.UserStep.*;


public class RegisterTest extends BaseTest {
    RegisterPage registerPage;
    LoginPage loginPage;

    @Before
    @Step("Открытие страницы регистрации")
    public void openRegisterPage() {
        registerPage = new RegisterPage(driver);
        driver.get(registerPage.url);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registerTest(){
        userDTO = generateUser();
        loginPage = registerPage.fillAuthForm(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword())
                .clickRegisterButton();
        Assert.assertTrue("Пользователь не зарегестрирован", loginPage.validateOpening());
    }

    @Test
    @DisplayName("Регистрация с невалидным паролем")
    public void registerWithInvalidPasswordTest(){
        userDTO = generateUser();
        setInvalidPassword(userDTO);
        registerPage.fillAuthForm(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword())
                .clickRegisterButton();
        Assert.assertTrue("Нет ошибки для невалидного пароля",
                registerPage.validateTextInvalidPassword());
    }



}
