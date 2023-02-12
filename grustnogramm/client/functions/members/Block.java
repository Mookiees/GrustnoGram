package grustnogramm.client.functions.members;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class Block extends Settings {

    public static String UserID;

    /**
     * function for blocking the user
     * @param UserID id of the blocked user
     */

    Block(String UserID) {
        Block.UserID = UserID;
    }

    public static void BlockRequest() {
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .post(body)
                .url(API + "/users/" + UserID + "/block")
                .build();

        try {

            String c = client.newCall(request).execute().body().string();
            if (!"no error".equals(err_getter(c))) {
                System.out.println("Block error : " + err_getter(c));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

