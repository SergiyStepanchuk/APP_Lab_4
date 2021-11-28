package testOnline.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import testOnline.entity.session.SessionOfTest;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    @OneToMany(mappedBy = "test")
    private Set<QuestionOfTest> questions = new HashSet<>();

    @OneToMany(mappedBy = "test")
    private Set<SessionOfTest> sessions = new HashSet<>();
}
