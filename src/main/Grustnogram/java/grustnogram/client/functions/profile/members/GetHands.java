package grustnogram.client.functions.profile.members;

import grustnogram.settings.Settings.Settings;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class GetHands extends Settings {

    public static int count;
    public static String element;

    public GetHands(int count, String element){
        GetHands.count = count;
        GetHands.element = element;
    }
    public static List GetHandsRequest(){
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(api + "/hands?limit=" + count)
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