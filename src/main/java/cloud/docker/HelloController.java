package cloud.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    private static List<String> list = new ArrayList<>();
    private static Integer num = -1;

    @GetMapping("/")
    public String hello() {



        num += 1;
        num %= 11;
        return list.get(num);
    }
}
