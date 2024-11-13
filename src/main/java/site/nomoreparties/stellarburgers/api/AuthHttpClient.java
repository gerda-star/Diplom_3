package site.nomoreparties.stellarburgers.api;


import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.api.pojo.UserDTO;

public class AuthHttpClient extends BaseHttpClient {

    private final String url;

    public AuthHttpClient(String url) {
        super();
        this.url = url + "auth/";
    }

    public ValidatableResponse login(UserDTO userDTO) {
        return doPostRequest(url+"login", userDTO);
    }

    public ValidatableResponse register(UserDTO userDTO) {
        return doPostRequest(url+"register", userDTO);
    }

    public ValidatableResponse deleteUser(String token) {
        return doDeleteRequest(url + "user", token);
    }
    public ValidatableResponse getUser(String token) {
        return doGetRequest(url + "user", token);
    }


}
