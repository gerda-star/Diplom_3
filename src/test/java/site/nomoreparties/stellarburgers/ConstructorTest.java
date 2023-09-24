package site.nomoreparties.stellarburgers;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.MainPage;

public class ConstructorTest extends BaseTest{

    @Before
    @Step("Открытие главной страницы")
    public void initMain() {
        mainPage = new MainPage(driver).openMainPage();
    }
    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    public void SwitchSaucesTest() {
        mainPage.switchSaucesButton();
        Assert.assertEquals("Соусы",mainPage.getSwitchIngredientType());
    }

    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void SwitchBunTest() {
        mainPage.switchSaucesButton();
        mainPage.switchBunButton();
        Assert.assertEquals("Булки",mainPage.getSwitchIngredientType());
    }
    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    public void SwitchFillingsTest() {
        mainPage.switchFillingsButton();
        Assert.assertEquals("Начинки",mainPage.getSwitchIngredientType());
    }

}
