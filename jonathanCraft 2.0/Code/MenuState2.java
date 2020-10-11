import java.awt.*;

public class MenuState2 extends State {

    private Handler handler;
    private UIManager uiManager;

    public MenuState2(Handler handler) {
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

        Text.drawString(g, " W A S D TO MOVE", handler.getWidth() / 2 - 0, 100, true, Color.white, Assets.font282);
        Text.drawString(g, " ARROW KEYS TO ATTACK", handler.getWidth() / 2 - 0, 145, true, Color.white, Assets.font282);
        Text.drawString(g, " E TO OPEN INVENTORY", handler.getWidth() / 2 - 0, 190, true, Color.white, Assets.font282);
        Text.drawString(g, " ARROW KEYS TO BROWSE INVENTORY", handler.getWidth() / 2 - 0, 235, true, Color.white, Assets.font282);
        Text.drawString(g, " ESC TO GET OUT OF THIS MENU", handler.getWidth() / 2 - 0, 280, true, Color.white, Assets.font282);
        Text.drawString(g, " CREATED BY JONATHAN MARX 2020", handler.getWidth() / 2 - 0, handler.getHeight() -  100, true, Color.white, Assets.font282);
    }

}
