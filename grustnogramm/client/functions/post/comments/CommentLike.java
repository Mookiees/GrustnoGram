package grustnogramm.client.functions.post.comments;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public class CommentLike extends Settings {

    static String commentId;

    /**
     * a function for liking a comment
     * @param commentId the comment that the client likes
     */

    public CommentLike(String commentId){
        CommentLike.commentId = commentId;
    }

    public static void commentLikeRequest(){
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/comments/"+ commentId +"/like")
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
