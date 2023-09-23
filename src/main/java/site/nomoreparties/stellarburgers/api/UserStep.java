package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;


import site.nomoreparties.stellarburgers.api.pojo.UserDTO;
import static site.nomoreparties.stellarburgers.config.AppConfig.API_URL;

public class UserStep {

    static final AuthHttpClient authHttpClient = new AuthHttpClient(API_URL);
    static ValidatableResponse response;
    public UserDTO userDTO;


    @Step("Формирование данных для создания пользователя")
    public static UserDTO generateUser() {
        String email = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
        String password = RandomStringUtils.randomAlphanumeric(6);
        String name = RandomStringUtils.randomAlphanumeric(4);
        return new UserDTO(email, password, name);
    }
    @Step("Mеняем пароль на невалидный: менее шести симовоов")
    public static void setInvalidPassword(UserDTO userDTO) {
        userDTO.setPassword( RandomStringUtils.randomAlphanumeric(4));
    }

    @Step("Создание случайного пользователя: post запрос к ендпоинту auth/register")
    public static String createUser() {
        response = authHttpClient.register(generateUser());
        return response.extract().path("accessToken").toString();
    }
    @Step("Получение токена: post запрос к ендпоинту auth/register")
    public static String getToken(UserDTO userDTO) {
        response = authHttpClient.login(userDTO);
        try {
            return response.extract().path("accessToken").toString();
        } catch (Exception e) {
            return null;
        }

    }


    @Step("Удаление созданного пользователя: delete запрос к ендпоинту auth/user")
    public static void deleteCreatedUser(String token) {
        authHttpClient.deleteUser(token);
    }


}
