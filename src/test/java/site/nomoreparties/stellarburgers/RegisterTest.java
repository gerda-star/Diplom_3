package site.nomoreparties.stellarburgers;


import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.pageObject.RegisterPage;

import static site.nomoreparties.stellarburgers.api.UserStep.*;


public class RegisterTest extends BaseTest {


    @Before
    public void init() {
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registerTest(){
        userDTO = generateUser();
        loginPage = new MainPage(driver).openMainPage()
                .clickSignIn()
                .clickRegistrationButton()
                .fillRegForm(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword())
                .clickRegisterButton();
        Assert.assertTrue("Пользователь не зарегестрирован", loginPage.validateOpeningLoginPage());
    }

    @Test
    @DisplayName("Регистрация с невалидным паролем")
    public void registerWithInvalidPasswordTest(){
        userDTO = generateUser();
        setInvalidPassword(userDTO);
        new RegisterPage(driver).openRegisterPage()
                .fillRegForm(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword())
                .clickRegisterButton();
        Assert.assertTrue("Нет ошибки для пароля менее 6 символов",
                registerPage.validateInvalidPasswordText());
    }



}
