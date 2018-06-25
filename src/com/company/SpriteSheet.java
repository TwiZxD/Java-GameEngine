package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Johan Segerlund on 2018-06-12.
 */
public class SpriteSheet {
    private String path;
    public final int SIZE;
    private int width, height;
    public int[] pixels;

   // public static SpriteSheet zelda = new SpriteSheet("/res/ZeldaSheet.png",1653, 1153);
   public static SpriteSheet zelda = new SpriteSheet( "res/Player.png",96, 128);

            //"/res/Player.png"

    public SpriteSheet(String path, int width, int height) {
        this.path = path;
        this.width = width;
        this.height = height;
        this.SIZE = width * height;
        pixels = new int [width * height];
        load();
    }

    private void load() {
        try {
            System.out.print("Trying to load: "+ path + " ' ... '");
            BufferedImage image = ImageIO.read(getClass().getResource(path));
            System.out.println(" succeeded!");
            width = image.getWidth();
            height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0,0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.err.println(" failed!");
        }
    }

}

