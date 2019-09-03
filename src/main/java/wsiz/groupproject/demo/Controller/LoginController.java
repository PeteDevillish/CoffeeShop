package wsiz.groupproject.demo.Controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wsiz.groupproject.demo.model.User;


@RestController
public class LoginController {
    @RequestMapping("/user")
    public User user(@AuthenticationPrincipal User principal) {
        return principal;
    }
}

