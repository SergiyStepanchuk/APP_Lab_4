package testOnline.entity;

import testOnline.entity.enumeration.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    private String login;
    private String passwordHash;
    private UserRole role;

    public User(String login, String passwordHash, UserRole role) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "login = " + login + ", " +
                "passwordHash = " + passwordHash + ", " +
                "role = " + role + ")";
    }

    public String getId() {
        return id;
    }
}
