import java.awt.*;

public class Level1 extends State {

    
    private World world;

    private Handler handler;
    
    private World[] worlds = new World[10];
    private int i = 0;

    public Level1(Handler handler) {
        super(handler);
        resset();
        this.handler = handler;
        initWorlds();
        world = worlds[0];
        handler.setWorld(world);
        
        
        
    } 

    public void initWorlds() {
        worlds[0] = new World(handler, "res/worlds/level1.txt");
        worlds[1] = new World(handler, "res/worlds/level2.txt");
        worlds[2] = new World(handler, "res/worlds/level3.txt");
        worlds[3] = new World(handler, "res/worlds/level4.txt");
        worlds[4] = new World(handler, "res/worlds/level5.txt");
        worlds[5] = new World(handler, "res/worlds/level6.txt");
        worlds[6] = new World(handler, "res/worlds/level7.txt");
        worlds[7] = new World(handler, "res/worlds/level8.txt");
        worlds[8] = new World(handler, "res/worlds/level9.txt");
        worlds[9] = new World(handler, "res/worlds/level10.txt");
    }

    @Override
    public void tick() {
        world.tick();

        if(handler.getKeyManager().esc) {
            State.setState(handler.getGame().menuState);
        }
        try {
            if((int)world.getEntityManager().getPlayer().getX() >= 1810 || (int)world.getEntityManager().getPlayer().getY() >= 1810) {
                if(i == worlds.length) {
                    State.setState(handler.getGame().endScreen);
                }
                else {
                System.out.println(1);
                world = worlds[i + 1];
                handler.setWorld(world);
                i++;
                }
                
            }
        } catch (Exception e) {
            System.out.println(22);
            State.setState(handler.getGame().endScreen);
        }
        
        //System.out.println(world.getEntityManager().getPlayer().getX() + "," + world.getEntityManager().getPlayer().getX());
        
        
        
    }

    @Override
    public void render(Graphics g) {

        world.render(g);
         
         

    }

    @Override
    public void sw() {
        handler.setWorld(world);
    }

    public void resset() {
        i = 0;
    }

}
//world.getEntityManager.getPlayer.setX()