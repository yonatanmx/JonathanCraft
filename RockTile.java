import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.*;

public class RockTile extends Tile {

    public RockTile(int id) {
        super(Assets.stone , id);
        
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}