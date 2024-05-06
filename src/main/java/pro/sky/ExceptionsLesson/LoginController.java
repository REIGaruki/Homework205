package pro.sky.ExceptionsLesson;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginPasswordConfirmation loginPasswordConfirmation;

    public LoginController(LoginPasswordConfirmation loginPasswordConfirmation) {
        this.loginPasswordConfirmation = loginPasswordConfirmation;
    }
}
