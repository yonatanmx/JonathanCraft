import java.awt.*;

public class MenuState extends State {

    private Handler handler;
    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        this.handler = handler;
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButton(handler.getWidth() / 2 - 64, handler.getHeight() / 2 , 128, 64, Assets.btn_start, new ClickListener(){
            @Override
            public void onClick() {
                // handler.getMouseManager().setUIManager(null);
                
                //handler.getGame().level1 = new Level1(handler);
                State.setState(handler.getGame().level1);
            }}));


        uiManager.addObject(new UIImageButton(handler.getWidth() / 2 - 64, handler.getHeight() / 2 + 100, 128, 64, Assets.btn_menu, new ClickListener(){
            @Override
            public void onClick() {
                // handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().menuState2);
            }}));    
    }

    @Override
    public void tick() {

        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {
        
        for(int i = 0; i < handler.getWidth(); i += Tile.TILEWIDTH) {
			for(int j = 0; j < handler.getHeight(); j+=Tile.TILEHEIGHT) {
				g.drawImage(Assets.grass, i, j, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
            }
        }    

        uiManager.render(g);
    }

    @Override
    public void sw() {
    }

}