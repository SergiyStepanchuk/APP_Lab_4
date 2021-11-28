package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {
    private long id;

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

    @Size(min = 1, max = 200)
    @Valid
    private List<QuestionOfTestDTO> questions;
}
