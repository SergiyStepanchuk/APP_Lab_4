package testOnline.mappers;

import org.springframework.stereotype.Component;
import testOnline.dto.OptionOfQuestionDTO;
import testOnline.entity.OptionOfQuestion;

@Component
public class OptionOfQuestionToOptionOfQuestionDTOMapper {
    public OptionOfQuestion toEntity(final OptionOfQuestionDTO optionDTO){
        final var option = new OptionOfQuestion();

        option.setId(optionDTO.getId());
        option.setAnswer(optionDTO.getAnswer());
        option.setCorrect(optionDTO.isCorrect());

        return option;
    }

    public OptionOfQuestionDTO toDTO(final OptionOfQuestion option){
        final var optionDTO = new OptionOfQuestionDTO();

        optionDTO.setId(option.getId());
        optionDTO.setAnswer(option.getAnswer());
        optionDTO.setCorrect(option.isCorrect());

        return optionDTO;
    }
}
