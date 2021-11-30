package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditTestDTO {
    @NotEmpty()
    private String name;

    @NotEmpty()
    private String description;

    @Min(1)
    @Max(100)
    private int maxCountOfQuestions;

    @Min(5)
    @Max(120)
    private int testLengthInMinuts;
}


