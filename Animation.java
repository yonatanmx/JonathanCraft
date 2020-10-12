import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class Animation {

    private int speed, index;
    private BufferedImage[] frames;
    private long lastTime, timer;

    public Animation(int s, BufferedImage[] f) {
        speed = s;
        frames = f;
        index = 0;
        lastTime = System.currentTimeMillis();
        timer = 0;
    }

    public void tick() {

        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed) {
            index++;
            timer = 0;
            if(index >= frames.length) {
                index = 0;
            }
        }

    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
    
}