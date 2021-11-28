package ScreenSharing.ScreenSharer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class HomePanel extends JPanel {
    private JButton button = new JButton();
    private String homeButtonPath = "/Users/mars/JavaLearning/SocketLearning/src/ScreenSharing/HomeButton.png";
    private int imgWidth = 331;
    private int imgHeight = 172;

    public HomePanel(JFrame frame, JPanel namePanel) {
        setLayout(null);
        add(button);
        button.setBounds(215, 100, imgWidth, imgHeight);
        ChangePage(frame, namePanel);
    }

    private void ChangePage(JFrame frame, JPanel namePanel) {
        try {
            BufferedImage bfImg = ImageIO.read(new File(homeButtonPath));
            Image homeButton = bfImg.getScaledInstance(imgWidth, imgHeight, Image.SCALE_DEFAULT);
            button.setIcon(new ImageIcon(homeButton));
            button.setMargin(new Insets(0, 0, 0, 0));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    frame.setContentPane(namePanel);
                    frame.revalidate();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
