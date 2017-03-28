package com.asymmetrik.challenges.device.keyboard;

import javax.swing.*;

/**
 * The main class for the demo application.
 */
public class MainApp {

    public static void main(String[] args) {
        new MainApp();
    }

    public MainApp() {

        JFrame app = new JFrame("Keyboard Autocomplete Demo");

        DeviceKeyboard form = new DeviceKeyboard();
        app.setContentPane(form.mainPanel);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setSize(600, 450);
        app.setLocationRelativeTo(null);

        app.setVisible(true);
    }

}