package testOnline.service;

import testOnline.dto.*;

import java.util.List;

public interface TestsService {
    List<TestDTOMinimized>      getAllTestsMinimized();

    TestDTO                     getFullTestById(long id);

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
    QuestionOfTestDTO           EditQuestion(long qid, EditQuestionOfTestDTO dto);
    OptionOfQuestionDTO         EditOption(long oid, EditOptionOfQuestionDTO dto);

}
