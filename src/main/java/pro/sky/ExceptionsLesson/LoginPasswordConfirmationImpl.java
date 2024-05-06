package pro.sky.ExceptionsLesson;

import org.springframework.stereotype.Service;

@Service
public class LoginPasswordConfirmationImpl implements LoginPasswordConfirmation{
    @Override
    public boolean confirmLoginPassword(String login, String password, String confirmPassword) {
        return false;
    }
}
