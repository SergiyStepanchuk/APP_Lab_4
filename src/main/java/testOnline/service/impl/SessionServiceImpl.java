package testOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.session.OptionOfQuestionInSessionDTO;
import testOnline.dto.session.SessionOfTestDTO;
import testOnline.entity.User;
import testOnline.entity.session.SessionOfTest;
import testOnline.exceptions.BadRequesException;
import testOnline.mappers.OptionOfQuestionInSessionToOptionOfQuestionInSessionDTOMapper;
import testOnline.mappers.SessionOfTestToSessionOfTestDTOMapper;
import testOnline.repositories.OptionOfQuestionInSessionRepository;
import testOnline.repositories.SessionRepository;
import testOnline.repositories.TestsRepository;
import testOnline.service.SessionService;

import java.util.Date;

@Component
public class SessionServiceImpl implements SessionService {
    @Autowired private TestsRepository testsRepo;
    @Autowired private SessionRepository sessionsRepo;
    @Autowired private OptionOfQuestionInSessionRepository optionsRepo;

    @Autowired private SessionOfTestToSessionOfTestDTOMapper sessionMapper;
    @Autowired private OptionOfQuestionInSessionToOptionOfQuestionInSessionDTOMapper optionMapper;

    public SessionOfTestDTO startNewSession(User user, long testId)
    {
        var test = testsRepo.getById(testId);
        var session = sessionsRepo
                                    .getOne(testId,
                                            user.getId()
                                    );
        if (session != null) {
            var sessionEndDate = session.getStartDateTime().getTime() +
                    (long) session.getTest().getTestLengthInMinuts() * 60 * 1000;
            if (sessionEndDate > new Date().getTime())
                return sessionMapper.toDTO(session);
        }

        return sessionMapper.toDTO(sessionsRepo.save(new SessionOfTest(user, test)));
    }

    public SessionOfTestDTO getById(User user, long sessionId)
    {
        return sessionMapper.toDTO(sessionsRepo.findByIdAndUserId(user.getId(), sessionId));
    }

    public SessionOfTestDTO endSessionById(User user, long sessionId)
    {
        var session = sessionsRepo.findByIdAndUserId(user.getId(), sessionId);
        var endDate = new Date();

        var sessionEndDate = new Date(session.getStartDateTime().getTime() +
                (long) session.getTest().getTestLengthInMinuts() * 60 * 1000);
        if (endDate.getTime() > sessionEndDate.getTime())
            endDate = sessionEndDate;

        if (session.getEndDateTime() != null)
            throw new BadRequesException("Test is already ended!");

        session.setEndDateTime(endDate);
        return sessionMapper.toDTO(sessionsRepo.save(session));
    }

    public OptionOfQuestionInSessionDTO setQuestionOption(User user, long oid, boolean selection)
    {
        var option = optionsRepo.findByIdAndQuestion_Session_User_Id(oid, user.getId());
        var session = option.getQuestion().getSession();

        var endDate = new Date();
        var sessionEndDate = new Date(session.getStartDateTime().getTime() +
                (long) session.getTest().getTestLengthInMinuts() * 60 * 1000);

        if (option.getQuestion().getSession().getEndDateTime() != null || endDate.getTime() > sessionEndDate.getTime())
            throw new BadRequesException("Test is already ended!");

        option.setSelected(selection);
        return optionMapper.toDTO(option);
    }

}
