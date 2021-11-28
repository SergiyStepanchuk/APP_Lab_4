package testOnline.mappers;

import org.springframework.stereotype.Component;
import testOnline.dto.session.OptionOfQuestionInSessionDTO;
import testOnline.entity.session.OptionOfQuestionInSession;

@Component
public class OptionOfQuestionInSessionToOptionOfQuestionInSessionDTOMapper {
    public OptionOfQuestionInSessionDTO toDTO(final OptionOfQuestionInSession option){

        final var optionDTO = new OptionOfQuestionInSessionDTO();

        optionDTO.setId(option.getId());
        optionDTO.setSelected(option.isSelected());
//        optionDTO.setCorrect(option.is);
        optionDTO.setAnswer(option.getBaseOption().getAnswer());
        return optionDTO;
    }
}
