package testOnline.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.TestDTO;
import testOnline.entity.Test;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class TestToTestDTOMapper {
    @Autowired private QuestionOfTestToQuestionOfTestDTOMapper questionMapper;

    public Test toEntity(final TestDTO testDTO){
        final var test = new Test();

        test.setId(testDTO.getId());
        test.setName(testDTO.getName());
        test.setDescription(testDTO.getDescription());
        test.setMaxCountOfQuestions(testDTO.getMaxCountOfQuestions());
        test.setTestLengthInMinuts(testDTO.getTestLengthInMinuts());
        test.setQuestions(new HashSet<>(testDTO.getQuestions().stream().map(questionMapper::toEntity).map(q -> {
            q.setTest(test);
            return q;
        }).collect(Collectors.toList())));

        return test;
    }

    public TestDTO toDTO(final Test test){
        final var testDTO = new TestDTO();

        testDTO.setId(test.getId());
        testDTO.setName(test.getName());
        testDTO.setDescription(test.getDescription());
        testDTO.setMaxCountOfQuestions(test.getMaxCountOfQuestions());
        testDTO.setTestLengthInMinuts(test.getTestLengthInMinuts());
        testDTO.setQuestions(test.getQuestions().stream().map(questionMapper::toDTO).collect(Collectors.toList()));

        return testDTO;
    }
}
