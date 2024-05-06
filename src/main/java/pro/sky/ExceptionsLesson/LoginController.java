package pro.sky.ExceptionsLesson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @GetMapping(path = "/login")
    public String login(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        confirmLoginPassword(login, password, confirmPassword);
        return login + ' ' + password + ' ' + confirmPassword;
    }

    public static void confirmLoginPassword(String login, String password, String confirmPassword) {
        if (!confirmAllowedChars(login)) {
            throw new WrongLoginException("Login is too long or contains unallowed symbols");
        }
        if (!confirmAllowedChars(password)) {
            throw new WrongPasswordException("Password is too long or contains unallowed symbols");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password is not confirmed");
        }
    }

    public static boolean confirmAllowedChars(String string) {
        boolean confirmed = true;
        if (string.toCharArray().length <= 20) {
            String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789_";
            for (char a : string.toLowerCase().toCharArray()) {
                if (confirmed) {
                    for (char b : allowedChars.toCharArray()) {
                        if (a == b) {
                            confirmed = true;
                            break;
                        }
                        confirmed = false;
                    }
                }
            }
        } else {
            confirmed = false;
        }
        return confirmed;
    }
}
