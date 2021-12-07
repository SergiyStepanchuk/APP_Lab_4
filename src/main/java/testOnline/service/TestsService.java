package testOnline.service;

import testOnline.dto.EditTestDTO;
import testOnline.dto.OptionOfQuestionDTO;
import testOnline.dto.QuestionOfTestDTO;
import testOnline.dto.TestDTO;

import java.util.List;

public interface TestsService {
    List<TestDTO> getAllTests();
    List<QuestionOfTestDTO> getAllQuestions(long testId);
    List<OptionOfQuestionDTO> getAllOptions();
    TestDTO AddTest(TestDTO dto);
    void RemoveTest(long id);
    TestDTO EditTest(long id, EditTestDTO dto);
    QuestionOfTestDTO AddQuestion(long id, QuestionOfTestDTO dto);
    QuestionOfTestDTO EditQuestion(long qid, QuestionOfTestDTO dto);
    void RemoveQuestion(long qid);
    OptionOfQuestionDTO AddOption(long qid,  OptionOfQuestionDTO dto);
    OptionOfQuestionDTO EditOption(long oid, OptionOfQuestionDTO dto);
    public void RemoveOption(long oid);
}
