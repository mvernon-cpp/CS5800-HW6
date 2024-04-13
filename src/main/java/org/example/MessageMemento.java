package org.example;

//A class that represents a snapshot of a message sent by a user. It should have
//properties for the message content and timestamp
public class MessageMemento {
    private String state;

    public MessageMemento(String formattedMessage)
    {
        this.state = formattedMessage;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String formattedMessage)
    {
        this.state = formattedMessage;
    }

}
