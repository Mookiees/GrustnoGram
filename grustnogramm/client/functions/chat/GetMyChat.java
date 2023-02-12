package grustnogramm.client.functions.chat;

import grustnogramm.settings.Settings;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class GetMyChat extends Settings {

    public static int count;
    public static String element;

    /**
     * function for receiving client chats
     * @param count the number of messages that will be returned
     * @param element what will be returned from the function ( id , title, nickname )
     */

    public GetMyChat(int count, String element){
        GetMyChat.count = count;
        GetMyChat.element = element;
    }

    /**
     *
     * @return client chat list
     */
    public static List getMyChatRequest(){

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(MSG_GRUSTNOGRAM_RU + "/dialogs?type=0&limit=" + count)
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

