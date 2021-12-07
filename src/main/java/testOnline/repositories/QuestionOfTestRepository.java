package testOnline.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import testOnline.entity.QuestionOfTest;
import java.util.List;

public interface QuestionOfTestRepository extends JpaRepository<QuestionOfTest,Long> {
    @EntityGraph(attributePaths = {"options"})
    public List<QuestionOfTest> findAllByTestId(long testId);
}
