package edu.school21.printer;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Logic {
    public void printImg(String white, String black) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(File.class.getResource("/resources/it.bmp"));
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    if (img.getRGB(x, y) == 0xFF000000) {
                        System.out.print(black);
                    } else {
                        System.out.print(white);
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
