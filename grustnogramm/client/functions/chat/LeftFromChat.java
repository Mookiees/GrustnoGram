package grustnogramm.client.functions.chat;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class LeftFromChat extends Settings {

    public static String chatId;

    /**
     * function for exiting the chat
     * @param chatId id of the chat from which the client will exit
     */

    public LeftFromChat(String chatId){
        LeftFromChat.chatId = chatId;
    }

    public static void leftFromChatRequest(){


        RequestBody body = new FormBody.Builder().add("id", chatId).build();

        Request request = new Request.Builder()
                .post(body)
                .addHeader("Access-Token", token)
                .url(API + "/circles/"+ chatId +"/left")
                .build();

        try {
            String c = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(c))){
                System.out.println("Left from chat error : " + err_getter(c));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
