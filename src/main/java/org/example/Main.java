package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User person1 = new User("Amanda");
        User person2 = new User("Alice");
        User person3 = new User("Bob");
        User person4 = new User("Eve");
        User person5 = new User("John");

        chatServer.registerUser(person1);
        chatServer.registerUser(person2);
        chatServer.registerUser(person3);
        chatServer.registerUser(person4);
        chatServer.registerUser(person5);

        ArrayList<User> person1SendTo = new ArrayList<>();
        person1SendTo.add(person2);
        person1SendTo.add(person3);
        person1SendTo.add(person4);
        person1SendTo.add(person5);
        ArrayList<User> person2SendTo = new ArrayList<>();
        person2SendTo.add(person1);
        person2SendTo.add(person3);
        person2SendTo.add(person4);
        person2SendTo.add(person5);
        ArrayList<User> person4SendTo = new ArrayList<>();
        person4SendTo.add(person1);
        person4SendTo.add(person3);
        person4SendTo.add(person2);
        person4SendTo.add(person5);

        System.out.println("Users can send messages to one or more other users through the chat server.\n============================================================");
        Message person1Message1 = new Message(person1, person1SendTo, "15:47:14", "Hey guys, anyone want to hangout this weekend?");
        Message person1Message2 = new Message(person1, person1SendTo, "15:47:25", "Let's do something fun!");

//        person1Message1.printMessage();
        chatServer.setMessage(person1Message1);
        chatServer.sendMessage();

//        person1Message2.printMessage();
        chatServer.setMessage(person1Message2);
        chatServer.sendMessage();

        Message person2Message1 = new Message(person2, person2SendTo, "15:49:52", "I'm not available this weekend. Remove me please, thank you.");
//        person2Message1.printMessage();
        chatServer.setMessage(person2Message1);
        chatServer.sendMessage();

        System.out.println("\nUsers can block messages from specific users using the Mediator design pattern.\n============================================================");
        chatServer.blockUser(person2);
        Message person4Message1 = new Message(person4, person4SendTo, "15:55:12", "I blocked them from the chat.");
        Message person4Message2 = new Message(person4, person4SendTo, "15:55:21", "I'm free both days.");
        Message person4Message3 = new Message(person4, person4SendTo, "15:55:25", "We should go bowling.");

//        person4Message1.printMessage();
        chatServer.setMessage(person4Message1);
        chatServer.sendMessage();

//        person4Message2.printMessage();
        chatServer.setMessage(person4Message2);
        chatServer.sendMessage();

        System.out.println("\nUsers can undo the last message they sent using the Memento design pattern.\n============================================================");
        person4.backupMessages();
        System.out.println( person4.getEntireChatHistory().getMessageMemento());
        System.out.println( person4.getEntireChatHistory());

//        person4Message3.printMessage();
        chatServer.setMessage(person4Message3);
        chatServer.sendMessage();

        person4.undoLastMessage();
        System.out.println( person4.getEntireChatHistory().getMessageMemento());
        System.out.println( person4.getEntireChatHistory() );


        Message person4Message4 = new Message(person4, person4SendTo, "15:55:25", "We should go roller skating.");

//        person4Message4.printMessage();
        chatServer.setMessage(person4Message4);
        chatServer.sendMessage();

        System.out.println("\nUsers can receive messages from other users and view the chat history for a specific user.\n============================================================");

        System.out.println("\nGetting entire chat history of user person5...");
        System.out.println( person5.getEntireChatHistory() );

        System.out.println("\nGetting chat history of person5 from person1...");
        System.out.println( person4.printChatHistoryFromUser( person1.getUserName() ) );
    }
}