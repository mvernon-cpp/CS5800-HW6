package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//A class that stores the chat history for a user. It should have methods to add a new
//message to the history and get the last message sent
public class ChatHistory {
//    private ArrayList<String> savedMessages;
    private HashMap<String, String> savedMessages;
    public  ChatHistory(){
        this.savedMessages = new HashMap<>();
    }
    public void saveMessage(String username, String message)
    {
        String newMessage;

        //get previous chat history of user and append new message to save
        if (savedMessages.get(username) == null)
        {
            newMessage = message;
        }
        else {

            newMessage = savedMessages.get(username) + "\n"+ message;
        }
        savedMessages.put(username, newMessage );

//        savedMessages.put("User0", "Testing saveMessage method");

    }

//    public String getLastMessage()
//    {
//        return this.savedMessages.get(savedMessages.size() - 1);
//    }

    public String printChatHistoryFromUser( String username ) {
        if (savedMessages.get(username) == null)
            return "No messages from " + username;
        else {
            return savedMessages.get(username);
        }
    }

    @Override
    public String toString()
    {
        if( savedMessages.isEmpty() )
            return "Chat History is empty";

        //getEntireCHatHistory()
        String messageHistory = "";
        for( Map.Entry<String, String> m : savedMessages.entrySet() )
            messageHistory += m.getValue() + "\n";
        return messageHistory;

    }
}
