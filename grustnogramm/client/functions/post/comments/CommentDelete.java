package grustnogramm.client.functions.post.comments;

import grustnogramm.settings.Settings;
import okhttp3.Request;

import java.io.IOException;

    public class CommentDelete extends Settings {

        static String commentId;

        /**
         *  function for deleting a comment
         * @param commentId id of the comment being deleted
         */

        public CommentDelete(String commentId){
            CommentDelete.commentId = commentId;
        }

        public static void commentDeleteRequest(){
            Request request = new Request.Builder()
                    .addHeader("Access-Token", token)
                    .url(API + "/posts/comments/" + commentId)
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
