package testOnline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Entity
@EnableAutoConfiguration
@Table(name = "ActiveRefreshTokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveRefreshToken {
    @Id
    private String jti;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date expire;
}
