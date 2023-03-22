package org.example.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.example.views.MainFrame;
import org.example.views.*;
import org.example.models.*;

public class MainController extends AbstractController {
    public MainController(MainFrame frame, boolean hasBackButton) {
        super(frame, hasBackButton);
        //frame.dispose();
        frame.setSignInButtonActionListener(new SignInButtonActionListener());
        frame.setLogInButtonActionListener(new LogInButtonActionListener());
    }

    private class LogInButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            new TownController(new TownFrame("Towns"), false);

        }
    }

    private class SignInButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new LogController(new LogFrame("SIGN IN"), false);

        }
    }
}
