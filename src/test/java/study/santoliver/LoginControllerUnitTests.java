package study.santoliver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import study.santoliver.controllers.LoginController;
import study.santoliver.model.LoginProcessor;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTests {

    @Mock
    private Model model;

    @Mock
    private LoginProcessor loginProcessor;

    @InjectMocks
    private LoginController loginController;

    @Test
    public void loginPostLoginSucceedsTest() {
        given(loginProcessor.login()).willReturn(true);

        String result = loginController.loginPost("username", "password", model);

        assertEquals("login.html", result);

        verify(model).addAttribute("message", "You are now logged in.");
    }

}
