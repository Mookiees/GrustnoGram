package grustnogram.client.functions.chat.message;

import grustnogram.settings.Settings.Settings;
import okhttp3.Request;

import java.io.IOException;

public class DeleteMessage extends Settings {
    public static String message_ID;

    DeleteMessage(String message_ID){
        DeleteMessage.message_ID = message_ID;
    }

    public static void DeleteMessageRequest(){
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(mes_api + "/circles/message/" + message_ID)
                .delete()
                .build();

        try {
            String xarl = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(xarl))){
                System.out.println("Delete Message error : " + err_getter(xarl));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
