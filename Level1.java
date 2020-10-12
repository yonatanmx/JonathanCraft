import java.awt.*;

public class Level1 extends State {

    
    private World world;

    private Handler handler;
    

    public Level1(Handler handler) {
        super(handler);
        this.handler = handler;
        State.setState(handler.getGame().level1);
        world = new World(handler, "res/worlds/level2.txt");
        handler.setWorld(world);
        
        
        
    } 

    @Override
    public void tick() {
        world.tick();

        if(handler.getKeyManager().esc) {
            State.setState(handler.getGame().menuState);
        }
        
        
        
    }

    @Override
    public void render(Graphics g) {

        world.render(g);
         
         

    }

}
//world.getEntityManager.getPlayer.setX()