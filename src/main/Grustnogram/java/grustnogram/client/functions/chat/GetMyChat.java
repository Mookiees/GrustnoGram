package grustnogram.client.functions.chat;

import grustnogram.settings.Settings;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class GetMyChat extends Settings {

    public static int count;
    public static String element;

    public GetMyChat(int count, String element){
        GetMyChat.count = count;
        GetMyChat.element = element;
    }
    public static List getMyChatRequest(){

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(mes_api + "/dialogs?type=0&limit=" + count)
                .get()
                .build();

        try {
            String xarl = client.newCall(request).execute().body().string();

            err_Login_getter(xarl, "Get My Chat chat error : " + err_getter(xarl));


            return json_parse_list(xarl, element);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

