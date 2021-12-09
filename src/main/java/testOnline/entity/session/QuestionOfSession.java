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
import java.util.HashSet;
import java.util.Set;

@Entity
@EnableAutoConfiguration
@Table(name = "QuestionsOfSessions")
@Data
@NoArgsConstructor
public class QuestionOfSession {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private SessionOfTest session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_question_id")
    private QuestionOfTest baseQuestion;

    @OneToMany(mappedBy = "baseOption",cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY,orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<OptionOfQuestionInSession> options = new HashSet<>();
}
