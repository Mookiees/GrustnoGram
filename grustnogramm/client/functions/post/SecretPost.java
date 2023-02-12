package grustnogramm.client.functions.post;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class SecretPost extends Settings {

    public static String text;

    public static String commentOff;

    /**
     * function for creating a secret post
     * @param text the text of the post. minimum 32 words
     * @param commentOff Permission to post comments by other users ( 1 - allowed, 0 - prohibited )
     */

    public SecretPost(String text, String commentOff){
        SecretPost.commentOff = commentOff;
        SecretPost.text = text;
    }

    public static void postSecretRequest(){
        RequestBody body = new FormBody.Builder()
                .add("secret", text)
                .add("comment_of", commentOff)
                .build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/secrets")
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
