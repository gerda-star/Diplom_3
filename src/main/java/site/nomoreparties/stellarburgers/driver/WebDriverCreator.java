package site.nomoreparties.stellarburgers.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverCreator {

    public static final String YANDEX_BROWSER_PATH = "C:/Users/EKATERINA/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";
    public static final String YANDEX_DRIVER = "src/main/java/site/nomoreparties/stellarburgers/driver/chromedriver-yandex.exe";

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {

            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(YANDEX_BROWSER_PATH);
        return new ChromeDriver(options);
    }
}