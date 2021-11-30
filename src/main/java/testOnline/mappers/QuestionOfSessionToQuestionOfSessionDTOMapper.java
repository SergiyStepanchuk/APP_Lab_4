package testOnline.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.session.QuestionOfSessionDTO;
import testOnline.entity.session.QuestionOfSession;

import java.util.stream.Collectors;

@Component
public class QuestionOfSessionToQuestionOfSessionDTOMapper {
    @Autowired private  OptionOfQuestionInSessionToOptionOfQuestionInSessionDTOMapper optionMapper;

    public QuestionOfSessionDTO toDTO(final QuestionOfSession question){

        final var questionDTO = new QuestionOfSessionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setMaxOptionsCount(question.getBaseQuestion().getMaxOptionsCount());
        questionDTO.setMaxSelectedOptionsCount(question.getBaseQuestion().getMaxSelectedOptionsCount());
        questionDTO.setQuestion(question.getBaseQuestion().getQuestion());
        questionDTO.setOptions(question.getOptions().stream().map(optionMapper::toDTO).collect(Collectors.toList()));
        return  questionDTO;
    }
}
