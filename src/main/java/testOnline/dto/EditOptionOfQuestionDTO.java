package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditOptionOfQuestionDTO {
    @Size(min = 1, max = 500)
    private String answer;
    private Optional<Boolean> correct;
}
