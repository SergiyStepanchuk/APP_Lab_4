package testOnline.mappers;

import org.springframework.stereotype.Component;
import testOnline.dto.session.OptionOfQuestionInSessionDTO;
import testOnline.entity.session.OptionOfQuestionInSession;

import java.util.Date;
import java.util.Optional;

@Component
public class OptionOfQuestionInSessionToOptionOfQuestionInSessionDTOMapper {
    public OptionOfQuestionInSessionDTO toDTO(final OptionOfQuestionInSession option){
        final var optionDTO = new OptionOfQuestionInSessionDTO();

        optionDTO.setId(option.getId());
        optionDTO.setSelected(option.isSelected());
        optionDTO.setAnswer(option.getBaseOption().getAnswer());

        if (option.getQuestion().getSession().getEndDateTime() != null ||
                new Date().getTime() >
                    option.getQuestion().getSession().getStartDateTime().getTime() +
                            (long) option.getQuestion().getSession().getTest().getTestLengthInMinuts() * 60 * 1000)
            optionDTO.setCorrect(Optional.of(option.getBaseOption().isCorrect() == option.isSelected()));
        return optionDTO;
    }
}
