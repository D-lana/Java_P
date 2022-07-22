package edu.school21.chat;

import java.util.List;
import java.util.Objects;

public class User {
    private int userId;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> usingRooms;

    public User(int userId, String login, String password, List<Chatroom> createdRooms, List<Chatroom> usingRooms) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.usingRooms = usingRooms;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", usingRooms=" + usingRooms +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User user = (User) obj;
        return getUserId() == user.getUserId()
                && getLogin().equals(user.getLogin())
                && getPassword().equals(user.getPassword())
                && Objects.equals(getCreatedRooms(), user.getCreatedRooms())
                && Objects.equals(getUsingRooms(), user.getUsingRooms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, login, password, createdRooms, usingRooms);
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public List<Chatroom> getUsingRooms() {
        return usingRooms;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public void setUsingRooms(List<Chatroom> usingRooms) {
        this.usingRooms = usingRooms;
    }
}
