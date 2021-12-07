package testOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.LoggedDTO;
import testOnline.entity.User;
import testOnline.entity.enumeration.UserRole;
import testOnline.exceptions.BadRequesException;
import testOnline.repositories.UserRepository;
import testOnline.service.AuthService;

@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtTokenService jwtService;


    @Override
    public LoggedDTO login(String login, String password) {
        var user = userRepo.findByLoginAndPasswordHash(login, password);
        if (user == null)
            throw new BadRequesException("Incorrect login or password!");
        return jwtService.login(user);
    }

    @Override
    public LoggedDTO register(String login, String password) {
        if (userRepo.existsByLogin(login))
            throw new BadRequesException("Login is already in use!");
        var user = userRepo.save(new User(login, password, UserRole.USER));
        return jwtService.login(user);
    }
}
