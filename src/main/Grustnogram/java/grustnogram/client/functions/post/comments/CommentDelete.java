package grustnogram.client.functions.post.comments;

import grustnogram.settings.Settings;
import okhttp3.Request;

import java.io.IOException;

    public class CommentDelete extends Settings {
        static String comment_id;

        public CommentDelete(String comment_id){
            CommentDelete.comment_id = comment_id;
        }

        public static void commentDeleteRequest(){
            Request request = new Request.Builder()
                    .addHeader("Access-Token", token)
                    .url(api + "/posts/comments/" + comment_id)
                    .delete()
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
