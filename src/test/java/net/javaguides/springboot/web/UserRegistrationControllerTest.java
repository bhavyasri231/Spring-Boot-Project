package net.javaguides.springboot.web;

import net.javaguides.springboot.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationControllerTest {

    @Autowired
    private UserService userService;


    @Test
    void showRegistrationForm() {
        UserRegistrationController userRegistrationController = new UserRegistrationController(userService);
        String response = userRegistrationController.showRegistrationForm();
        Assertions.assertEquals("registration",response);
    }


}