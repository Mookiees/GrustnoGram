package grustnogramm.client.functions.chat;

import grustnogramm.settings.Settings;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class GetPopularChat extends Settings {

    public static int count;
    public static String element;

    /**
     * function for getting popular chats
     * @param count the number of messages that will be returned
     * @param element what will be returned from the function ( id , title, nickname )
     */

    public GetPopularChat(int count, String element){
        GetPopularChat.count = count;
        GetPopularChat.element = element;
    }

    /**
     *
     * @return Popular chat list
     */

    public static List getPopularChatRequest(){
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/circles?type=2&limit=" + count)
                .get()
                .build();

        try {
            String xarl = client.newCall(request).execute().body().string();
            err_Login_getter(xarl, "Get popular chat error : " + err_getter(xarl));
            return json_parse_list(xarl, element);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
