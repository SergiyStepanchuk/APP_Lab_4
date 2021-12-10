package testOnline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import testOnline.entity.session.OptionOfQuestionInSession;
import testOnline.entity.session.SessionOfTest;

public interface OptionOfQuestionInSessionRepository extends JpaRepository<OptionOfQuestionInSession, Long> {
    public OptionOfQuestionInSession findByIdAndQuestion_Session_User_Id(long id, long userId);
}
