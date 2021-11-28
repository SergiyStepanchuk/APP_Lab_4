package testOnline.mappers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.QuestionOfTestDTO;
import testOnline.entity.QuestionOfTest;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class QuestionOfTestToQuestionOfTestDTOMapper {
@Autowired private OptionOfQuestionToOptionOfQuestionDTOMapper optionMapper;
    public QuestionOfTest toEntity(final QuestionOfTestDTO questionDTO) {
        final var question = new QuestionOfTest();

        question.setId(questionDTO.getId());
        question.setOptions(new HashSet<>(questionDTO.getOptions().stream().map(optionMapper::toEntity).collect(Collectors.toList())));
        question.setQuestion(questionDTO.getQuestion());
        question.setMaxOptionsCount(questionDTO.getMaxOptionsCount());
        question.setMaxSelectedOptionsCount(questionDTO.getMaxSelectedOptionsCount());

        return question;
    }
    public  QuestionOfTestDTO toDTO(final QuestionOfTest question){
        final var questionDTO = new QuestionOfTestDTO();

        questionDTO.setId(question.getId());
        questionDTO.setOptions(question.getOptions().stream().map(optionMapper::toDTO).collect(Collectors.toList()));
        questionDTO.setQuestion(question.getQuestion());
        questionDTO.setMaxOptionsCount(question.getMaxOptionsCount());
        questionDTO.setMaxSelectedOptionsCount(question.getMaxSelectedOptionsCount());

        return questionDTO;
    }
}










