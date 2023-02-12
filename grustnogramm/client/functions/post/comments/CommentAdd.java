package grustnogramm.client.functions.post.comments;

import grustnogramm.settings.Settings;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;


import java.io.IOException;

public class CommentAdd extends Settings {


    static String text;
    static String postId;
    static String replyTo;
    static String privateStatus;

    /**
     *  function for publishing a comment
     * @param text comment text
     * @param postId id of the post on which the client will leave a comment
     * @param replyTo id of the message to which the user will respond
     * @param privateStatus message status ( 1 - visible to everyone, 0 - only to the author of the post )
     */

    public CommentAdd(String text, String postId, String replyTo, String privateStatus){
        CommentAdd.postId = postId;
        CommentAdd.text = text;
        CommentAdd.replyTo = replyTo;
        CommentAdd.privateStatus = privateStatus;
    }

    public static void addCommentRequest(){
        RequestBody body = new FormBody.Builder()
                .add("comment", text)
                .add("replyTo", replyTo)
                .add("privated", privateStatus)
                .build();

        Request request = new Request.Builder()
                .addHeader("Access-Token", token)
                .url(API + "/posts/"+ postId +"/comments")
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
