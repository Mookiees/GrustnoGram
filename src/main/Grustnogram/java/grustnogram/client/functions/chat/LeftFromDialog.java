package grustnogram.client.functions.chat;

import grustnogram.settings.Settings;
import okhttp3.Request;

import java.io.IOException;

public class LeftFromDialog extends Settings {
    public static String id;

    public LeftFromDialog(String id){
        LeftFromDialog.id = id;
    }

    public static void leftFromDialogRequest(){
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(api + "/circles/" + id)
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
