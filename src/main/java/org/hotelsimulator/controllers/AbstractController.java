package org.hotelsimulator.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hotelsimulator.views.ProjectFrame;
import org.hotelsimulator.utils.FrameStack;

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
