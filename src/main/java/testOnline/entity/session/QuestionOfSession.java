package testOnline.entity.session;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.QuestionOfTest;
import testOnline.utils.RandomComparator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@EnableAutoConfiguration
@Table(name = "QuestionsOfSessions")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"session", "baseQuestion"})
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

    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<OptionOfQuestionInSession> options = new HashSet<>();

    public QuestionOfSession(SessionOfTest session, QuestionOfTest baseQuestion) {
        this.session = session;
        this.baseQuestion = baseQuestion;

        this.options = new HashSet<>(
                Stream.concat(
                        baseQuestion.getOptions()
                                .stream().filter(item -> !item.isCorrect())
                                .sorted(new RandomComparator<>())
                                .limit(baseQuestion.maxOptionsCount - baseQuestion.maxSelectedOptionsCount),
                        baseQuestion.getOptions()
                                .stream().filter(item -> item.isCorrect())
                                .sorted(new RandomComparator<>())
                                .limit(baseQuestion.maxSelectedOptionsCount)
                ).sorted(new RandomComparator<>()).map(o -> new OptionOfQuestionInSession(this, o)).collect(Collectors.toList())
        );
    }
}
