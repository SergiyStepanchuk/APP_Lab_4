package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDTOMinimized {
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
}
