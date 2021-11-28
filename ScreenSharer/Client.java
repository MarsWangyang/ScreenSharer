package ScreenSharing.ScreenSharer;

import javax.swing.*;

public class Client {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("test frame");
        frame.setLocation(315, 200);
        frame.setSize(800, 450);

        // Name Page
        NamePanel namePanel = new NamePanel(frame);
        // Home Page
        HomePanel homePanel = new HomePanel(frame, namePanel);

        frame.getContentPane().add(namePanel);
        frame.getContentPane().add(homePanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


