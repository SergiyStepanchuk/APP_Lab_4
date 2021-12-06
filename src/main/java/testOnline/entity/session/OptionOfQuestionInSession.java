package testOnline.entity.session;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.OptionOfQuestion;

import javax.persistence.*;

@Entity
@EnableAutoConfiguration
@Table(name="OptionsOfQuestionsInSessions")
@Data
@NoArgsConstructor
public class OptionOfQuestionInSession {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionOfSession question;
    @Column(name = "question_id")
    private long questionId;

    @ManyToOne
    @JoinColumn(name = "base_option_id")
    private OptionOfQuestion baseOption;
    @Column(name = "base_option_id")
    private long base_optionId;

    private boolean Selected;
}
