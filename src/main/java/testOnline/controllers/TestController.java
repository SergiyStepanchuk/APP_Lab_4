package testOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testOnline.annotation.AutorizeFilter;
import testOnline.dto.*;
import testOnline.entity.OptionOfQuestion;
import testOnline.entity.QuestionOfTest;
import testOnline.entity.enumeration.UserRole;
import testOnline.service.TestsService;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tests")
@AutorizeFilter(role = {UserRole.TEACHER, UserRole.ADMIN})
public class TestController {

    @Autowired
    private TestsService testsService;

    @GetMapping("/get/all")
    public List<TestDTO> GetAll(){
        return testsService.getAllTests();
    }

    @GetMapping("/getQuestions")
    public List<QuestionOfTestDTO> GetAllQuestions(@RequestParam("testId") long testId){
        return testsService.getAllQuestions(testId);
    }

    @GetMapping("/getOptions")
    public List<OptionOfQuestionDTO> GetAllOptions(@RequestParam("questionId") long questionId){
        return testsService.getAllOptions(questionId);
    }

    @PostMapping("/addTest")
    public TestDTO AddTest(@Valid @RequestBody TestDTO dto){
        return testsService.AddTest(dto);
    }

    @PostMapping("/removeTest")
    public void RemoveTest(@RequestParam("id") long id){
        testsService.RemoveTest(id);
    }

    @PostMapping("/editTest")
    public void EditTest(@RequestParam("id") long id, @RequestBody EditTestDTO dto){
        testsService.EditTest(id, dto);
    }

    @PostMapping("/addQuestion")
    public void AddQuestion(@RequestParam("testId") long testId, @Valid @RequestBody QuestionOfTestDTO dto){
        testsService.AddQuestion(testId, dto);
    }

    @PostMapping("/editQuestion")
    public void EditQuestion(@RequestParam("id") long id, EditQuestionOfTestDTO dto){
        testsService.EditQuestion(id,dto);
    }

    @PostMapping("/deleteQuestion")
    public void RemoveQuestion(@RequestParam("id") long id){
        testsService.RemoveQuestion(id);
    }

    @PostMapping("/addOption")
    public void AddOption(@RequestParam("questionId") long qid, @Valid @RequestBody OptionOfQuestionDTO dto){
        testsService.AddOption(qid, dto);
    }

    @PostMapping("/editOption")
    public void EditOption(@RequestParam("optionId") long oid, EditOptionOfQuestionDTO dto){
        testsService.EditOption(oid, dto);
    }

    @PostMapping("/removeOption")
    public void RemoveOption(@RequestParam("optionId") long oid) {
        testsService.RemoveOption(oid);
    }
}
