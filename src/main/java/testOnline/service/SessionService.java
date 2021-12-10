package testOnline.service;

import testOnline.dto.session.OptionOfQuestionInSessionDTO;
import testOnline.dto.session.SessionOfTestDTO;
import testOnline.entity.User;

public interface SessionService {
    SessionOfTestDTO startNewSession(User user, long testId);
    SessionOfTestDTO getById(User user, long sessionId);
    SessionOfTestDTO endSessionById(User user, long sessionId);
    OptionOfQuestionInSessionDTO setQuestionOption(User user, long oid, boolean selection);
}
