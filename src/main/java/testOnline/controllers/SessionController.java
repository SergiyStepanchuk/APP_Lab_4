package testOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testOnline.annotation.AutorizeFilter;
import testOnline.annotation.AutorizeUser;
import testOnline.dto.SetQuestionOptionDTO;
import testOnline.dto.session.OptionOfQuestionInSessionDTO;
import testOnline.dto.session.SessionOfTestDTO;
import testOnline.entity.User;
import testOnline.entity.enumeration.UserRole;
import testOnline.service.SessionService;

@RestController
@RequestMapping("/api/v1/session")
@AutorizeFilter
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping("/start")
    public SessionOfTestDTO startNewSession(@RequestParam("testId") long testId, @AutorizeUser User user){
        return sessionService.startNewSession(user, testId);
    }

    @GetMapping("/get")
    public SessionOfTestDTO getSessionById(@RequestParam("id") long id, @AutorizeUser User user){
        return sessionService.getById(user, id);
    }

    @PostMapping("/set-question-option")
    public OptionOfQuestionInSessionDTO setQuestionOption(@RequestBody SetQuestionOptionDTO dto, @AutorizeUser User user){
        return sessionService.setQuestionOption(user, dto.getOptionId(), dto.isSelection());
    }

    @PostMapping("/end")
    public SessionOfTestDTO endSessionById(@RequestParam("id") long id, @AutorizeUser User user){
        return sessionService.endSessionById(user, id);
    }
}
