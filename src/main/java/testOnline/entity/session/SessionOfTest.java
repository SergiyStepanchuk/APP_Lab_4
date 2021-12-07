package testOnline.entity.session;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.QuestionOfTest;
import testOnline.entity.Test;
import testOnline.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EnableAutoConfiguration
@Table(name = "SessionsOfTests")
@Data
@NoArgsConstructor
public class SessionOfTest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "user_id")
    private long userId;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @Column(name = "test_id")
    private long testId;

    private Date startDateTime;
    private Date endDateTime;

    @OneToMany(mappedBy = "session")
    private Set<QuestionOfSession> questions = new HashSet<>();
}
