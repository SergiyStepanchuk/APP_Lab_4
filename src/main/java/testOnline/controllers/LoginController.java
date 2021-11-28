package testOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testOnline.dto.UserDTO;
import testOnline.mappers.UserToUserDTOMapper;
import testOnline.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @Autowired
    private UserRepository repo;

    @Autowired
    private UserToUserDTOMapper userMapper;

    @GetMapping("/users")
    public List<UserDTO> listAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false).map(userMapper::toDTO).collect(Collectors.toList());
    }

}
