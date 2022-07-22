package edu.school21.chat;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long chatroomId;
    private String chatroomName;
    private User chatroomOwner;
    private List<Message> MessagesInChatroom;

    public Chatroom(Long chatroomId, String chatroomName, User chatroomOwner, List<Message> messagesInChatroom) {
        this.chatroomId = chatroomId;
        this.chatroomName = chatroomName;
        this.chatroomOwner = chatroomOwner;
        MessagesInChatroom = messagesInChatroom;
    }

    public Long getChatroomId() {
        return chatroomId;
    }

    public String getChatroomName() {
        return chatroomName;
    }

    public User getChatroomOwner() {
        return chatroomOwner;
    }

    public List<Message> getMessagesInChatroom() {
        return MessagesInChatroom;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public void setChatroomName(String chatroomName) {
        this.chatroomName = chatroomName;
    }

    public void setChatroomOwner(User chatroomOwner) {
        this.chatroomOwner = chatroomOwner;
    }

    public void setMessagesInChatroom(List<Message> messagesInChatroom) {
        MessagesInChatroom = messagesInChatroom;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "chatroomId=" + chatroomId +
                ", chatroomName='" + chatroomName + '\'' +
                ", chatroomOwner='" + chatroomOwner + '\'' +
                ", MessagesInChatroom=" + MessagesInChatroom +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chatroom)) return false;
        Chatroom chatroom = (Chatroom) o;
        return getChatroomId().equals(chatroom.getChatroomId())
                && getChatroomName().equals(chatroom.getChatroomName())
                && getChatroomOwner().equals(chatroom.getChatroomOwner())
                && Objects.equals(getMessagesInChatroom(), chatroom.getMessagesInChatroom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatroomId(), getChatroomName(), getChatroomOwner(), getMessagesInChatroom());
    }

}
