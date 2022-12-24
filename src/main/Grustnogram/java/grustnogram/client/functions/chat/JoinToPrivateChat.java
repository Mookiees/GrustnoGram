package grustnogram.client.functions.chat;

import grustnogram.settings.Settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class JoinToPrivateChat extends Settings {

    public static String chat_id;
    public static String request_text;

    public JoinToPrivateChat(String chat_id, String request_text){
        JoinToPrivateChat.chat_id = chat_id;
        JoinToPrivateChat.request_text = request_text;
    }

    public static void JoinToPrivateChatRequest(){
        RequestBody body = new FormBody.Builder()
                .add("id", chat_id)
                .add("request", request_text)
                .build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(api + "/circles/"+chat_id+"/request")
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
