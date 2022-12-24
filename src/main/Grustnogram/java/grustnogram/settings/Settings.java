package grustnogram.settings;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import grustnogram.Profile;
import okhttp3.OkHttpClient;

import java.util.ArrayList;
import java.util.List;


/**
 * Settings
 */
public class Settings extends Profile {

    public static String api = "https://api.grustnogram.ru";
    public static String mes_api = "https://msg.grustnogram.ru";
    public static String phone;
    public static String token;
    public static String phone_key;


    public static OkHttpClient client = new OkHttpClient();

    /**
     * checking for small errors in client requests
     * @param response - the response of the request from which we will get
     * @return status are there any errors or are there none
     */
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


    /**
     * checking the client for login or account registration errors
     * @param response - the response of the request from which we will get
     * @param message - what message will appear to the user in case of an error
     * @return error
     * @throws if there is no data provided to us by response, the NullPointerExceptions error is thrown
     */
    public static void err_Login_getter(String response, String message) {

        JsonElement element = JsonParser.parseString(response);
        JsonObject object = element.getAsJsonObject();


        if (!"[null]".contains(object.get("err_msg").toString())) {

            throw new NullPointerException(message + object.get("err_msg").getAsString());
        }
    }

    /**
     * function for getting one element from a single response
     * @param responce - the response of the request from which we will get
     * @param data - what data do we need to take
     * @return data
     */
    public static String json_parse_element(String responce, String data){
        JsonElement element = JsonParser.parseString(responce);
        JsonObject object = element.getAsJsonObject();
        JsonObject j = (JsonObject) object.get("data");


        return j.get(data).getAsString();

    }

    /**
     * function for parsing an array of data from the response
     * @param responce - the response of the request from which we will get an array
     * @param data - what data do we need to take from the array
     * @return array with data
     */
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

