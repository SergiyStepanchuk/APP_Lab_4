package testOnline.service;

import testOnline.dto.EditTestDTO;
import testOnline.dto.OptionOfQuestionDTO;
import testOnline.dto.QuestionOfTestDTO;
import testOnline.dto.TestDTO;

import java.util.List;

public interface TestsService {
    List<TestDTO>               getAllTests();
    List<QuestionOfTestDTO>     getAllQuestions(long testId);
    List<OptionOfQuestionDTO>   getAllOptions(long questionId);

    TestDTO                     AddTest(TestDTO dto);
    QuestionOfTestDTO           AddQuestion(long id, QuestionOfTestDTO dto);
    OptionOfQuestionDTO         AddOption(long qid,  OptionOfQuestionDTO dto);

    void                        RemoveTest(long id);
    void                        RemoveQuestion(long qid);
    void                        RemoveOption(long oid);

    TestDTO                     EditTest(long id, EditTestDTO dto);
    QuestionOfTestDTO           EditQuestion(long qid, QuestionOfTestDTO dto);
    OptionOfQuestionDTO         EditOption(long oid, OptionOfQuestionDTO dto);

}
