package gdsc.com.firststep.login.dto;

import gdsc.com.firststep.post.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String token;
	private String userId;
	private String nickname;
	private String password;
	private String Id;
	private int age;
}
