package com.company;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by Johan Segerlund on 2018-06-12.
 */

public class Game extends Canvas implements Runnable {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 168;
    private static final int SCALE = 2;
    public String title = "GameEngine";

    private Thread thread;
    private boolean running = false;

    private Screen screen;

    /** Create Image */
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    /** Access Image */
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);

        screen = new Screen(WIDTH, HEIGHT);

    }

    private void update() {
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        screen.render();

        for (int i = 0; i < pixels.length; i++){
            pixels[i] = screen.pixels[i];
        }

        Graphics graphics = bs.getDrawGraphics();

        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        graphics.dispose(); //Release Resources
        bs.show();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display" + title);
        thread.start();
    }

    public synchronized void stop() throws InterruptedException {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(running) {
            update();
            render();
        }
    }
}
