package testOnline.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.session.SessionOfTestDTO;
import testOnline.entity.session.SessionOfTest;

import java.util.stream.Collectors;

@Component
public class SessionOfTestToSessionOfTestDTOMapper {
    @Autowired private UserToUserDTOMapper userMapper;
    @Autowired private TestToTestDTO testMapper;
    @Autowired private QuestionOfSessionToQuestionOfSessionDTOMapper questionMapper;

    public SessionOfTestDTO toDTO(final SessionOfTest session){

        final var sessionDTO = new SessionOfTestDTO();

        sessionDTO.setId(session.getId());
        sessionDTO.setUser(userMapper.toDTO(session.getUser()));
        sessionDTO.setTest(testMapper.toDTO(session.getTest()));
        sessionDTO.setStartDateTime(session.getStartDateTime());
        sessionDTO.setEndDateTime(session.getEndDateTime());
        sessionDTO.setQuestions(session.getQuestions().stream().map(questionMapper::toDTO).collect(Collectors.toList()));
        return  sessionDTO;
    }
}
