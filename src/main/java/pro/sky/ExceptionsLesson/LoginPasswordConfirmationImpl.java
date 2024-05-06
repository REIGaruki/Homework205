package pro.sky.ExceptionsLesson;

import org.springframework.stereotype.Service;

@Service
public class LoginPasswordConfirmationImpl implements LoginPasswordConfirmation {
    @Override
    public void confirmLoginPassword(String login, String password, String confirmPassword) {
        if (confirmAllowedChars(login)) {
            System.out.println("login is good");
        }
        if (confirmAllowedChars(password)) {
            System.out.println("password is good");
        }
        if (confirmAllowedChars(confirmPassword)) {
            System.out.println("confirmPassword is good");
        }
        if (password.equals(confirmPassword)) {
            System.out.println("Password confirmed");
        }

    }

    public boolean confirmAllowedChars(String string) {
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