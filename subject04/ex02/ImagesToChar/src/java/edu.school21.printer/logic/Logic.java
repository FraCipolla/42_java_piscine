package edu.school21.printer;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Map;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

public class Logic {
    
    public void printImg(String white, String black) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(File.class.getResource("/resources/it.bmp"));
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    if (img.getRGB(x, y) == 0xFF000000) {
                        System.out.print(Ansi.colorize(" ", resolveColor(black)));
                    } else {
                        System.out.print(Ansi.colorize(" ", resolveColor(white)));
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private Attribute resolveColor(String input) throws IllegalColorException {
		switch (input) {
			case "RED":
				return Attribute.RED_BACK();
			case "GREEN":
				return Attribute.GREEN_BACK();
			case "BLUE":
				return Attribute.BLUE_BACK();
			case "BLACK":
				return Attribute.BLACK_BACK();
			case "WHITE":
				return Attribute.WHITE_BACK();

			case "BRIGHT_RED":
				return Attribute.BRIGHT_RED_BACK();
			case "BRIGHT_GREEN":
				return Attribute.BRIGHT_GREEN_BACK();
			case "BRIGHT_BLUE":
				return Attribute.BRIGHT_BLUE_BACK();
			case "BRIGHT_BLACK":
				return Attribute.BRIGHT_BLACK_BACK();
			case "BRIGHT_WHITE":
				return Attribute.BRIGHT_WHITE_BACK();

			default:
				throw new IllegalColorException();
		}
	}

    public class IllegalColorException extends RuntimeException {
        public IllegalColorException() {
            super("Illegal color specified!");
        }
    }
}
