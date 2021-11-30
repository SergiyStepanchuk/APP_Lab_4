package testOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import testOnline.entity.Test;

public interface TestsRepository extends JpaRepository<Test,Long>
{
}
