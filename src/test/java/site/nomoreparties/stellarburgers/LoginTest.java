package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.pageObject.RegisterPage;

import static site.nomoreparties.stellarburgers.api.UserStep.createUser;

public class LoginTest extends BaseTest{

    @Before
    public void initForLoginTest(){
        userDTO = createUser();
//        mainPage = new MainPage(driver).openMainPage();
    }

    @Test
    @DisplayName("Вход через главную страницу, по кнопке 'Войти в аккаунт'")
    public void loginFromMainPageTest() {
        mainPage = new MainPage(driver).openMainPage()
                .clickSignIn()
                .fillLoginForm(userDTO.getEmail(), userDTO.getPassword())
                .clickLoginButton();
        Assert.assertTrue("После входа не открылась главная страница", mainPage.validateOpeningMainPage());
    }

    @Test
    @DisplayName("Вход через главную страницу, по кнопке 'Личный кабинет'")
    public void loginOnPersonalAccountFromMainPageTest() {
        loginPage = (LoginPage) new MainPage(driver).openMainPage()
                .clickAccountButton(false);
        mainPage = loginPage.fillLoginForm(userDTO.getEmail(), userDTO.getPassword())
                .clickLoginButton();
        Assert.assertTrue("После входа не открылась главная страница", mainPage.validateOpeningMainPage());

    }

    @Test
    @DisplayName("Вход через кнопку на странице регистрации")
    public void loginOnRegistrationPageTest() {
        mainPage = new RegisterPage(driver).openRegisterPage()
                .clickSignIn()
                .fillLoginForm(userDTO.getEmail(), userDTO.getPassword())
                .clickLoginButton();
        Assert.assertTrue("После входа не открылась главная страница", mainPage.validateOpeningMainPage());
    }

    @Test
    @DisplayName("Вход через кнопку на странице восстановления пароля")
    public void loginOnForgetPasswordPageTest() {
        mainPage = new LoginPage(driver).openLoginPage()
                .clickForgotPasswordButton()
                .clickSignIn()
                .fillLoginForm(userDTO.getEmail(), userDTO.getPassword())
                .clickLoginButton();
        Assert.assertTrue("После входа не открылась главная страница", mainPage.validateOpeningMainPage());
    }



}
