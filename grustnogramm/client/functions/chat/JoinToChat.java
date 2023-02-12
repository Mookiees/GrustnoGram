package grustnogramm.client.functions.chat;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class JoinToChat extends Settings {

    public static String chatId;

    /**
     * function for joining a chat
     * @param chatId id of the chat that the client will join
     */

    public JoinToChat(String chatId){
        JoinToChat.chatId = chatId;
    }

    public static void joinToChatRequest(){
        RequestBody body = new FormBody.Builder()
                .add("id", chatId)
                .build();

        Request request = new Request.Builder()
                .post(body)
                .addHeader("Access-Token", token)
                .url(API + "/circles/"+ chatId +"/enjoy")
                .build();

        try {
            String c = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(c))){
                System.out.println("Join to chat error : " + err_getter(c));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
