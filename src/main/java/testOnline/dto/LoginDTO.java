package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    @NotEmpty()
    @Size(min=1, max=50)
    private String login;
    @NotEmpty()
    @Size(min=1, max=50)
    private String password;
}
