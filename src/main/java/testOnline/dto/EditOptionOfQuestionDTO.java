package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditOptionOfQuestionDTO {
    @NotEmpty()
    private Optional<String> answer;
    @NotNull()
    private Optional<Boolean> correct;
}
