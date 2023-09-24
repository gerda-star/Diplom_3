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
    public LoginPage fillLoginForm(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public MainPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

    @Step("Нажатие на ссылку Зарегистрироваться")
    public RegisterPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new RegisterPage(driver);
    }

    @Step("Нажатие на ссылку Восстановить пароль")
    public ForgotPasswordPage clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
        return new ForgotPasswordPage(driver);
    }

    @Step("Открытие страницы входа в аккаут")
    public LoginPage openLoginPage() {
        driver.get(url);
        return this;
    }

    @Step("Проверка перехода на страницу 'Вход")
    public boolean validateOpeningLoginPage() {
        return driver.findElement(enterHeading).isDisplayed();
    }
}
