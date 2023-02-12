package grustnogramm.client.functions.chat.message;


import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class Message extends Settings {

    public static class SendMessage {

        public String messageText;
        public String chatID;

        /**
         * function for sending a message to a chat
         * @param chatID id of the chat or the person who will receive the message
         * @param messageText the text of the message
         */

        public SendMessage(String messageText, String chatID){
            this.chatID = chatID;
            this.messageText = messageText;
        }

        public void sendMessageRequest() {
            RequestBody body = new FormBody.Builder()
                    .add("message", this.messageText)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("Access-Token", token)
                    .url(MSG_GRUSTNOGRAM_RU + "/circles/" + chatID + "/messages")
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

        /**
         * function for deleting a message
         * @param messageID id of the message that will be deleted
         */

        public DeleteMessage(String messageID){
            DeleteMessage.message_ID = messageID;
        }

        public static void deleteMessageRequest(){
            Request request = new Request.Builder()
                    .addHeader("Access-Token", token)
                    .url(MSG_GRUSTNOGRAM_RU + "/circles/message/" + message_ID)
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
