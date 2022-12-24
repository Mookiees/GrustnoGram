package grustnogram.client.functions.post;

import grustnogram.settings.Settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class SecretPost extends Settings {

    public static String text;

    public static String comment_off;

    public SecretPost(String text, String comment_off){
        SecretPost.comment_off = comment_off;
        SecretPost.text = text;
    }

    public static void PostSecretRequest(){
        RequestBody body = new FormBody.Builder()
                .add("secret", text)
                .add("comment_of", comment_off)
                .build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(api + "/secrets")
                .post(body)
                .build();

        try {
            String xarl = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(xarl))){
                System.out.println("Secret post error : " + err_getter(xarl));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
