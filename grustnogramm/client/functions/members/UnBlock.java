package grustnogramm.client.functions.members;

import grustnogramm.settings.Settings;
import okhttp3.Request;

import java.io.IOException;

public class UnBlock extends Settings {

    public static String userID;

    /**
     * function to unblock the user
     * @param UserID id of the person to unlock
     */

    public UnBlock(String UserID) {
        Block.UserID = UserID;
    }

    public static void UnBlockRequest() {
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .delete()
                .url(API + "/users/" + userID + "/block")
                .build();

        try {

            String c = client.newCall(request).execute().body().string();
            if (!"no error".equals(err_getter(c))) {
                System.out.println("Un Block error : " + err_getter(c));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


