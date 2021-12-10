package testOnline.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.TestDTO;
import testOnline.dto.TestDTOMinimized;
import testOnline.entity.Test;

@Component
public class TestToTestDTOMinimizedMapper {

    public Test toEntity(final TestDTOMinimized testDTO){
        final var test = new Test();

        test.setId(testDTO.getId());
        test.setName(testDTO.getName());
        test.setDescription(testDTO.getDescription());
        test.setMaxCountOfQuestions(testDTO.getMaxCountOfQuestions());
        test.setTestLengthInMinuts(testDTO.getTestLengthInMinuts());

        return test;
    }

    public TestDTOMinimized toDTO(final Test test){
        final var testDTO = new TestDTOMinimized();

        testDTO.setId(test.getId());
        testDTO.setName(test.getName());
        testDTO.setDescription(test.getDescription());
        testDTO.setMaxCountOfQuestions(test.getMaxCountOfQuestions());
        testDTO.setTestLengthInMinuts(test.getTestLengthInMinuts());

        return testDTO;
    }
}
