package grustnogramm.client.functions.chat.message;

import grustnogramm.settings.Settings;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class GetChatHistory extends Settings {

    public static String id;
    public static int count;
    public static String element;

    /**
     * function for getting chat history
     * @param id of the chat to collect information
     * @param count the number of messages from which the information will be taken
     * @param element what information will be taken from the message (id, message)
     */

    public GetChatHistory(String id, int count, String element){
            GetChatHistory.id = id;
            GetChatHistory.count = count;
            GetChatHistory.element = element;
        }

    /**
     *
     * @return List of information from the chat
     */
    public static List getChatHistoryRequest(){

            Request request = new Request.Builder()
                    .addHeader("Access-Token", token)
                    .url(MSG_GRUSTNOGRAM_RU + "/circles/"+id+"/messages?id="+id+"&limit=" + count)
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
