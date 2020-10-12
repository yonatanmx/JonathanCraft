import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.*;

public class Tile {



    //Static stuff

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);

    //Class

    public static final int TILEWIDTH = 64,
                            TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texure, int id) {
        
        this.texture = texure;
        this.id =id; 
        
        tiles[id] = this;

    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y,TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }    

    public int getId() {

        return id;

    }

}