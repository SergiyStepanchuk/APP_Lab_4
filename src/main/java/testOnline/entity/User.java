package testOnline.entity;

import testOnline.entity.enumeration.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.session.SessionOfTest;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EnableAutoConfiguration
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String login;
    private String passwordHash;
    private UserRole role;

    @OneToMany(mappedBy = "user")
    private Set<SessionOfTest> session = new HashSet<>();

    public User(String login, String passwordHash, UserRole role) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.role = role;
    }
}
