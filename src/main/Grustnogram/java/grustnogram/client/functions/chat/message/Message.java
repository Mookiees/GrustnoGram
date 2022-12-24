package grustnogram.client.functions.chat.message;


import grustnogram.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class Message extends Settings {

    public static class SendMessage {
        public String message_text;
        public String chatID;

        public SendMessage(String message_text, String chatID){
            this.chatID = chatID;
            this.message_text = message_text;
        }

        public void sendMessageRequest() {
            RequestBody body = new FormBody.Builder()
                    .add("message", this.message_text)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("Access-Token", token)
                    .url(mes_api + "/circles/" + chatID + "/messages")
                    .post(body)
                    .build();
            try {

                String c = client.newCall(request).execute().body().string();
                if (!"no error".equals(err_getter(c))) {
                    System.out.println("Send Message error : " + err_getter(c));
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }
    public static class DeleteMessage {
        public static String message_ID;

        public DeleteMessage(String message_ID){
            DeleteMessage.message_ID = message_ID;
        }

        public static void deleteMessageRequest(){
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

}
