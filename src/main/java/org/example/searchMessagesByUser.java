package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class searchMessagesByUser implements Iterator {
    private String userName;
    private List<String> chatHistoryFromUser;
    private int indexInChatHistory;
    private int chatHistoryFromUserSize;

    public searchMessagesByUser(User userToSearch){
        this.userName = userToSearch.getUserName();

        //history in form "message\nanother message\nlast message\n"
        String allMessages = userToSearch.getEntireChatHistory().getSavedMessages().get(this.userName);
        String[] messages = allMessages.split("\\r?\\n|\\r");
        this.chatHistoryFromUser = Arrays.asList(messages);

        this.indexInChatHistory = 0;
        this.chatHistoryFromUserSize = chatHistoryFromUser.size();
    }

    @Override
    public boolean hasNext() {
        String message = null;

        while( indexInChatHistory < chatHistoryFromUserSize ) {
            message = chatHistoryFromUser.get(indexInChatHistory);
            if( message != null) {
                return true;
            }
            else {
                indexInChatHistory++;
            }
        }

        return false;
    }

    @Override
    public String next() {
        if( hasNext()){
            return chatHistoryFromUser.get( indexInChatHistory++ );
        }
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
