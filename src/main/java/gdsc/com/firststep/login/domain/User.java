package gdsc.com.firststep.login.domain;

import gdsc.com.firststep.post.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String Id; // 유저에게 고유하게 부여되는 id.

    @Column(nullable = false)
    private String nickname; // 유저의 별명

    @Column(nullable = false)
    private String userId; // 유저의 아이디

    @Column(nullable = false)
    private String password; // 패스워드

    @Column(nullable = false)
    private int age; // 나이



}
