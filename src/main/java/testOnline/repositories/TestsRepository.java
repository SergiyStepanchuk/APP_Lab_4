package testOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import testOnline.entity.Test;
import testOnline.entity.User;

public interface TestsRepository extends JpaRepository<Test,Long>
{
}
