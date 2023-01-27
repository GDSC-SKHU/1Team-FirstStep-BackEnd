package gdsc.com.firststep.login.controller;

import gdsc.com.firststep.login.domain.User;
import gdsc.com.firststep.login.dto.UserDTO;
import gdsc.com.firststep.login.dto.UserResponseDTO;
import gdsc.com.firststep.login.jwt.TokenProvider;
import gdsc.com.firststep.login.service.UserService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping
public class LoginController {
    //유저 서비스
    @Autowired
    private UserService userService;
    @Autowired
    private TokenProvider tokenProvider;

    // Bean으로 작성해도 됨.
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        User user = userService.getByCredentials(
                userDTO.getUserId(),
                userDTO.getPassword(),
                passwordEncoder);

        if(user != null) {
            // 토큰 생성
            final String token = tokenProvider.create(user);
            final UserDTO responseUserDTO = UserDTO.builder()
                    .userId(user.getUserId())
                    .token(token)
                    .age(user.getAge())
                    .nickname(user.getNickname())
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } else {
            UserResponseDTO responseDTO = UserResponseDTO.builder()
                    .error("Login failed.")
                    .build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }

}
