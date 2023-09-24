package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.ProfilePage;

import static site.nomoreparties.stellarburgers.api.UserStep.createUser;

public class ProfileTest extends BaseTest{
    @Before
    @Step("Создание пользователя и вход в личный кабинет")
    public void login(){
        userDTO = createUser();
        mainPage = new LoginPage(driver).openLoginPage()
                .fillLoginForm(userDTO.getEmail(), userDTO.getPassword())
                .clickLoginButton();
    }

    @Test
    @DisplayName("Переход по клику на 'Личный кабинет'")
    public void openPersonalProfileTest() {
        profilePage = (ProfilePage) mainPage.clickAccountButton(true);
        Assert.assertTrue("Не отображается личный кабинет или имя пользователя в нём", profilePage.isUserDataDisplayed(userDTO));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор (клику по  'Конструктор')")
    public void openConstructorByConstructorButtonTest() {
        profilePage = (ProfilePage) mainPage.clickAccountButton(true);
        profilePage.clickConstructor();
        Assert.assertTrue("Не перешли в конструктор из личного кабинета", mainPage.validateOpeningMainPage());
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор (клику на логотип Stellar Burgers)")
    public void openConstructorByLogoTest() {
        profilePage = (ProfilePage) mainPage.clickAccountButton(true);
        profilePage.clickLogoStellarBurgers();
        Assert.assertTrue("Не перешли в конструктор из личного кабинета", mainPage.validateOpeningMainPage());
    }

    @Test
    @DisplayName("Проверка выхода по кнопке Выйти")
    public void LogoutTest() {
        profilePage = (ProfilePage) mainPage.clickAccountButton(true);
        loginPage = profilePage.clickLogout();
        Assert.assertTrue("Выход из аккаунта не удался или не редиректнул на страницу входа", loginPage.validateOpeningLoginPage());

    }
}
