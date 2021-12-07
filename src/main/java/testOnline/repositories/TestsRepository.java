package testOnline.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import testOnline.entity.Test;
import java.util.List;

public interface TestsRepository extends JpaRepository<Test,Long>
{
    @EntityGraph(attributePaths = {"questions.options"})
    @Query("SELECT t FROM Tests t")
    List<Test> findAllWithData();

}
