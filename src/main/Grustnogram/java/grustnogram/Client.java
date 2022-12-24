package grustnogram;

import grustnogram.client.auth.Register.PhoneActive;
import grustnogram.client.auth.Register.Register;
import grustnogram.client.auth.Register.SendVerificationCode;
import grustnogram.client.auth.login.GetMyProfileInfo;
import grustnogram.client.auth.login.Login;
import grustnogram.client.functions.chat.GetMyChat;
import grustnogram.client.functions.chat.GetPopularChat;
import grustnogram.client.functions.chat.LeftFromChat;
import grustnogram.client.functions.chat.JoinToChat;
import grustnogram.client.functions.chat.LeftFromDialog;
import grustnogram.client.functions.chat.JoinToPrivateChat;
import grustnogram.client.functions.chat.message.DeleteMessage;
import grustnogram.client.functions.chat.message.GetChatHistory;
import grustnogram.client.functions.chat.message.SendMessage;
import grustnogram.client.functions.post.AddToFavorite;
import grustnogram.client.functions.post.LikePost;
import grustnogram.client.functions.post.SecretPost;
import grustnogram.client.functions.post.comments.CommentAdd;
import grustnogram.client.functions.post.comments.CommentDelete;
import grustnogram.client.functions.post.comments.CommentLike;
import grustnogram.client.functions.profile.members.*;
import grustnogram.settings.Settings.Settings;

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
    public static void LoginRequest(Login login) {
        Login.LoginRequest();
    }

    // -----------------------------------------------
    // PhoneActiveRequest
    // params -> code from sms
    // return -> a token for further actions
    // -----------------------------------------------
    public static void PhoneActiveRequest(PhoneActive phonceActive) {
        PhoneActive.PhoneActiveRequest();
    }

    // -----------------------------------------------
    // RegisterRequest
    // params -> Email | Password | Nickname for account
    // return -> phone key for SendVerificationCode
    // -----------------------------------------------
    public static String RegisterRequest(Register register) {
        return Register.RegisterRequest();
    }

    // -----------------------------------------------
    // SendVerificationCodeRequest
    // params -> PhoneKey from RegisterRequest | Your PhoneNumber
    // return -> nothing
    // -----------------------------------------------
    public static String SendVerificationCodeRequest(SendVerificationCode sendVerificationCode) {
        return SendVerificationCode.SendVerificationCodeRequest();
    }

    // -----------------------------------------------
    // GetMyProfileInfo
    // params -> Nickname
    // return -> All info about your account
    // -----------------------------------------------
    public static void GetMyProfileInfo(GetMyProfileInfo getMyProfileInfo) {
        grustnogram.client.auth.login.GetMyProfileInfo.GetMyProfileInfoRequest();
    }

    // Chat Method's

    // Chat elements -> id | title | posts | nickname | privacy | can_write  and ....

    // -----------------------------------------------
    // GetMyChatRequest
    // params -> count ( limit ) | element ( what information do you want to take )
    // return -> List
    // -----------------------------------------------
    public static List GetMyChatRequest(GetMyChat getMyChat) {
        return GetMyChat.GetMyChatRequest();
    }

    // -----------------------------------------------
    // GetPopularChatRequest
    // params -> count ( limit ) | element ( what information do you want to take )
    // return -> List
    // -----------------------------------------------
    public static List GetPopularChatRequest(GetPopularChat getPopularChat) {
        return GetPopularChat.GetPopularChatRequest();
    }

    // -----------------------------------------------
    // JoinToChatRequest
    // params -> chat_id
    // return -> nothing
    // -----------------------------------------------
    public static void JoinChatRequest(JoinToChat joinChat) {
        JoinToChat.JoinToChatRequest();
    }

    // -----------------------------------------------
    // JoinToPrivateChatRequest
    // params -> chat_id | text_to_request
    // return -> nothing
    // -----------------------------------------------
    public static void JoinToPrivateChatRequest(JoinToPrivateChat joinPrivateChat) {
        JoinToPrivateChat.JoinToPrivateChatRequest();
    }

    // -----------------------------------------------
    // LeftFromChatRequest
    // params -> chat_id
    // return -> nothing
    // -----------------------------------------------
    public static void LeftFromChatRequest(LeftFromChat leftFromChat) {
        LeftFromChat.LeftFromChatRequest();
    }

    // -----------------------------------------------
    // LeftFromDialogRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void LeftFromDialogRequest(LeftFromDialog leftFromDialog) {
        LeftFromDialog.LeftFromDialogRequest();
    }

    // Message Method's

    // -----------------------------------------------
    // DeleteMessageRequest
    // params -> message_id
    // return -> nothing
    // -----------------------------------------------
    public static void DeleteMessageRequest(DeleteMessage deleteMessage) {
        DeleteMessage.DeleteMessageRequest();
    }

    // -----------------------------------------------
    // GetChatHistoryRequest
    // params -> id ( chat_id ) | count ( limit ) | element
    // return -> List
    // -----------------------------------------------
    public static List GetChatHistoryRequest(GetChatHistory getChatHistoryRequest) {
        return GetChatHistory.GetChatHistoryRequest();
    }

    // -----------------------------------------------
    // SendMessageRequest
    // params -> chat_id | message_text
    // return -> nothing
    // -----------------------------------------------
    public static void SendMessageRequest(SendMessage sendMessage) {
        SendMessage.SendMessageRequest();
    }

    // Post Method's

    // -----------------------------------------------
    // AddToFavouriteRequest
    // params -> post_id
    // return -> nothing
    // -----------------------------------------------
    public static void AddToFavouriteRequest(AddToFavorite addToFavorite) {
        AddToFavorite.AddToFavoriteRequest();
    }

    // -----------------------------------------------
    // LikePostRequest
    // params -> post_id
    // return -> nothing
    // -----------------------------------------------
    public static void LikePostRequest(LikePost likePost) {
        LikePost.LikePostRequest();
    }

    // -----------------------------------------------
    // SecretPostRequest
    // params -> text ( min 32 word's) | comment_of ( 1 true, 0 false )
    // return -> nothing
    // -----------------------------------------------
    public static void SecretPostRequest(SecretPost secretPost) {
        SecretPost.PostSecretRequest();
    }

    // Comments Method's

    // -----------------------------------------------
    // CommentAddRequest
    // params -> text | post_id | reply_to | private_status ( 1 true, 0 false )
    // return -> nothing
    // -----------------------------------------------
    public static void CommentAddRequest(CommentAdd addComment) {
        CommentAdd.AddCommentRequest();
    }

    // -----------------------------------------------
    // CommentDeleteRequest
    // params -> comment_id
    // return -> nothing
    // -----------------------------------------------
    public static void CommentDeleteRequest(CommentDelete commentDelete) {
        CommentDelete.CommentDeleteRequest();
    }

    // -----------------------------------------------
    // CommentLikeRequest
    // params -> comment_id
    // return -> nothing
    // -----------------------------------------------
    public static void CommentLikeRequest(CommentLike commentLike) {
        CommentLike.CommentLikeRequest();
    }

    // Members Method's

    // -----------------------------------------------
    // BlockRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void BlockRequest(Block block) {
        Block.BlockRequest();
    }

    // -----------------------------------------------
    // FollowRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void FollowRequest(Follow follow) {
        Follow.FollowRequest();
    }

    // -----------------------------------------------
    // GetHandsRequest
    // params -> count ( limit ) | element
    // return -> List
    // -----------------------------------------------
    public static List GetHandsRequest(GetHands getHands) {
        return GetHands.GetHandsRequest();
    }

    // -----------------------------------------------
    // UnBlockRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void UnBlockRequest(UnBlock unBlock) {
        UnBlock.UnBlockRequest();
    }

    // -----------------------------------------------
    // UnFollowRequest
    // params -> user_id
    // return -> nothing
    // -----------------------------------------------
    public static void UnFollow(UnFollow unFollow) {
        UnFollow.UnFollowRequest();
    }
}
