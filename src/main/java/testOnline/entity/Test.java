package testOnline.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.session.SessionOfTest;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedEntityGraph(name = "Test.questions", attributeNodes = @NamedAttributeNode("questions"))
@EnableAutoConfiguration
@Table(name = "Tests")
@Data
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String Name;
    private String Description;
    private int MaxCountOfQuestions;
    private int TestLengthInMinuts;

    @OneToMany(mappedBy = "test", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private Set<QuestionOfTest> questions = new HashSet<>();

    @OneToMany(mappedBy = "test", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<SessionOfTest> sessions = new HashSet<>();
}
