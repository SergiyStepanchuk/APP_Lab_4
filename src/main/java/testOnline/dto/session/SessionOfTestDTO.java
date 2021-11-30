package testOnline.dto.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import testOnline.dto.TestDTO;
import testOnline.dto.UserDTO;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionOfTestDTO {
    private Long id;
    private UserDTO user;
    private TestDTO test;
    private Date startDateTime;
    private Date endDateTime;
    private List<QuestionOfSessionDTO> questions;
}
