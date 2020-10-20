import java.awt.*;

public class GameState extends State {

    
    public World world;

    private Handler handler;

    public GameState(Handler handler) {
        super(handler);
        this.handler = handler;
        world = new World(handler, "res/worlds/world1.txt");
        
        handler.setWorld(world);
        
        
        
    }

    @Override
    public void tick() {
        
        world.tick();

        if(handler.getKeyManager().esc) {
            State.setState(handler.getGame().menuState);
        }
        if(world.getEntityManager().getPlayer().getX() == 1174.0 && world.getEntityManager().getPlayer().getY() == 1152.0) {
            handler.getGame().level1 = new Level1(handler);
            State.setState(handler.getGame().level1);
            
        }

        
        
        
        
    }

    @Override
    public void render(Graphics g) {
        

         world.render(g);
         
         

    }

    @Override
    public void sw() {
        handler.setWorld(world);
    }

    @Override
    public void resset() {}

}