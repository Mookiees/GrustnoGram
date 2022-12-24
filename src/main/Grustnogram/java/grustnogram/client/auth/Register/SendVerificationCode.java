package grustnogram.client.auth.Register;

import grustnogram.settings.Settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class SendVerificationCode extends Settings {

    static String phone_key;
    static String phone;

    public SendVerificationCode(String phone, String phone_key) {
        SendVerificationCode.phone_key = phone_key;
        SendVerificationCode.phone = phone;
        Settings.phone = phone;
    }


    public static String SendVerificationCodeRequest() {

        RequestBody body = new FormBody.Builder()
                .add("phone_key", phone_key)
                .add("phone", phone)
                .build();

        Request request = new Request.Builder()
                .post(body)
                .url(api + "/callme")
                .build();


        try {
            String response = client.newCall(request).execute().body().string();

            err_Login_getter(response, "Registration failed, code could not be send. ");

            return response;
            } catch(IOException e){
                throw new RuntimeException(e);
            }


        }
    }

