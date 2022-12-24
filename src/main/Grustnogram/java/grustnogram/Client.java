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

/**
 * Client for Grustnogramm
 * @author Mookie
 * @date 24.12.22
 */
public class Client extends Settings {

    /**
     * Login into account , to get token
     * @param Email - Account email
     * @param Password - Account password
     * @see grustnogram.client.auth.login.Login
     * @return token for further actions
     */

    public static void loginRequest(Login login) {
        Login.loginRequest();
    }

    /**
     * function for receiving a code from sms
     * @param code - code from sms
     * @return token for further actions
     */
    public static void phoneActiveRequest(PhoneActive phonceActive) {
        PhoneActive.phoneActiveRequest();
    }

    /**
     * function for creating a mail name and password for an account
     * @param email - email for account
     * @param password - password for account
     * @param nickname - nickname for account
     * @return phone_key for
     */
    public static String registerRequest(Register register) {
        return Register.registerRequest();
    }

    /**
     * function for sending a phone confirmation code
     * @param phone - your phone number
     * @param phone_key - phone_key from register_request
     * @return token for further actions
     */
    public static String sendVerificationCodeRequest(SendVerificationCode sendVerificationCode) {
        return SendVerificationCode.sendVerificationCodeRequest();
    }

    /**
     * function for getting information about the client
     * @param nickname - your nickname
     * @return information about the client
     */
    public static void getProfileInfo(GetProfileInfo getProfileInfo) {
        GetProfileInfo.getProfileInfoRequest();
    }

    /**
     * function for receiving client chats
     * @param count - the number of messages that will be returned
     * @param element - what will be returned from the function ( id , title, nickname )
     * @return client chat list
     */
    public static List getMyChatRequest(GetMyChat getMyChat) {
        return GetMyChat.getMyChatRequest();
    }

    /**
     * function for getting popular chats
     * @param count - the number of messages that will be returned
     * @param element - what will be returned from the function ( id , title, nickname )
     * @return Popular chat list
     */
    public static List getPopularChatRequest(GetPopularChat getPopularChat) {
        return GetPopularChat.getPopularChatRequest();
    }

    /**
     * function for joining a chat
     * @param chat_id - id of the chat that the client will join
     * @return
     */
    public static void joinChatRequest(JoinToChat joinChat) {
        JoinToChat.joinToChatRequest();
    }

    /**
     * a function for requesting access to a private chat
     * @param chat_id - id of the chat that the client will send request
     * @param text_to_request - the text of the request to log in to the chat
     * @return
     */
    public static void joinToPrivateChatRequest(JoinToPrivateChat joinPrivateChat) {
        JoinToPrivateChat.joinToPrivateChatRequest();
    }

    /**
     * function for exiting the chat
     * @param chat_id - id of the chat from which the client will exit
     * @return
     */
    public static void leftFromChatRequest(LeftFromChat leftFromChat) {
        LeftFromChat.leftFromChatRequest();
    }

    /**
     * a function for exiting a client from his personal chats
     * @param user_id - id of the person with whom the client will delete the chat
     * @return
     */
    public static void leftFromDialogRequest(LeftFromDialog leftFromDialog) {
        LeftFromDialog.leftFromDialogRequest();
    }

    /**
     * function for getting chat history
     * @param chat_id - id of the chat to collect information
     * @param count - the number of messages from which the information will be taken
     * @param element - what information will be taken from the message (id, message)
     * @return List of information from the chat
     */
    public static List getChatHistoryRequest(GetChatHistory getChatHistoryRequest) {
        return GetChatHistory.getChatHistoryRequest();
    }

    /**
     * function for sending a message to a chat
     * @param chat_id - id of the chat or the person who will receive the message
     * @param message_text - the text of the message
     * @return
     */
    public static void sendMessageRequest(Message.SendMessage sendmessage){
        sendmessage.sendMessageRequest();}

    /**
     * function for deleting a message
     * @param message_id id of the message that will be deleted
     * @return
     */
    public static void deleteMessageRequest(Message.DeleteMessage deleteMessage){
        Message.DeleteMessage.deleteMessageRequest();
    }

    /**
     * function for adding a post to the favorite section
     * @param post_id - id of the post to add to the favorite section
     * @return
     */
    public static void addToFavouriteRequest(AddToFavorite addToFavorite) {
        AddToFavorite.addToFavoriteRequest();
    }

    /**
     * function for liking a post
     * @param post_id - id of the post that the client liking
     * @return
     */
    public static void likePostRequest(LikePost likePost) {
        LikePost.likePostRequest();
    }

    /**
     * function for creating a secret post
     * @param text - the text of the post. minimum 32 words
     * @param comment_of - Permission to post comments by other users ( 1 - allowed, 0 - prohibited )
     * @return
     */
    public static void secretPostRequest(SecretPost secretPost) {
        SecretPost.postSecretRequest();
    }

    /**
     *  function for publishing a comment
     * @param text - comment text
     * @param post_id - id of the post on which the client will leave a comment
     * @param reply_to - id of the message to which the user will respond
     * @param private_statuc - message status ( 1 - visible to everyone, 0 - only to the author of the post )
     */
    public static void commentAddRequest(CommentAdd addComment) {
        CommentAdd.addCommentRequest();
    }

    /**
     *  function for deleting a comment
     * @param comment_id - id of the comment being deleted
     * @return
     */
    public static void commentDeleteRequest(CommentDelete commentDelete) {
        CommentDelete.commentDeleteRequest();
    }

    /**
     * a function for liking a comment
     * @param comment_id -  the comment that the client likes
     * @return
     */
    public static void commentLikeRequest(CommentLike commentLike) {
        CommentLike.commentLikeRequest();
    }

    /**
     * function for blocking the user
     * @param user_id - id of the blocked user
     * @return
     */
    public static void blockRequest(Block block) {
        Block.BlockRequest();
    }

    /**
     * a function for subscribing to a person
     * @param user_id - id of the person the client will subscribe to
     * @return
     */
    public static void followRequest(Follow follow) {
        Follow.FollowRequest();
    }

    /**
     * a function for getting people who are ready to chat
     * @param cout - number of people to collect
     * @param element - what information should be taken from the user (nickname, id)
     * @return a list with the data of users who are ready to communicate
     */
    public static List getHandsRequest(GetHands getHands) {
        return GetHands.GetHandsRequest();
    }

    /**
     * function to unblock the user
     * @param user_id - id of the person to unlock
     * @return
     */
    public static void unBlockRequest(UnBlock unBlock) {
        UnBlock.UnBlockRequest();
    }

    /**
     * function for unsubscribing from a person
     * @param user_id - id of the person you want to unsubscribe from
     */
    public static void unFollow(UnFollow unFollow) {
        UnFollow.UnFollowRequest();
    }
}
