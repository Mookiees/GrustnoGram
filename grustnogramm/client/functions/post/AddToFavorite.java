package grustnogramm.client.functions.post;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class AddToFavorite extends Settings {

    static String postId;

    /**
     * function for adding a post to the favorite section
     * @param postId id of the post to add to the favorite section
     */

    public AddToFavorite(String postId){
        AddToFavorite.postId = postId;
    }

    public static void addToFavoriteRequest(){
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/posts/"+ postId +"/favorite")
                .post(body)
                .build();

        try {
            String c = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(c))){
                System.out.println("Comment Delete error : " + err_getter(c));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
