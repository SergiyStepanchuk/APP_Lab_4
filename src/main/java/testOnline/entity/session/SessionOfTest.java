package testOnline.entity.session;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    private Date startDateTime;
    private Date endDateTime;

    @OneToMany(mappedBy = "session",cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY,orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<QuestionOfSession> questions = new HashSet<>();
}
