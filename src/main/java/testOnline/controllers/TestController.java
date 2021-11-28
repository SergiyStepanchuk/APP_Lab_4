package testOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testOnline.dto.TestDTO;
import testOnline.service.TestsService;

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
    public TestDTO AddUser(@Valid @RequestBody TestDTO dto){
        return dto;
    }
}
