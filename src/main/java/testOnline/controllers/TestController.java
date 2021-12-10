package testOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testOnline.annotation.AutorizeFilter;
import testOnline.dto.*;
import testOnline.entity.enumeration.UserRole;
import testOnline.service.TestsService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tests")
@AutorizeFilter(role = {UserRole.TEACHER, UserRole.ADMIN})
public class TestController {

    @Autowired
    private TestsService testsService;

    @AutorizeFilter
    @GetMapping("/get/all")
    public List<TestDTOMinimized> getAll(){
        return testsService.getAllTestsMinimized();
    }

    @GetMapping("/get")
    public TestDTO getOneFull(@RequestParam("id") long id){
        return testsService.getFullTestById(id);
    }

    @GetMapping("/getQuestions")
    public List<QuestionOfTestDTO> getAllQuestions(@RequestParam("testId") long testId){
        return testsService.getAllQuestions(testId);
    }

    @GetMapping("/getOptions")
    public List<OptionOfQuestionDTO> getAllOptions(@RequestParam("questionId") long questionId){
        return testsService.getAllOptions(questionId);
    }

    @PostMapping("/add")
    public TestDTO addTest(@Valid @RequestBody TestDTO dto){
        return testsService.AddTest(dto);
    }

    @PostMapping("/remove")
    public void removeTest(@RequestParam("id") long id){
        testsService.RemoveTest(id);
    }

    @PostMapping("/edit")
    public void editTest(@RequestParam("id") long id, @Valid @RequestBody EditTestDTO dto){
        testsService.EditTest(id, dto);
    }

    @PostMapping("/addQuestion")
    public void addQuestion(@RequestParam("testId") long testId, @Valid @RequestBody QuestionOfTestDTO dto){
        testsService.AddQuestion(testId, dto);
    }

    @PostMapping("/editQuestion")
    public void editQuestion(@RequestParam("id") long id, EditQuestionOfTestDTO dto){
        testsService.EditQuestion(id,dto);
    }

    @PostMapping("/deleteQuestion")
    public void removeQuestion(@RequestParam("id") long id){
        testsService.RemoveQuestion(id);
    }

    @PostMapping("/addOption")
    public void addOption(@RequestParam("questionId") long qid, @Valid @RequestBody OptionOfQuestionDTO dto){
        testsService.AddOption(qid, dto);
    }

    @PostMapping("/editOption")
    public void editOption(@RequestParam("optionId") long oid, EditOptionOfQuestionDTO dto){
        testsService.EditOption(oid, dto);
    }

    @PostMapping("/removeOption")
    public void removeOption(@RequestParam("optionId") long oid) {
        testsService.RemoveOption(oid);
    }
}
