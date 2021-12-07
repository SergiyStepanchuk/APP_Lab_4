package testOnline.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.session.OptionOfQuestionInSession;
import testOnline.entity.session.QuestionOfSession;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EnableAutoConfiguration
@Table(name = "OptionsOfQuestions")
@Data
@EqualsAndHashCode(exclude = {"question"})
@NoArgsConstructor
public class OptionOfQuestion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionOfTest question;

    private String answer;
    private boolean correct = false;

    @OneToMany(mappedBy = "baseOption", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<OptionOfQuestionInSession> sessionOptions = new HashSet<>();
}
