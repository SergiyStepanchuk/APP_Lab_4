package testOnline.entity.session;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.QuestionOfTest;
import testOnline.entity.Test;
import testOnline.entity.User;
import testOnline.utils.RandomComparator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@EnableAutoConfiguration
@Table(name = "SessionsOfTests")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"user", "test"})
public class SessionOfTest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    private Date startDateTime;
    private Date endDateTime;

    @OneToMany(mappedBy = "session", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<QuestionOfSession> questions = new HashSet<>();

    public SessionOfTest(User user, Test baseTest)
    {
        this.user = user;
        this.test = baseTest;
        this.startDateTime = new Date();

        this.questions = new HashSet<>(baseTest.getQuestions().stream()
                .sorted(new RandomComparator<>())
                .limit(baseTest.getMaxCountOfQuestions())
                .map(q -> new QuestionOfSession(this, q))
                .collect(Collectors.toList())
        );
    }
}
