package testOnline.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import testOnline.entity.OptionOfQuestion;
import testOnline.entity.QuestionOfTest;

import java.util.List;


public interface OptionOfQuestionRepository extends JpaRepository<OptionOfQuestion,Long> {
    public List<OptionOfQuestion> findAllByQuestionId(long testId);
}
