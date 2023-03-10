package grustnogramm.client.auth.login;

import com.google.gson.*;
import grustnogramm.Client;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class Login extends Client {

    public static String Email;
    public static String Password;

    /**
     * Login into account , to get token
     * @param email Account email
     * @param password Account password
     * @see Client
     */

    public Login(String email, String password){
        Email = email;
        Password = password;
    }
    
    public static void loginRequest() {


        RequestBody body = new FormBody.Builder()
                .add("email", Email)
                .add("password", Password)
                .build();

        Request request = new Request.Builder()
                .post(body)
                .url(API + "/sessions")
                .build();

        try {

            String response = client.newCall(request).execute().body().string();

            err_Login_getter(response, "Login failed, token could not be obtained. ");
            JsonElement element = JsonParser.parseString(response);
            JsonObject object = element.getAsJsonObject();
            JsonObject j = (JsonObject) object.get("data");
            token = j.get("access_token").getAsString();



        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
