package edu.school21.chat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private Long messageId;
    private User messageAuthor;
    private Chatroom messageRoom;
    private String messageText;
    private String messageDateTime;

    public Message(Long messageId, User messageAuthor, Chatroom messageRoom, String messageText, String messageDateTime) {
        this.messageId = messageId;
        this.messageAuthor = messageAuthor;
        this.messageRoom = messageRoom;
        this.messageText = messageText;
        this.messageDateTime = messageDateTime;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public void setMessageRoom(Chatroom messageRoom) {
        this.messageRoom = messageRoom;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public Long getMessageId() {
        return messageId;
    }

    public User getMessageAuthor() {
        return messageAuthor;
    }

    public Chatroom getMessageRoom() {
        return messageRoom;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getMessageId().equals(message.getMessageId())
                && getMessageAuthor().equals(message.getMessageAuthor())
                && getMessageRoom().equals(message.getMessageRoom())
                && getMessageText().equals(message.getMessageText())
                && getMessageDateTime().equals(message.getMessageDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageAuthor, messageRoom, messageText, messageDateTime);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageAuthor='" + messageAuthor + '\'' +
                ", messageRoom='" + messageRoom + '\'' +
                ", messageText='" + messageText + '\'' +
                ", messageDateTime='" + messageDateTime + '\'' +
                '}';
    }
}
