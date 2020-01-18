package com.gaming;

import com.gaming.display.Display;
import com.gaming.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game implements Runnable{

    private Display display;
    public String title;
    public int height, width;
    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int height, int width){
        this.height = height;
        this.width = width;
        this.title = title;

    }
    private void init() throws IOException {
        display = new Display(title, height, width);
    }

    private void tick(){}

    private void render(){
        bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        //Clean screen
        g.clearRect(0,0, width, height);

        /* Draw here start */
//        g.setColor(Color.RED);
//        g.fillRect(10, 50, 50, 70);
//        g.setColor(Color.GREEN);
//        g.fillRect(0,0, 10, 10);

         //g.drawRect(10, 50, 50, 70);

              

        /* Draw here end */


        bs.show();
        g.dispose();
    }


    public void run(){
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while(running){
         tick();
         render();
        }

        try {
            stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this); //Passing the game class. Which is the class we wanna run
        thread.start();
    }


    public synchronized  void stop() throws InterruptedException {
        if (!running)
            return;
        running = false;
        thread.join();
    }
}
