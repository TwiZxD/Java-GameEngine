package com.company;

/**
 * Created by Johan Segerlund on 2018-06-12.
 */
public class Screen {

    private int width, height;
    public int[] pixels;

    public int xOffset, yOffset;

    private final int ALPHA_COLOR_1 = 0xFFff00ff;
    private final int ALPHA_COLOR_2 = 0xff7F007F;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        xOffset = 0;
        yOffset = 0;
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void render() {
        drawRect(5,5,5,5, 0xff0000,true );
        renderSprite(2,2, Sprite.link,false );
    }

    public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
        if(fixed) {
          //  xp -= xOffset;
          //  yp -= yOffset;
            xp -= 0;
            yp -= 0;
        }
        for (int y = 0; y < sprite.getHeight(); y++){
            int ya = y + yp;
            for (int x = 0; x < sprite.getWidth(); x++){
                int xa = x + xp;
                if (xa < 0  || xa >= width || ya < 0 || ya >= height) continue;
                int col = sprite.pixels[x + y * sprite.getWidth()];
                if (col != ALPHA_COLOR_1 && col != ALPHA_COLOR_2) {
                    pixels[xa + ya * width] = col; //sprite.pixels[x + y * sprite.getWidth()];
                }
            }
        }
    }

    public void drawRect(int xp, int yp, int width, int height,int color, boolean fixed) {
        if(fixed){
            xp -= xOffset;
            yp -= yOffset;
        }
        for (int x = xp; x < xp + width; x++) {
            if (x < 0 | x >= this.width || yp >= this.height) continue;
            if (yp > 0) pixels[x + yp * this.width] = color;
            if (yp + height >= this.height) continue;
            if (yp + height > 0) pixels[x + (yp + height) * this.width] = color;
        }
        for (int y = yp; y <= yp + height; y++) {
            if (xp >= this.width || y < 0 || y >= this.height) continue;
            if (xp > 0)pixels[xp + y * this.width] = color;
            if (xp + width >= this.width) continue;
            if (xp + width> 0) pixels[xp + width + y * this.width] = color;
        }

    }

}
