package grustnogram.client.auth.Register;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import grustnogram.settings.Settings.Settings;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class PhoneActive extends Settings {

    public static String code;

    public PhoneActive(String code){
        PhoneActive.code = code;
    }

    public static void PhoneActiveRequest(){

        RequestBody body = new FormBody.Builder()
                .add("phone", phone)
                .add("code", code)
                .build();

        Request request = new Request.Builder()
                .url(api + "/phoneactivate")
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
