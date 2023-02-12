package grustnogramm.client.functions.chat;

import grustnogramm.settings.Settings;
import okhttp3.Request;

import java.io.IOException;

public class LeftFromDialog extends Settings {

    public static String id;

    /**
     * a function for exiting a client from his personal chats
     * @param userId id of the person with whom the client will delete the chat
     */

    public LeftFromDialog(String userId){
        LeftFromDialog.id = userId;
    }

    public static void leftFromDialogRequest(){
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/circles/" + id)
                .delete()
                .build();

        try {
            String xarl = client.newCall(request).execute().body().string();

            if (!"no error".equals(err_getter(xarl))) {
                System.out.println("Left From Dialog error : " + err_getter(xarl));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
