package school21.spring.service.models;

public class User {
    private long identifier;
    private String email;

    public User() {
    }

    public User(long identifier, String email) {
        this.identifier = identifier;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier=" + identifier +
                ", email='" + email + '\'' +
                '}';
    }

    public long getIdentifier() {
        return identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }
}