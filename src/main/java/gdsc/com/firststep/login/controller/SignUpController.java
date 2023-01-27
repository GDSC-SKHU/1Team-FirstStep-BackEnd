package gdsc.com.firststep.login.controller;

import gdsc.com.firststep.login.domain.User;
import gdsc.com.firststep.login.dto.UserDTO;
import gdsc.com.firststep.login.dto.UserResponseDTO;
import gdsc.com.firststep.login.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping()
public class SignUpController {
    @Autowired
    private UserService userService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            // 리퀘스트를 이용해 저장할 유저 만들기
            User user = User.builder()
                    .userId(userDTO.getUserId())
                    .nickname(userDTO.getNickname())
                    .age(userDTO.getAge())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .build();
            // 서비스를 이용해 리파지토리에 유저 저장
            User registeredUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .userId(registeredUser.getUserId())
                    .Id(registeredUser.getId())
                    .nickname(registeredUser.getNickname())
                    .age(registeredUser.getAge())
                    .build();
            // 유저 정보는 항상 하나이므로 그냥 리스트로 만들어야하는 ResponseDTO를 사용하지 않고 그냥 UserDTO 리턴.
            return ResponseEntity.ok(responseUserDTO);
        } catch (Exception e) {
            // 예외가 나는 경우 bad 리스폰스 리턴.
            UserResponseDTO responseDTO = UserResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }
}
