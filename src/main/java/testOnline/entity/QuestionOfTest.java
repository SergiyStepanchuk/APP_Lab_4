package testOnline.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;
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
@EqualsAndHashCode(exclude = {"test"})
@NoArgsConstructor
public class QuestionOfTest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    private String question;
    public int maxSelectedOptionsCount = 1;
    public int maxOptionsCount = 4;

    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<OptionOfQuestion> options = new HashSet<>();

    @OneToMany(mappedBy = "baseQuestion", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<QuestionOfSession> sessionQuestions = new HashSet<>();
}
