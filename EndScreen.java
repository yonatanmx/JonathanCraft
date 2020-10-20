import java.awt.*;

public class EndScreen extends State {

    private Handler handler;
    private UIManager uiManager;

    public EndScreen(Handler handler) {
        super(handler);
        this.handler = handler;
        
    }

    @Override
    public void tick() {

        if(handler.getKeyManager().esc) {
            State.setState(handler.getGame().menuState);
        }

    }

    @Override
    public void render(Graphics g) {

        for(int i = 0; i < handler.getWidth(); i += Tile.TILEWIDTH) {
			for(int j = 0; j < handler.getHeight(); j+=Tile.TILEHEIGHT) {
				g.drawImage(Assets.grass, i, j, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
            }
        }

        
        
        
        
        
        Text.drawString(g, " YOU FINISHED THE GAME! ", handler.getWidth() / 2 - 0, 400, true, Color.black, Assets.font282);
        Text.drawString(g, " TO START OVER PRESS ESC", handler.getWidth() / 2 - 0, 445, true, Color.black, Assets.font282);
        Text.drawString(g, " CREATED BY JONATHAN MARX 2020", handler.getWidth() / 2 - 0, handler.getHeight() -  100, true, Color.black, Assets.font282);
    }

    @Override
    public void sw() {
        
    }
    @Override
    public void resset() {}

}
