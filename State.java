import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }
 
    //CLASS

    protected Handler Handler;

    public State(Handler handler) {

        this.Handler = handler;

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    
}
