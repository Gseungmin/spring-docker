package cloud.docker;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    /**
     * 유저의 존재 유무에 따라 이름 반환, 없으면 해당 유저는 없습니다 반환
     * */
    @GetMapping("/{name}")
    public String findMember(@PathVariable("name") String name) {

        Optional<User> user = userRepository.findByName(name);

        //유저가 없으면
        if (user.isEmpty()) {
            return "해당 유저는 없어요.";
        }

        return user.get().getName();
    }

    /**
     * 유저 저장
     * */
    @PostMapping("/{name}")
    public String addMember(@PathVariable("name") String name) {
        Optional<User> user = userRepository.findByName(name);

        //유저가 있으면
        if (user.isPresent()) {
            return "이미 해당 유저가 있어요.";
        }

        //해당 유저가 없으면
        User new_user = new User(name);
        userRepository.save(new_user);
        return "저장에 성공했어요.";
    }
}
