package org.hotelsimulator.utils;

import org.hotelsimulator.views.ProjectFrame;

import java.util.ArrayList;

public class FrameStack {

    private static FrameStack instance;
    private ArrayList<ProjectFrame> stack;

    private FrameStack() {
        stack = new ArrayList<ProjectFrame>();
    }

    public static FrameStack getInstance() {
        if (instance == null) {
            instance = new FrameStack();
        }
        return instance;
    }

    public ProjectFrame peek() {
        return stack.get(0);
    }

    public void push(ProjectFrame frame) {
        if (!stack.isEmpty()) {
            peek().setVisible(false);
        }
        frame.setVisible(true);
        stack.add(0, frame);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            peek().dispose();
            stack.remove(0);
            if (!stack.isEmpty()) {
                peek().setVisible(true);
            }
        }
    }
}
