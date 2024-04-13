package org.example;

import java.util.ArrayList;

//A class representing a message sent by a user. It should have properties for the sender,
//recipient(s), timestamp, and message content
public class Message {
    private User sender;
    private ArrayList<User> recipients;
    private String timestamp, message;


    public Message( User sender, ArrayList<User> recipients, String timestamp, String message)
    {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = timestamp;
        this.message = message;
    }

    public ArrayList<User> getRecipients() { return recipients;}
    public User getSender() { return sender;}
    public String getMessage() { return this.message;}
    public String getFormattedMessage() { return "<" + this.sender.getUserName()  + ">\t[" +  this.timestamp + "]\t" + this.message;}
    public void printMessage() { System.out.println(this);}

    @Override
    public String toString()
    {
        String formattedMessage = "\n";

        formattedMessage += "Timestamp: " + this.timestamp + "\nFrom: <" + this.sender.getUserName() + ">\nTo: ";
        for(User user: this.getRecipients() )
            formattedMessage += "<" +user.getUserName() + "> ";
        formattedMessage += "\n" + this.message + "\n";

        return formattedMessage;
    }
}
