package testOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testOnline.annotation.AutorizeFilter;
import testOnline.dto.LoggedDTO;
import testOnline.dto.LoginDTO;
import testOnline.dto.RefreshTokenDTO;
import testOnline.dto.RegisterDTO;
import testOnline.entity.enumeration.AutorizeFilterTypes;
import testOnline.service.AuthService;
import testOnline.service.impl.JwtTokenService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/auth")
    @AutorizeFilter(vType = AutorizeFilterTypes.NOT_AUTORIZED)
    public LoggedDTO auth(@Valid @RequestBody LoginDTO dto) {
        return authService.login(dto.getLogin(), dto.getPassword());
    }

    @PostMapping("/refresh-token")
    public LoggedDTO auth(@Valid @RequestBody RefreshTokenDTO dto) throws Exception {
        return jwtTokenService.refreshToken(jwtTokenService.decodeRefreshToken(dto.getToken()));
    }

    @PostMapping("/register")
    @AutorizeFilter(vType = AutorizeFilterTypes.NOT_AUTORIZED)
    public LoggedDTO register(@Valid @RequestBody RegisterDTO dto) {
        return authService.register(dto.getLogin(), dto.getPassword());
    }
}
