package grustnogram.client.functions.post.comments;

import grustnogram.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;


import java.io.IOException;

public class CommentAdd extends Settings {

    static String text;
    static String post_id;
    static String reply_to;
    static String private_status;

    public CommentAdd(String text, String post_id, String reply_to, String private_status){
        CommentAdd.post_id = post_id;
        CommentAdd.text = text;
        CommentAdd.reply_to = reply_to;
        CommentAdd.private_status = private_status;
    }

    public static void addCommentRequest(){
        RequestBody body = new FormBody.Builder()
                .add("comment", text)
                .add("reply_to", reply_to)
                .add("privated", private_status)
                .build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(api + "/posts/"+post_id+"/comments")
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
