package testOnline.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import testOnline.entity.Test;

import java.util.List;

public interface TestsRepository extends JpaRepository<Test,Long>
{
    @EntityGraph(value = "Test.questions", type = EntityGraph.EntityGraphType.LOAD)
    List<Test> findAllWithData();
}
