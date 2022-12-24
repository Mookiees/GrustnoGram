package grustnogram.client.auth.login;

import grustnogram.settings.Settings;
import okhttp3.Request;

import java.io.IOException;

public class GetProfileInfo extends Settings {
    public static String nicknames;

    public GetProfileInfo(String nickname){
        GetProfileInfo.nicknames = nickname;
    }

    public static void getProfileInfoRequest(){
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(api + "/users/" + nicknames)
                .get()
                .build();
        try {
            String xarl = client.newCall(request).execute().body().string();
            err_Login_getter(xarl, "Profile Get failed. ");

            nickname = json_parse_element(xarl, "nickname");
            email = json_parse_element(xarl, "email");
            name = json_parse_element(xarl, "name");
            about = json_parse_element(xarl, "about");
            hand_text = json_parse_element(xarl, "hand_text");
            id = json_parse_element(xarl, "id");
            follow = json_parse_element(xarl, "follow");
            followers = json_parse_element(xarl, "followers");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
