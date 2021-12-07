package testOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import testOnline.entity.Test;
import testOnline.entity.User;

public interface TestsRepository extends JpaRepository<Test,Long>
{
}
