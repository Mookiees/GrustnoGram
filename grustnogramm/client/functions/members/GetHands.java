package grustnogramm.client.functions.members;

import grustnogramm.settings.Settings;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class GetHands extends Settings {

    public static int count;
    public static String element;

    /**
     * a function for getting people who are ready to chat
     * @param count number of people to collect
     * @param element what information should be taken from the user (nickname, id)
     */

    public GetHands(int count, String element){
        GetHands.count = count;
        GetHands.element = element;
    }

    /**
     * @return a list with the data of users who are ready to communicate
     */
    public static List GetHandsRequest(){
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/hands?limit=" + count)
                .get()
                .build();

        try {
            String xarl = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(xarl))){
                System.out.println("Hands getter error : " + err_getter(xarl));
            }


            return json_parse_list(xarl, element);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}