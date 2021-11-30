package testOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testOnline.dto.EditTestDTO;
import testOnline.dto.OptionOfQuestionDTO;
import testOnline.dto.QuestionOfTestDTO;
import testOnline.dto.TestDTO;
import testOnline.entity.OptionOfQuestion;
import testOnline.entity.QuestionOfTest;
import testOnline.service.TestsService;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tests")
public class TestController {

    @Autowired
    private TestsService testsServie;

    @GetMapping("/get/all")
    public List<TestDTO> GetAll(){
        return testsServie.getAllTests();
    }

    @PostMapping("/add")
    public TestDTO AddTest(@Valid @RequestBody TestDTO dto){
        return dto;
    }

    @PostMapping("get/{id}/delete")
    public void RemoveTest(@PathVariable("id") long id){
        testsServie.RemoveTest(id);
    }
    @PostMapping("get/{id}/edit")
    public void EditTest(@PathVariable("id") long id, EditTestDTO dto){
        testsServie.EditTest(id, dto);
    }
    @PostMapping("get/{id}/addQuestion")
    public void AddQuestion(@PathVariable("id") long id, @Valid @RequestBody QuestionOfTestDTO dto){
        testsServie.AddQuestion(id, dto);
    }
    @PostMapping("get/{id}/getQuestion/{questionId}/edit")
    public void EditQuestion(@PathVariable("id") long id, @PathVariable("questionId") long qid,QuestionOfTestDTO dto){
        testsServie.EditQuestion(qid, id, dto);
    }
    @PostMapping("get/{id}/getQuestion/{questionId}/delete")
    public void RemoveQuestion(@PathVariable("id") long id, @PathVariable("questionId") long qid){
        testsServie.RemoveQuestion(qid, id);
    }
     @PostMapping("get/{id}/getQuestion/{questionId}/addOption")
    public void AddOption(@PathVariable("id") long id, @PathVariable("questionId") long qid, @Valid @RequestBody OptionOfQuestionDTO dto){
        testsServie.AddOption(qid, id, dto);
    }
    @PostMapping("get/{id}/getQuestion/{questionId}/getOption/{optionId}/edit")
    public void EditOption(@PathVariable("id") long id, @PathVariable("questionId") long qid, @PathVariable("optionId") long oid, OptionOfQuestionDTO dto){
        testsServie.EditOption(oid, qid, id, dto);
    }
    @PostMapping("get/{id}/getQuestion/{questionId}/getOption/{optionId}/remove")
    public void RemoveOption(@PathVariable("id") long id, @PathVariable("questionId") long qid, @PathVariable("optionId") long oid){
        testsServie.RemoveOption(oid, qid, id);
    }
}
