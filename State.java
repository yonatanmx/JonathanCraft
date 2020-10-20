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
        state.sw();
    }

    public static State getState() {
        return currentState;
    }
 
    //CLASS

    protected Handler Handler;

    public State(Handler handler) {

        this.Handler = handler;

    }
    public int m = 0;

    public abstract void resset();

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void sw();
    
}