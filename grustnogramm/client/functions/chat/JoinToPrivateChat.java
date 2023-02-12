package grustnogramm.client.functions.chat;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class JoinToPrivateChat extends Settings {

    public static String chatId;
    public static String requestText;

    /**
     * a function for requesting access to a private chat
     * @param chatId id of the chat that the client will send request
     * @param textToRequest the text of the request to log in to the chat
     */

    public JoinToPrivateChat(String chatId, String textToRequest){
        JoinToPrivateChat.chatId = chatId;
        JoinToPrivateChat.requestText = textToRequest;
    }

    public static void joinToPrivateChatRequest(){
        RequestBody body = new FormBody.Builder()
                .add("id", chatId)
                .add("request", requestText)
                .build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/circles/"+ chatId +"/request")
                .post(body)
                .build();

        try {
            String c = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(c))){
                System.out.println("Join to private chat error : " + err_getter(c));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
