package grustnogramm.client.functions.post;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class LikePost extends Settings {

    private static String postId;

    /**
     * Function for like a post
     * @param postId post id
     */

    public LikePost(String postId){
        LikePost.postId = postId;
    }

    public static void likePostRequest(){
        RequestBody body = new FormBody
                .Builder().build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/posts/" + postId + "/like")
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
