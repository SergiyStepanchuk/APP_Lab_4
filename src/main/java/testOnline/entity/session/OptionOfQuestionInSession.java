package testOnline.entity.session;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.OptionOfQuestion;
import testOnline.entity.QuestionOfTest;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
@Table(name="OptionsOfQuestionsInSessions")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"question", "baseOption"})
public class OptionOfQuestionInSession {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionOfSession question;

    @ManyToOne
    @JoinColumn(name = "base_option_id")
    private OptionOfQuestion baseOption;

    private boolean selected = false;

    public OptionOfQuestionInSession(QuestionOfSession question, OptionOfQuestion baseOption)
    {
        this.question = question;
        this.baseOption = baseOption;
    }
}
