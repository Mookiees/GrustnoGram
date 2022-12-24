package grustnogram;

import grustnogram.client.auth.login.GetProfileInfo;
import grustnogram.client.auth.register.PhoneActive;
import grustnogram.client.auth.register.Register;
import grustnogram.client.auth.register.SendVerificationCode;
import grustnogram.client.auth.login.Login;
import grustnogram.client.functions.chat.GetMyChat;
import grustnogram.client.functions.chat.GetPopularChat;
import grustnogram.client.functions.chat.LeftFromChat;
import grustnogram.client.functions.chat.JoinToChat;
import grustnogram.client.functions.chat.LeftFromDialog;
import grustnogram.client.functions.chat.JoinToPrivateChat;
import grustnogram.client.functions.chat.message.GetChatHistory;
import grustnogram.client.functions.chat.message.Message;
import grustnogram.client.functions.post.AddToFavorite;
import grustnogram.client.functions.post.LikePost;
import grustnogram.client.functions.post.SecretPost;
import grustnogram.client.functions.post.comments.CommentAdd;
import grustnogram.client.functions.post.comments.CommentDelete;
import grustnogram.client.functions.post.comments.CommentLike;
import grustnogram.client.functions.members.Block;
import grustnogram.client.functions.members.UnBlock;
import grustnogram.client.functions.members.Follow;
import grustnogram.client.functions.members.GetHands;
import grustnogram.client.functions.members.UnFollow;
import grustnogram.settings.Settings;

import java.util.List;

// -----------------------------------------------
// Created by Mookie
// Date 24.12.22
// API for Grustnogram
// if you have any question write me on telegram --> @Mookiees, or our chat --> @xarlchat
// -----------------------------------------------


public class Client extends Settings {

    // Login Method's

    // -----------------------------------------------
    // LoginRequest
    // params -> Email or Nickname | Password
    // return -> a token for further actions
    // -----------------------------------------------
    public static void loginRequest(Login login) {
        Login.loginRequest();
    }

    // -----------------------------------------------
    // PhoneActiveRequest
    // params -> code from sms
    // return -> a token for further actions
    // -----------------------------------------------
    public static void phoneActiveRequest(PhoneActive phonceActive) {
        PhoneActive.phoneActiveRequest();
    }

    // -----------------------------------------------
    // RegisterRequest
    // params -> Email | Password | Nickname for account
    // return -> phone key for SendVerificationCode
    // -----------------------------------------------
    public static String registerRequest(Register register) {
        return Register.registerRequest();
    }

    // -----------------------------------------------
    // SendVerificationCodeRequest
    // params -> PhoneKey from RegisterRequest | Your PhoneNumber
    // return -> nothing
    // -----------------------------------------------
    public static String sendVerificationCodeRequest(SendVerificationCode sendVerificationCode) {
        return SendVerificationCode.sendVerificationCodeRequest();
    }

    // -----------------------------------------------
    // getMyProfileInfo
    // params -> Nickname
    // return -> All info about your account
    // -----------------------------------------------
    public static void getProfileInfo(GetProfileInfo getProfileInfo) {
        GetProfileInfo.getProfileInfoRequest();
    }

    // Chat Method's

    // Chat elements -> id | title | posts | nickname | privacy | can_write  and ....

    // -----------------------------------------------
    // GetMyChatRequest
    // params -> count ( limit ) | element ( what information do you want to take )
    // return -> List
    // -----------------------------------------------
    public static List getMyChatRequest(GetMyChat getMyChat) {
        return GetMyChat.getMyChatRequest();
    }

    // -----------------------------------------------
    // GetPopularChatRequest
    // params -> count ( limit ) | element ( what information do you want to take )
    // return -> List
    // -----------------------------------------------
    public static List getPopularChatRequest(GetPopularChat getPopularChat) {
        return GetPopularChat.getPopularChatRequest();
    }

    // -----------------------------------------------
    // JoinToChatRequest
    // params -> chat_id
    // return -> nothing
    // -----------------------------------------------
    public static void joinChatRequest(JoinToChat joinChat) {
        JoinToChat.joinToChatRequest();
    }

