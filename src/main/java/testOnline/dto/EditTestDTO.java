package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditTestDTO {
    @Size(min = 1, max = 100)
    private String name;

    @Size(min = 1, max = 500)
    private String description;

    private Optional<@Min(1) @Max(100) Integer> maxCountOfQuestions;

    private Optional<@Min(5) @Max(120) Integer> testLengthInMinuts;
}


