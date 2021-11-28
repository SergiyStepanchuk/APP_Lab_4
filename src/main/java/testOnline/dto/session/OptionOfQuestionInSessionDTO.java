package testOnline.dto.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionOfQuestionInSessionDTO {
    private long id;
    private String answer;
    private boolean selected;
    private boolean correct;
}