    // -----------------------------------------------
    // JoinToPrivateChatRequest
    // params -> chat_id | text_to_request
    // return -> nothing
    // -----------------------------------------------
    public static void joinToPrivateChatRequest(JoinToPrivateChat joinPrivateChat) {
        JoinToPrivateChat.joinToPrivateChatRequest();
    }

    // -----------------------------------------------
    // LeftFromChatRequest
    // params -> chat_id
    // return -> nothing
    // -----------------------------------------------
    public static void leftFromChatRequest(LeftFromChat leftFromChat) {
        LeftFromChat.leftFromChatRequest();
    }

    // -----------------------------------------------
    // LeftFromDialogRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void leftFromDialogRequest(LeftFromDialog leftFromDialog) {
        LeftFromDialog.leftFromDialogRequest();
    }

    // Message Method's

    // -----------------------------------------------
    // GetChatHistoryRequest
    // params -> id ( chat_id ) | count ( limit ) | element
    // return -> List
    // -----------------------------------------------
    public static List getChatHistoryRequest(GetChatHistory getChatHistoryRequest) {
        return GetChatHistory.getChatHistoryRequest();
    }

    // -----------------------------------------------
    // SendMessageRequest
    // params -> chat_id | message_text
    // return -> nothing
    // -----------------------------------------------
    public static void sendMessageRequest(Message.SendMessage sendmessage){
        sendmessage.sendMessageRequest();}


    // -----------------------------------------------
    // DeleteMessageRequest
    // params -> message_id
    // return -> nothing
    // -----------------------------------------------
    public static void deleteMessageRequest(Message.DeleteMessage deleteMessage){
        Message.DeleteMessage.deleteMessageRequest();
    }
    // Post Method's

    // -----------------------------------------------
    // AddToFavouriteRequest
    // params -> post_id
    // return -> nothing
    // -----------------------------------------------
    public static void addToFavouriteRequest(AddToFavorite addToFavorite) {
        AddToFavorite.addToFavoriteRequest();
    }

    // -----------------------------------------------
    // LikePostRequest
    // params -> post_id
    // return -> nothing
    // -----------------------------------------------
    public static void likePostRequest(LikePost likePost) {
        LikePost.likePostRequest();
    }

    // -----------------------------------------------
    // SecretPostRequest
    // params -> text ( min 32 word's) | comment_of ( 1 true, 0 false )
    // return -> nothing
    // -----------------------------------------------
    public static void secretPostRequest(SecretPost secretPost) {
        SecretPost.postSecretRequest();
    }

    // Comments Method's

    // -----------------------------------------------
    // CommentAddRequest
    // params -> text | post_id | reply_to | private_status ( 1 true, 0 false )
    // return -> nothing
    // -----------------------------------------------
    public static void commentAddRequest(CommentAdd addComment) {
        CommentAdd.addCommentRequest();
    }

    // -----------------------------------------------
    // CommentDeleteRequest
    // params -> comment_id
    // return -> nothing
    // -----------------------------------------------
    public static void commentDeleteRequest(CommentDelete commentDelete) {
        CommentDelete.commentDeleteRequest();
    }

    // -----------------------------------------------
    // CommentLikeRequest
    // params -> comment_id
    // return -> nothing
    // -----------------------------------------------
    public static void commentLikeRequest(CommentLike commentLike) {
        CommentLike.commentLikeRequest();
    }

    // Members Method's

    // -----------------------------------------------
    // BlockRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void blockRequest(Block block) {
        Block.BlockRequest();
    }

    // -----------------------------------------------
    // FollowRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void followRequest(Follow follow) {
        Follow.FollowRequest();
    }

    // -----------------------------------------------
    // GetHandsRequest
    // params -> count ( limit ) | element
    // return -> List
    // -----------------------------------------------
    public static List getHandsRequest(GetHands getHands) {
        return GetHands.GetHandsRequest();
    }

    // -----------------------------------------------
    // UnBlockRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void unBlockRequest(UnBlock unBlock) {
        UnBlock.UnBlockRequest();
    }

    // -----------------------------------------------
    // UnFollowRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void unFollow(UnFollow unFollow) {
        UnFollow.UnFollowRequest();
    }
}
