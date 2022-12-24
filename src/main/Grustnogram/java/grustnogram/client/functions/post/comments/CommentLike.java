package grustnogram.client.functions.post.comments;

import grustnogram.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class CommentLike extends Settings {
    static String comment_id;

    public CommentLike(String comment_id){
        CommentLike.comment_id = comment_id;
    }

    public static void commentLikeRequest(){
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(api + "/comments/"+comment_id+"/like")
                .post(body)
                .build();

        try {
            String c = client.newCall(request).execute().body().string();
            if(!"no error".equals(err_getter(c))){
                System.out.println("Comment Add error : " + err_getter(c));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
