package testOnline.service;

import testOnline.dto.LoggedDTO;

public interface AuthService {
    LoggedDTO login(String login, String password);
    LoggedDTO register(String login, String password);
}
