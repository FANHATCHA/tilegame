package com.gaming.display;

import javax.swing.*;
import java.awt.*;

public class Display {
    //Reference variable
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int height, width;

    //Constructor
    public Display(String title, int height, int width){

        this.title = title;
        this.height = height;
        this.width = width;
        createDisplay();

    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(height, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();

    }

    public Canvas getCanvas(){
        return canvas;
    }
}
