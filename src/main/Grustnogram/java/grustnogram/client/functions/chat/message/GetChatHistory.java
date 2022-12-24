package grustnogram.client.functions.chat.message;

import grustnogram.settings.Settings.Settings;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class GetChatHistory extends Settings {
    public static String id;
    public static int count;
    public static String element;

    public GetChatHistory(String id, int count, String element){
            GetChatHistory.id = id;
            GetChatHistory.count = count;
            GetChatHistory.element = element;
        }
        public static List GetChatHistoryRequest(){

            Request request = new Request.Builder()
                    .addHeader("Access-Token", token)
                    .url(mes_api + "/circles/"+id+"/messages?id="+id+"&limit=" + count)
                    .get()
                    .build();

            try {
                String xarl = client.newCall(request).execute().body().string();

                err_Login_getter(xarl, "Get Chat History error : " + err_getter(xarl));


                return json_parse_list(xarl, element);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
