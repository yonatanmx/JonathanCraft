import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Builder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            do {
                line = br.readLine();
                builder.append(line + "\n");
            } while(line != null);
            br.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch(NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}