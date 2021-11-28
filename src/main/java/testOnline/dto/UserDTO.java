package testOnline.dto;

import testOnline.entity.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    private String id;

    @NotBlank
    private String login;

    @NotBlank
    private UserRole role;
}
