package ScreenSharing.ScreenSharer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Canvas extends JPanel {
    JLabel label = new JLabel();
    private static Canvas uniqueInstance;


    private Canvas() {
    }

    public static Canvas getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Canvas();
        }
        return uniqueInstance;
    }

    public void setWindow(ObjectInputStream inputStream, int frameWidth, int frameHeight) {
        try {
            System.out.println("Adjust Window Size: " + frameWidth + " " + frameHeight);
            BufferedImage img = ImageIO.read(inputStream);
            Image image = img.getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH);

            ImageIcon icon = new ImageIcon(image);
            label.setIcon(icon);
            add(label);
            repaint();
        } catch (IOException e) {
            System.out.println("Error Here");
            e.printStackTrace();
        }
    }



}

