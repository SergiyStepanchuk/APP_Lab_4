package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionOfQuestionDTO {
    private long id;
    @NotEmpty()
    private String answer;
    @NotNull()
    private boolean correct;
}
