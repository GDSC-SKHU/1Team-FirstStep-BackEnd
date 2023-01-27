package gdsc.com.firststep.login.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "userid")})
public class User {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String Id; // 유저에게 고유하게 부여되는 id.

    @Column(nullable = false)
    private String nickname; // 유저의 이름

    @Column(nullable = false)
    private String userId; // 유저의 아이디

    @Column(nullable = false)
    private String password; // 패스워드

    @Column(nullable = false)
    private int age; // 나이

}
