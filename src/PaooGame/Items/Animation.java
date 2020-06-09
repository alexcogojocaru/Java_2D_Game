package PaooGame.Items;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed;
    private int index;
    private BufferedImage[] frames;
    private long lastTime;
    private long timer;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        this.index = 0;
        lastTime = System.currentTimeMillis();
    }

    public void Update() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length) {
                index = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}