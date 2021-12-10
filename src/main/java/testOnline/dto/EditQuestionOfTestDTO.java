package testOnline.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditQuestionOfTestDTO {
    @Size(min = 1, max = 500)
    private String question;

    private Optional<@Min(1) @Max(100)Integer> maxSelectedOptionsCount;

    private Optional<@Min(5) @Max(120)Integer> maxOptionsCount;
}
