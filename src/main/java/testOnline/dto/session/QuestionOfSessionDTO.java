package testOnline.dto.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionOfSessionDTO {
    private long id;
    private int maxSelectedOptionsCount;
    private int maxOptionsCount;
    private String question;
    private List<OptionOfQuestionInSessionDTO> options;
}
