package grustnogram.client.functions.profile.members;

import grustnogram.Client;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class Follow extends Client {

    public static String userID;

    public Follow(String userID){
        Follow.userID = userID;
    }

    public static void FollowRequest(){


        RequestBody body = new FormBody.Builder().build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(api + "/users/"+ userID + "/follow")
                .post(body)
                .build();

        try {
            String c = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(c))){
                System.out.println("Subscribe error : " + err_getter(c));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
