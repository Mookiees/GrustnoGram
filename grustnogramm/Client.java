package grustnogramm;

import grustnogramm.client.auth.login.GetProfileInfo;
import grustnogramm.client.auth.register.PhoneActive;
import grustnogramm.client.auth.register.Register;
import grustnogramm.client.auth.register.SendVerificationCode;
import grustnogramm.client.auth.login.Login;
import grustnogramm.client.functions.chat.GetMyChat;
import grustnogramm.client.functions.chat.GetPopularChat;
import grustnogramm.client.functions.chat.LeftFromChat;
import grustnogramm.client.functions.chat.JoinToChat;
import grustnogramm.client.functions.chat.LeftFromDialog;
import grustnogramm.client.functions.chat.JoinToPrivateChat;
import grustnogramm.client.functions.chat.message.GetChatHistory;
import grustnogramm.client.functions.chat.message.Message;
import grustnogramm.client.functions.post.AddToFavorite;
import grustnogramm.client.functions.post.LikePost;
import grustnogramm.client.functions.post.SecretPost;
import grustnogramm.client.functions.post.comments.CommentAdd;
import grustnogramm.client.functions.post.comments.CommentDelete;
import grustnogramm.client.functions.post.comments.CommentLike;
import grustnogramm.client.functions.members.Block;
import grustnogramm.client.functions.members.UnBlock;
import grustnogramm.client.functions.members.Follow;
import grustnogramm.client.functions.members.GetHands;
import grustnogramm.client.functions.members.UnFollow;
import grustnogramm.settings.Settings;

import java.util.List;

/**
 * Client for Grustnogramm
 * @version 0.2
 * @author Mookie
 * @date 24.12.22
 */
public class Client extends Settings {

    public static void loginRequest(Login login) {
        Login.loginRequest();
    }

    public static void phoneActiveRequest(PhoneActive phonceActive) {
        PhoneActive.phoneActiveRequest();
    }


    public static String registerRequest(Register register) {
        return Register.registerRequest();
    }


    public static String sendVerificationCodeRequest(SendVerificationCode sendVerificationCode) {
        return SendVerificationCode.sendVerificationCodeRequest();
    }

    public static void getProfileInfo(GetProfileInfo getProfileInfo) {
        GetProfileInfo.getProfileInfoRequest();
    }


    public static List getMyChatRequest(GetMyChat getMyChat) {
        return GetMyChat.getMyChatRequest();
    }

    public static List getPopularChatRequest(GetPopularChat getPopularChat) {
        return GetPopularChat.getPopularChatRequest();
    }

    public static void joinChatRequest(JoinToChat joinChat) {
        JoinToChat.joinToChatRequest();
    }

    public static void joinToPrivateChatRequest(JoinToPrivateChat joinPrivateChat) {
        JoinToPrivateChat.joinToPrivateChatRequest();
    }

    public static void leftFromChatRequest(LeftFromChat leftFromChat) {
        LeftFromChat.leftFromChatRequest();
    }


    public static void leftFromDialogRequest(LeftFromDialog leftFromDialog) {
        LeftFromDialog.leftFromDialogRequest();
    }


    public static List getChatHistoryRequest(GetChatHistory getChatHistoryRequest) {
        return GetChatHistory.getChatHistoryRequest();
    }

    public static void sendMessageRequest(Message.SendMessage sendmessage){
        sendmessage.sendMessageRequest();}

    public static void deleteMessageRequest(Message.DeleteMessage deleteMessage){
        Message.DeleteMessage.deleteMessageRequest();
    }

    public static void addToFavouriteRequest(AddToFavorite addToFavorite) {
        AddToFavorite.addToFavoriteRequest();
    }

    public static void likePostRequest(LikePost likePost) {
        LikePost.likePostRequest();
    }

    public static void secretPostRequest(SecretPost secretPost) {
        SecretPost.postSecretRequest();
    }

    public static void commentAddRequest(CommentAdd addComment) {
        CommentAdd.addCommentRequest();
    }

    public static void commentDeleteRequest(CommentDelete commentDelete) {
        CommentDelete.commentDeleteRequest();
    }

    public static void commentLikeRequest(CommentLike commentLike) {
        CommentLike.commentLikeRequest();
    }

    public static void blockRequest(Block block) {
        Block.BlockRequest();
    }

    public static void followRequest(Follow follow) {
        Follow.FollowRequest();
    }

    public static List getHandsRequest(GetHands getHands) {
        return GetHands.GetHandsRequest();
    }

    public static void unBlockRequest(UnBlock unBlock) {
        UnBlock.UnBlockRequest();
    }

    public static void unFollow(UnFollow unFollow) {
        UnFollow.UnFollowRequest();
    }
}
