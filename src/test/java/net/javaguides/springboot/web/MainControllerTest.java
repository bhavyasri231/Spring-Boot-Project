package net.javaguides.springboot.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainControllerTest {

    @Test
    void login() {
        MainController mainController = new MainController();
        String response = mainController.login();
        Assertions.assertEquals("login",response);

    }

    @Test
    void home() {
        MainController mainController = new MainController();
        String response = mainController.home();
        Assertions.assertEquals("index",response);
    }
}