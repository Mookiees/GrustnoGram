package grustnogram.client.functions.members;

import grustnogram.settings.Settings;
import okhttp3.Request;

import java.io.IOException;

public class UnBlock extends Settings {

    public static String UserID;

    public UnBlock(String UserID) {
        Block.UserID = UserID;
    }

    public static void UnBlockRequest() {
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .delete()
                .url(api + "/users/" + UserID + "/block")
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


