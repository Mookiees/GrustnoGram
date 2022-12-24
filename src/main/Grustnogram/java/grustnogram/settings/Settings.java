package grustnogram.settings;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import grustnogram.Profile;
import okhttp3.OkHttpClient;

import java.util.ArrayList;
import java.util.List;


public class Settings extends Profile {

    public static String api = "https://api.grustnogram.ru";
    public static String mes_api = "https://msg.grustnogram.ru";
    public static String phone;
    public static String token;
    public static String phone_key;


    public static OkHttpClient client = new OkHttpClient();

    public static String err_getter(String response) {
        JsonElement element = JsonParser.parseString(response);
        JsonObject object = element.getAsJsonObject();

        if("[null]".contains(object.get("err_msg").toString())){
            return "no error";
        }
        else {
            return object.get("err_msg").getAsString();
        }
    }

    public static void err_Login_getter(String response, String message) {

        JsonElement element = JsonParser.parseString(response);
        JsonObject object = element.getAsJsonObject();


        if (!"[null]".contains(object.get("err_msg").toString())) {
            throw new NullPointerException(message + object.get("err_msg").getAsString());
        }
    }

    public static String json_parse_element(String responce, String data){
        JsonElement element = JsonParser.parseString(responce);
        JsonObject object = element.getAsJsonObject();
        JsonObject j = (JsonObject) object.get("data");


        return j.get(data).getAsString();

    }
    public static List json_parse_list(String responce, String data) {
        List<String> result = new ArrayList<>();
        JsonElement element = JsonParser.parseString(responce);
        JsonObject object = element.getAsJsonObject();

        for (Object z : (JsonArray) object.get("data")) {
            JsonObject jsonObject = (JsonObject) z;

            result.add(jsonObject.get(data).toString().replaceAll("\"", ""));


        }

        return result;

    }
}

