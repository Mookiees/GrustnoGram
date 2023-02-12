package grustnogramm.client.functions.members;

import grustnogramm.Client;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class Follow extends Client {

    public static String userID;

    /**
     * a function for subscribing to a person
     * @param userID id of the person the client will subscribe to
     */

    public Follow(String userID){
        Follow.userID = userID;
    }

    public static void FollowRequest(){


        RequestBody body = new FormBody.Builder().build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/users/"+ userID + "/follow")
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
