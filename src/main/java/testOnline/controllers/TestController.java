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
    private TestsService testsService;

    @GetMapping("/get/all")
    public List<TestDTO> GetAll(){
        return testsService.getAllTests();
    }

    @GetMapping("/get/{id}/getAllQuestions")
    public List<QuestionOfTestDTO> GetAllQuestions(@PathVariable("id") long id){
        return testsService.getAllQuestions(id);
    }

    @GetMapping("/get/{id}/getQuestion/{questionId}/getAllOptions")
    public List<OptionOfQuestionDTO> GetAllOptions(@PathVariable("id") long id,@PathVariable("questionId") long qid){
        return testsService.getAllOptions();
    }

    @PostMapping("/add")
    public TestDTO AddTest(@Valid @RequestBody TestDTO dto){
        return testsService.AddTest(dto);
    }

    @PostMapping("get/{id}/delete")
    public void RemoveTest(@PathVariable("id") long id){
        testsService.RemoveTest(id);
    }

    @PostMapping("get/{id}/edit")
    public void EditTest(@PathVariable("id") long id, EditTestDTO dto){
        testsService.EditTest(id, dto);
    }

    @PostMapping("get/{id}/addQuestion")
    public void AddQuestion(@PathVariable("id") long id, @Valid @RequestBody QuestionOfTestDTO dto){
        testsService.AddQuestion(id, dto);
    }

    @PostMapping("get/{id}/getQuestion/{questionId}/edit")
    public void EditQuestion(@PathVariable("questionId") long qid,QuestionOfTestDTO dto){
        testsService.EditQuestion(qid,dto);
    }

    @PostMapping("get/{id}/getQuestion/{questionId}/delete")
    public void RemoveQuestion( @PathVariable("questionId") long qid){
        testsService.RemoveQuestion(qid);
    }

    @PostMapping("get/{id}/getQuestion/{questionId}/addOption")
    public void AddOption(@PathVariable("questionId") long qid, @Valid @RequestBody OptionOfQuestionDTO dto){
        testsService.AddOption(qid,dto);
    }

    @PostMapping("get/{id}/getQuestion/{questionId}/getOption/{optionId}/edit")
    public void EditOption(@PathVariable("optionId") long oid, OptionOfQuestionDTO dto){
        testsService.EditOption(oid,dto);
    }

    @PostMapping("get/{id}/getQuestion/{questionId}/getOption/{optionId}/remove")
    public void RemoveOption(@PathVariable("optionId") long oid){
        testsService.RemoveOption(oid);
    }
}
