package testOnline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionOfTestDTO {
    private long id;

    @NotEmpty()
    private String question;

    @Min(1)
    @Max(4)
    private int maxSelectedOptionsCount;
    @Min(1)
    @Max(6)
    private int maxOptionsCount;

    @Size(min=1, max=10)
    @Valid
    private List<OptionOfQuestionDTO> options;
}
