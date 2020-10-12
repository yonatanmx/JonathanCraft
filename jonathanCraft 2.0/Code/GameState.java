import java.awt.*;

public class GameState extends State {

    
    private World world;

    private Handler handler;
    

    public GameState(Handler handler) {
        super(handler);
        System.out.println("gamestate");
        this.handler = handler;
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
        for(int i = 0; i < 1000; i++) {
            System.out.println("gemstet");
        }
        
        
        
    }

    @Override
    public void tick() {
        world.tick();

        if(handler.getKeyManager().esc) {
            State.setState(handler.getGame().menuState);
        }
        //if(world.getEntityManager().getPlayer().getX() >= 1200 && world.getEntityManager().getPlayer().getY() >= 1200) {
        //    State.setState(handler.getGame().level1);
       // }
        
        
        
    }

    @Override
    public void render(Graphics g) {

         world.render(g);
         
         

    }

}
//world.getEntityManager.getPlayer.setX()