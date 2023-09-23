package site.nomoreparties.stellarburgers.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;

public class LoginPage {

    public final String url = APP_URL + "/login" ;

    private final By enterHeading = By.xpath("//h2[text()='Вход']");
    private final By emailInput = By.xpath("//input[@name='name']");
    private final By passwordInput = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registrationButton = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Зарегистрироваться')]");
    private final By forgotPasswordButton = By.xpath(".//a[(@class='Auth_link__1fOlj' and text()='Восстановить пароль')]");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение формы авторизации")
    public void loginForm(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    @Step("Нажатие на ссылку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие на ссылку Восстановить пароль")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Проверка перехода на страницу авторизации")
    public boolean validateOpening() {
        return driver.findElement(enterHeading).isDisplayed();
    }
}
