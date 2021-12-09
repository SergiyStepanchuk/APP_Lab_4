package testOnline.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditQuestionOfTestDTO {
    private Optional<String> question;
    @Min(1)
    @Max(100)
    public Optional<Integer> maxSelectedOptionsCount;
    @Min(5)
    @Max(120)
    public Optional<Integer> maxOptionsCount;
}
