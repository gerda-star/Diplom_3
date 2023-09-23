package site.nomoreparties.stellarburgers.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;

public class RegisterPage {
    public final String url = APP_URL + "/register" ;

    private final By nameField = By.xpath(".//label[text()='Имя']/../input");
    private final By emailField = By.xpath(".//label[text()='Email']/../input");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/../input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    private final By errorInvalidPassword = By.xpath(".//p[text() = 'Некорректный пароль']");


    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение формы регистрации")
    public RegisterPage fillAuthForm(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public LoginPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return new LoginPage(driver);
    }

    @Step("Проверка наличия ошибки для неправильного пароля")
    public boolean validateTextInvalidPassword() {
        return driver.findElement(errorInvalidPassword).isDisplayed();
    }

    @Step("Клик на кнопку 'Войти'")
    public void clickLogin() {
        driver.findElement(signInButton).click();
    }

}
