package testOnline.service;

import testOnline.dto.EditTestDTO;
import testOnline.dto.OptionOfQuestionDTO;
import testOnline.dto.QuestionOfTestDTO;
import testOnline.dto.TestDTO;

import java.util.List;

public interface TestsService {
    List<TestDTO> getAllTests();
    TestDTO AddTest(TestDTO dto);
    void RemoveTest(long id);
    TestDTO EditTest(long id, EditTestDTO dto);
    QuestionOfTestDTO AddQuestion(long id, QuestionOfTestDTO dto);
    QuestionOfTestDTO EditQuestion(long qid, long id, QuestionOfTestDTO dto);
    void RemoveQuestion(long qid, long id);
    OptionOfQuestionDTO AddOption(long qid, long id, OptionOfQuestionDTO dto);
    OptionOfQuestionDTO EditOption(long oid, long qid, long id, OptionOfQuestionDTO dto);
    public void RemoveOption(long oid, long qid, long id);
}
