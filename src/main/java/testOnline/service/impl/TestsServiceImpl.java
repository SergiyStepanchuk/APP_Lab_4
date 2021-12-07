package testOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.EditTestDTO;
import testOnline.dto.OptionOfQuestionDTO;
import testOnline.dto.QuestionOfTestDTO;
import testOnline.dto.TestDTO;
import testOnline.entity.QuestionOfTest;
import testOnline.entity.Test;
import testOnline.mappers.OptionOfQuestionToOptionOfQuestionDTOMapper;
import testOnline.mappers.QuestionOfTestToQuestionOfTestDTOMapper;
import testOnline.mappers.TestToTestDTOMapper;
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
    @Autowired private QuestionOfTestToQuestionOfTestDTOMapper questionToQuestionDTOMapper;
    @Autowired private OptionOfQuestionToOptionOfQuestionDTOMapper optionToOptionDTOMapper;

    public List<TestDTO> getAllTests() {
        return repo.findAllWithData().stream().map(testToTestDTOMapper::toDTO).collect(Collectors.toList());
    }
    @Deprecated
    public List<QuestionOfTestDTO> getAllQuestions() {
        return qrepo.findAll().stream().map(questionToQuestionDTOMapper::toDTO).collect(Collectors.toList());
    }
    @Deprecated
    public List<OptionOfQuestionDTO> getAllOptions() {
        return orepo.findAll().stream().map(optionToOptionDTOMapper::toDTO).collect(Collectors.toList());
    }
    public TestDTO AddTest(TestDTO dto){
       return testToTestDTOMapper.toDTO(repo.save(testToTestDTOMapper.toEntity(dto)));
    };
    public void RemoveTest(long id){
        repo.deleteById(id);
    }

    public TestDTO EditTest(long id, EditTestDTO dto){
       var a = repo.findById(id).get();
       a.setDescription(dto.getDescription());
       a.setName(dto.getName());
       a.setMaxCountOfQuestions(dto.getMaxCountOfQuestions());
       a.setTestLengthInMinuts(dto.getTestLengthInMinuts());
       return testToTestDTOMapper.toDTO(repo.save(a));
    }
    public QuestionOfTestDTO AddQuestion(long id, QuestionOfTestDTO dto){
        var a = questionToQuestionDTOMapper.toEntity(dto);
        var t =  new Test();
        t.setId(id);
        a.setTest(t);
        return questionToQuestionDTOMapper.toDTO(qrepo.save(a));
    }
    public QuestionOfTestDTO EditQuestion(long qid, QuestionOfTestDTO dto){
        var a = qrepo.findById(qid).get();
        a.setQuestion(dto.getQuestion());
        a.setMaxSelectedOptionsCount(dto.getMaxSelectedOptionsCount());
        a.setMaxOptionsCount(dto.getMaxOptionsCount());
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
    public OptionOfQuestionDTO EditOption(long oid,OptionOfQuestionDTO dto){
        var a = orepo.findById(oid).get();
        a.setAnswer(dto.getAnswer());
        a.setCorrect(dto.isCorrect());
        return optionToOptionDTOMapper.toDTO(orepo.save(a));
    }
    public void RemoveOption(long oid){
        orepo.deleteById(oid);
    }
}
