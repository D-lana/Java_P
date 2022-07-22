package edu.school21.models;

import java.time.LocalDateTime;
import java.util.Objects;
import edu.school21.models.User;
import edu.school21.models.Chatroom;

public class Message {
    private Long messageId;
    private User messageAuthor;
    private Chatroom messageRoom;
    private String messageText;
    private LocalDateTime messageDateTime;

    public Message(Long messageId, User messageAuthor, Chatroom messageRoom, String messageText, LocalDateTime messageDateTime) {
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

    public void setMessageDateTime(LocalDateTime messageDateTime) {
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

    public LocalDateTime getMessageDateTime() {
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
