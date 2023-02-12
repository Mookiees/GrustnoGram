package grustnogramm.client.auth.login;

import grustnogramm.settings.Settings;
import grustnogramm.Profile;
import okhttp3.Request;

import java.io.IOException;

public class GetProfileInfo extends Settings {


    public static String nicknames;

    /**
     * function for getting information about the client
     * @param nickname your nickname
     * @see Profile
     */

    public GetProfileInfo(String nickname){
        GetProfileInfo.nicknames = nickname;
    }

    public static void getProfileInfoRequest(){
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/users/" + nicknames)
                .get()
                .build();
        try {
            String xarl = client.newCall(request).execute().body().string();
            err_Login_getter(xarl, "Profile Get failed. ");

            Profile.nickname = json_parse_element(xarl, "nickname");
            Profile.email = json_parse_element(xarl, "email");
            Profile.name = json_parse_element(xarl, "name");
            Profile.about = json_parse_element(xarl, "about");
            Profile.handText = json_parse_element(xarl, "handText");
            Profile.id = json_parse_element(xarl, "id");
            Profile.follow = json_parse_element(xarl, "follow");
            Profile.followers = json_parse_element(xarl, "followers");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
