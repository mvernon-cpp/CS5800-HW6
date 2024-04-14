package org.example;

import java.util.HashMap;
import java.util.Map;

//A class that represents a snapshot of a message sent by a user. It should have
//properties for the message content and timestamp
public class MessageMemento {
    private HashMap<String, String> state;

    public MessageMemento(HashMap<String, String> state)
    {
        this.state = state;
    }

    public HashMap<String, String> getState()
    {
        return state;
    }

    public void setState(HashMap<String, String> state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        System.out.println( "\n***************\nmessage memento state\n***************" );

        if( state.isEmpty() )
            return "empty";

        //getEntireChatHistory()
        String messageHistory = "";
        for( Map.Entry<String, String> m : state.entrySet() )
            messageHistory += m.getValue() + "\n";
        return messageHistory;

    }

}
