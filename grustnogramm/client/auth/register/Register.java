package grustnogramm.client.auth.register;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class Register extends Settings {

    public static String email;
    public static String password;
    public static String nickname;

    /**
     * function for creating a mail name and password for an account
     * @param email email for account
     * @param password password for account
     * @param nickname nickname for account
     */

    public Register(String nickname, String email, String password){
        Register.email = email;
        Register.password = password;
        Register.nickname = nickname;

    }

    /**
     *
     * @return phone_key for future action
     */
    public static String registerRequest(){
        RequestBody body = new FormBody.Builder()
                .add("email", email)
                .add("password", password)
                .add("password_confirm", password)
                .add("nickname", nickname)
                .build();

        Request request = new Request.Builder()
                .url(API + "/users")
                .post(body)
                .build();

        try {
            String response = client.newCall(request).execute().body().string();
            err_Login_getter(response, "Registration failed, phone_key could not be obtained. ");
            JsonElement element = JsonParser.parseString(response);
            JsonObject object = element.getAsJsonObject();
            JsonObject j = (JsonObject) object.get("data");
            return j.get("phone_key").getAsString();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
