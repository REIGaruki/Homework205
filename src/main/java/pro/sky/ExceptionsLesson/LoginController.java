package pro.sky.ExceptionsLesson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginPasswordConfirmation loginPasswordConfirmation;

    public LoginController(LoginPasswordConfirmation loginPasswordConfirmation) {
        this.loginPasswordConfirmation = loginPasswordConfirmation;
    }
    String login = "&^%$$$";
    String password = "qwerty1234";
    String confirmPassword = "qwerty1234";
    @GetMapping(path = "/login")
    public String login(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        loginPasswordConfirmation.confirmLoginPassword(login, password, confirmPassword);
        return login + ' ' + password + ' ' + confirmPassword;
    }
}
