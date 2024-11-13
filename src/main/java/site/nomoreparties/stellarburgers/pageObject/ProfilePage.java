package site.nomoreparties.stellarburgers.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.pojo.UserDTO;

public class ProfilePage {

    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");


    WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка видимости имени пользователя в поле 'имя'")
    public boolean isUserDataDisplayed(UserDTO user) {
        return driver.findElement(buildBy(user.getName())).isDisplayed();

    }
    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickLogoStellarBurgers() {
        driver.findElement(logoButton).click();
    }

    @Step("Клик на 'Выйти'")
    public LoginPage clickLogout() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

    public By buildBy(String field) {
        String xpath = ".//input[@value=\"" +field+ "\"]";
        return By.xpath(xpath);
    }



}
