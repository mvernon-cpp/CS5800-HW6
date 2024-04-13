package org.example;

//A class representing a user of the chat application. It should have methods to send messages to
//other users, receive messages from other users, and undo the last message sent.
//NOTE: You will NOT communicate with other Users directly you will use Mediator!
public class User {
    private String userName;
    private ChatHistory chatHistory;
    public User(String userName){
        this.userName = userName;
        this.chatHistory = new ChatHistory();
    }

    public String getUserName(){ return this.userName;}
    public ChatHistory getEntireChatHistory(){return this.chatHistory;}
    public String printChatHistoryFromUser( String username ){
        return this.chatHistory.printChatHistoryFromUser(username);
    }


        public void receiveMessage(String senderUsername, String message)
    {
        chatHistory.saveMessage(senderUsername, message);
        System.out.println(this.userName + ": Message received!");
    }

    public void undoLastMessage()
    {
        System.out.println("Last message undone!");
    }

}
