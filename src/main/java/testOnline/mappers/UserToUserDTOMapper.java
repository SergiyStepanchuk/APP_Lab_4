package testOnline.mappers;

import org.springframework.stereotype.Component;
import testOnline.dto.UserDTO;
import testOnline.entity.User;

@Component
public class UserToUserDTOMapper {
    public User toEntity(final UserDTO userDTO){
        final User user = new User();

        user.setId(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setRole(userDTO.getRole());

        return user;
    }

    public UserDTO toDTO(final User user){
        final UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setRole(user.getRole());

        return userDTO;
    }
}
