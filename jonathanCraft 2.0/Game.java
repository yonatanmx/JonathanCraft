import java.awt.*;
import java.awt.image.BufferStrategy;

//episode 33
public class Game implements Runnable {

    private Display display;
    private int width, height;
    private boolean running = false;
    public Thread thread;
    public String title;
    private BufferStrategy bs;
    private Graphics g;


    //States
    public State gameState;
    public State menuState;
    public State menuState2;
    public State level1;

    private KeyManager keyManager;
    private MouseManager mouseManager;

    //camera
    private GameCamera gameCamera;

    //handler
    private Handler handler;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        //String testpath = "C:\\Users\\yonatan marx\\Desktop\\javaMX\\codenmore game tutorial\\res\\textures\\sheet.png";
        //test = ImageLoader.loadImage(testpath);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        

        gameState = new GameState(handler);
        //level1 = new Level1(handler);
        menuState = new MenuState(handler);
        menuState2 = new MenuState2(handler);
        
        State.setState(menuState);

    }


    private void tick() {
        keyManager.tick();

        if(State.getState() != null) {
            State.getState().tick();
        } 
    }

    private void render() {
        //System.out.println("1");
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear screen

        g.clearRect(0, 0, width, height);

        //draw here

        if(State.getState() != null) {
            State.getState().render(g);
        } 

        //end drawing
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        int fps = 100;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }   
            
            if(timer >= 1000000000) {
                ticks = 0;
                timer = 0;
            }

        }

        stop();

    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if(running) {
           return; 
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    } 

    public synchronized void stop() {
        if(!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}