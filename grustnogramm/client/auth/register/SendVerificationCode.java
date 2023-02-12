package grustnogramm.client.auth.register;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class SendVerificationCode extends Settings {

    static String phone_key;
    static String phone;

    /**
     * function for sending a phone confirmation code
     * @param phone your phone number
     * @param phone_key phone_key from register_request
     */

    public SendVerificationCode(String phone, String phone_key) {
        SendVerificationCode.phone_key = phone_key;
        SendVerificationCode.phone = phone;
        Settings.phone = phone;
    }

    /**
     *
     * @return token for further actions
     */
    public static String sendVerificationCodeRequest() {

        RequestBody body = new FormBody.Builder()
                .add("phone_key", phone_key)
                .add("phone", phone)
                .build();

        Request request = new Request.Builder()
                .post(body)
                .url(API + "/callme")
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

