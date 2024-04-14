package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//A class that stores the chat history for a user. It should have methods to add a new
//message to the history and get the last message sent
public class ChatHistory {
//    private ArrayList<String> savedMessages;
    private HashMap<String, String> savedMessages;
    MessageMemento messageMemento = new MessageMemento(savedMessages);
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

            newMessage = message  + "\n"+ savedMessages.get(username);
        }
        savedMessages.put(username, newMessage );


    }

    public void saveMessageMemento()
    {
        //save new memento state
        messageMemento.setState(savedMessages);
        System.out.println("********Save message memento*********");

    }
    public void undoMessageMemento()
    {
        savedMessages = messageMemento.getState();
    }

    public MessageMemento getMessageMemento()
    {
        return messageMemento;
    }

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

        //getEntireChatHistory()
        String messageHistory = "";
        for( Map.Entry<String, String> m : savedMessages.entrySet() )
            messageHistory += m.getValue() + "\n";
        return messageHistory;

    }
}
