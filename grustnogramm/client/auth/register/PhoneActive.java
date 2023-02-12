package grustnogramm.client.auth.register;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import grustnogramm.settings.Settings;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class PhoneActive extends Settings {

    public static String code;

    /**
     * function for receiving a code from sms
     * @param code code from sms
     */

    public PhoneActive(String code){
        PhoneActive.code = code;
    }

    public static void phoneActiveRequest(){

        RequestBody body = new FormBody.Builder()
                .add("phone", phone)
                .add("code", code)
                .build();

        Request request = new Request.Builder()
                .url(API + "/phoneactivate")
                .post(body)
                .build();


        try {

            String response = client.newCall(request).execute().body().string();
            err_Login_getter(response, "Registration failed, token could not be obtained. ");
            JsonElement element = JsonParser.parseString(response);
            JsonObject object = element.getAsJsonObject();
            JsonObject j = (JsonObject) object.get("data");
            token = j.get("access_token").getAsString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
