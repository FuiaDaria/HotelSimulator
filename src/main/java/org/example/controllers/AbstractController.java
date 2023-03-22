package org.example.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.example.views.ProjectFrame;
import org.example.utils.FrameStack;

public class AbstractController {

    protected ProjectFrame frame;

    public AbstractController(ProjectFrame frame, boolean hasBackButton) {
        this.frame = frame;
        if (hasBackButton) {
            frame.setBackButtonActionListener(new BackButtonListener());
        }

    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameStack.getInstance().pop();
        }
    }
}
