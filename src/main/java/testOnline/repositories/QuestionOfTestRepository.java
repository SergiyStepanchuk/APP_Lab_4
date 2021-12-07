package testOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import testOnline.entity.QuestionOfTest;

public interface QuestionOfTestRepository extends JpaRepository<QuestionOfTest,Long> {
}
