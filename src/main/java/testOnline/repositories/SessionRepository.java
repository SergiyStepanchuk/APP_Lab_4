package testOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import testOnline.entity.session.SessionOfTest;

import java.util.Date;

public interface SessionRepository extends JpaRepository<SessionOfTest,Long> {
    @Query(value = "SELECT s FROM SessionOfTest s WHERE s.test.id = ?1 AND s.user.id = ?2 AND s.endDateTime IS NULL ORDER BY s.startDateTime")
    public SessionOfTest getOne(long testId, long userId);
    public SessionOfTest findByIdAndUserId(long id, long userId);
}
