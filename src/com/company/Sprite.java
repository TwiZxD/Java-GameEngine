package com.company;

/**
 * Created by Johan Segerlund on 2018-06-12.
 */
public class Sprite {
  //  private final int SIZE;
    private int x, y;
    public int width, height;
    public int[] pixels;
    private SpriteSheet sheet;

   // public static Sprite link = new Sprite(32,46,0,0,SpriteSheet.zelda);
    public static Sprite link = new Sprite(32,32,0,0, SpriteSheet.zelda);
    public Sprite(int size, int x, int y, SpriteSheet sheet) {

   // this.SIZE = size;
    this.width = size;
    this.height = size;
    pixels = new int[size * size];
    this.x = x * size;
    this.y = y * size;
    this.sheet = sheet;
    }

    public Sprite(int widht, int height, int x, int y, SpriteSheet sheet){
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        this.x = x * width;
        this.y = y * height;
        load();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void load() {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                pixels[x + y * width] = sheet.pixels[(x + this.x) + (y+this.y)*sheet.SIZE];
            }
        }
    }
}
