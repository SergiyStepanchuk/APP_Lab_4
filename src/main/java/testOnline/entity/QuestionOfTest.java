package testOnline.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.session.QuestionOfSession;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraph(name = "QuestionOfTest.options", attributeNodes = @NamedAttributeNode("options"))
@EnableAutoConfiguration
@Table(name = "QuestionsOfTests")
@Data
@NoArgsConstructor
public class QuestionOfTest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "test_id")
    @PrimaryKeyJoinColumn
    private Test test;
    @Column(name = "test_id")
    private long testId;

    private String question;
    public int maxSelectedOptionsCount = 1;
    public int maxOptionsCount = 4;

    @OneToMany(mappedBy = "question")
    private Set<OptionOfQuestion> options = new HashSet<>();

    @OneToMany(mappedBy = "baseQuestion")
    private Set<QuestionOfSession> sessionQuestions = new HashSet<>();
}
