package org.example;

import java.util.ArrayList;

//The mediator class that manages communication between users. It should have methods to
//register and unregister users, send messages from one user to one or more other users, and block
//messages from specific users
public class ChatServer {
    private ArrayList<User> activeUsers, blockedUsers;
    private Message message;
    public ChatServer()
    {
        this.activeUsers = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
    }

    public void setMessage(Message message)
    {
        this.message = message;
    }



    public void sendMessage(){

        System.out.println("Sending messages to users...");
        User sender = message.getSender();
        sender.receiveMessage(sender.getUserName(), message.getFormattedMessage());

        if(activeUsers.contains( sender ) ) {
            ArrayList<User> usersToReceiveMessage = message.getRecipients();

                for (User user : usersToReceiveMessage){
                    if(  blockedUsers.contains( user ) ) {
                        System.out.println("User is blocked from receiving messages." );
                    } else{
                        user.receiveMessage(sender.getUserName(), message.getFormattedMessage());
                    }
                }
        } else if ( blockedUsers.contains( sender ) ) {
            System.out.println("User is blocked from sending messages." );

        } else {
            System.out.println("Message not sent to recipients. " + message.getSender().getUserName() + " is not a registered user.");

        }
    }

    //can send messages
    public void registerUser(User user){
        activeUsers.add(user);
        System.out.println("Registered user " + user.getUserName());
    }

    public void unregisterUser(User user){
        activeUsers.remove(user);
        System.out.println("Unregistered user " + user.getUserName());
    }

    //can not send messages
    public void blockUser(User user){
        blockedUsers.add(user);
        System.out.println("Blocked user " + user.getUserName());
    }

    public void unblockUser(User user){
        blockedUsers.remove(user);
        System.out.println("Unblocked user " + user.getUserName());
    }
}
