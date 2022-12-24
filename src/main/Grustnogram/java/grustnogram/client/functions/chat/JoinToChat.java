package grustnogram.client.functions.chat;

import grustnogram.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class JoinToChat extends Settings {

    public static String chat_id;

    public JoinToChat(String chat_id){
        JoinToChat.chat_id = chat_id;
    }

    public static void joinToChatRequest(){
        RequestBody body = new FormBody.Builder()
                .add("id", chat_id)
                .build();

        Request request = new Request.Builder()
                .post(body)
                .addHeader("Access-Token", token)
                .url(api + "/circles/"+chat_id+"/enjoy")
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
