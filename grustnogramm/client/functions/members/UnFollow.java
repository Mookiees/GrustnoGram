package grustnogramm.client.functions.members;

import grustnogramm.settings.Settings;
import okhttp3.Request;

import java.io.IOException;

public class UnFollow extends Settings {

    public static String userID;

    /**
     * function for unsubscribing from a person
     * @param userID id of the person you want to unsubscribe from
     */

    public UnFollow(String userID){
        UnFollow.userID = userID;
    }

    public static void UnFollowRequest(){

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/users/"+ userID + "/follow")
                .delete()
                .build();

        try {
            String c =  client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(c))){
                System.out.println("UnSubscribe error : " + err_getter(c));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
