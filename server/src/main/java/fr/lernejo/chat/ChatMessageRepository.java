package fr.lernejo.chat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageRepository {

    private List<String>Messages;

    public ChatMessageRepository(List<String> messages) {
        Messages = messages;
    }

    void addChatMessage(String message){

        Messages.add(message);
    }

    List<String> getLastTenMessages(){
        if(Messages.size()>10){
            return Messages.subList(Messages.size()-10, Messages.size());
        }
        return Messages;
    }
}
