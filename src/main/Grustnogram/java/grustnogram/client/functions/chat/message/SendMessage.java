package grustnogram.client.functions.chat.message;

import grustnogram.Client;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class SendMessage extends Client {

    public static String message_text;
    public static String chatID;

    public SendMessage(String  chatID, String message_text){
        SendMessage.chatID = chatID;
        SendMessage.message_text = message_text;

    }

    public static void SendMessageRequest(){
        RequestBody body = new FormBody.Builder()
                .add("message", message_text)
                .build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(mes_api + "/circles/"+chatID+"/messages")
                .post(body)
                .build();
        try {

            String c = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(c))){
                System.out.println("Send Message error : " + err_getter(c));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
