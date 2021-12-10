package testOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.*;
import testOnline.entity.QuestionOfTest;
import testOnline.entity.Test;
import testOnline.mappers.OptionOfQuestionToOptionOfQuestionDTOMapper;
import testOnline.mappers.QuestionOfTestToQuestionOfTestDTOMapper;
import testOnline.mappers.TestToTestDTOMapper;
import testOnline.mappers.TestToTestDTOMinimizedMapper;
import testOnline.repositories.OptionOfQuestionRepository;
import testOnline.repositories.QuestionOfTestRepository;
import testOnline.repositories.TestsRepository;
import testOnline.service.TestsService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestsServiceImpl implements TestsService {
    @Autowired private TestsRepository repo;
    @Autowired private QuestionOfTestRepository qrepo;
    @Autowired private OptionOfQuestionRepository orepo;

    @Autowired private TestToTestDTOMapper testToTestDTOMapper;
    @Autowired private TestToTestDTOMinimizedMapper testToTestDTOMinimizedMapper;
    @Autowired private QuestionOfTestToQuestionOfTestDTOMapper questionToQuestionDTOMapper;
    @Autowired private OptionOfQuestionToOptionOfQuestionDTOMapper optionToOptionDTOMapper;

    public List<TestDTOMinimized> getAllTestsMinimized()
    {
        return repo.findAll().stream().map(testToTestDTOMinimizedMapper::toDTO).collect(Collectors.toList());
    }

    public TestDTO getFullTestById(long id)
    {
        return testToTestDTOMapper.toDTO(repo.findById(id).get());
    }

    public List<TestDTO> getAllTests() {
        return repo.findAllWithData().stream().map(testToTestDTOMapper::toDTO).collect(Collectors.toList());
    }

    public List<QuestionOfTestDTO> getAllQuestions(long testId) {
        return qrepo.findAllByTestId(testId).stream().map(questionToQuestionDTOMapper::toDTO).collect(Collectors.toList());
    }

    public List<OptionOfQuestionDTO> getAllOptions(long questionId) {
        return orepo.findAllByQuestionId(questionId).stream().map(optionToOptionDTOMapper::toDTO).collect(Collectors.toList());
    }

    public TestDTO AddTest(TestDTO dto){
       return testToTestDTOMapper.toDTO(repo.save(testToTestDTOMapper.toEntity(dto)));
    }

    public void RemoveTest(long id){
        repo.deleteById(id);
    }

    public TestDTO EditTest(long id, EditTestDTO dto){
       var a = repo.findById(id).get();
       if (dto.getDescription() != null)
           a.setDescription(dto.getDescription());
       if (dto.getName() != null)
           a.setName(dto.getName());
       if (dto.getMaxCountOfQuestions() != null && !dto.getMaxCountOfQuestions().isEmpty())
            a.setMaxCountOfQuestions(dto.getMaxCountOfQuestions().get());
        if (dto.getTestLengthInMinuts() != null && !dto.getTestLengthInMinuts().isEmpty())
            a.setTestLengthInMinuts(dto.getTestLengthInMinuts().get());
       return testToTestDTOMapper.toDTO(repo.save(a));
    }

    public QuestionOfTestDTO AddQuestion(long id, QuestionOfTestDTO dto){
        var a = questionToQuestionDTOMapper.toEntity(dto);
        var t =  new Test();
        t.setId(id);
        a.setTest(t);
        return questionToQuestionDTOMapper.toDTO(qrepo.save(a));
    }

    public QuestionOfTestDTO EditQuestion(long qid, EditQuestionOfTestDTO dto){
        var a = qrepo.findById(qid).get();
        if(dto.getQuestion() != null)
            a.setQuestion(dto.getQuestion());
        if(dto.getMaxSelectedOptionsCount() != null && !dto.getMaxSelectedOptionsCount().isEmpty())
            a.setMaxSelectedOptionsCount(dto.getMaxSelectedOptionsCount().get());
        if(dto.getMaxOptionsCount() != null && !dto.getMaxOptionsCount().isEmpty())
            a.setMaxOptionsCount(dto.getMaxOptionsCount().get());
        return questionToQuestionDTOMapper.toDTO(qrepo.save(a));
    }

    public void RemoveQuestion(long qid){
        qrepo.deleteById(qid);
    }

    public OptionOfQuestionDTO AddOption(long qid, OptionOfQuestionDTO dto){
        var a = optionToOptionDTOMapper.toEntity(dto);
        var q = new QuestionOfTest();
        q.setId(qid);
        a.setQuestion(q);
        return optionToOptionDTOMapper.toDTO(orepo.save(a));
    }

    public OptionOfQuestionDTO EditOption(long oid,EditOptionOfQuestionDTO dto){
        var a = orepo.findById(oid).get();
        if(dto.getAnswer() != null)
            a.setAnswer(dto.getAnswer());
        if(dto.getCorrect() != null && !dto.getCorrect().isEmpty())
            a.setCorrect(dto.getCorrect().get());
        return optionToOptionDTOMapper.toDTO(orepo.save(a));
    }

    public void RemoveOption(long oid){
        orepo.deleteById(oid);
    }
}
