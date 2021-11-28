package ScreenSharing.ScreenSharer;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ScreenSharer implements Runnable {
    private InetAddress ip;
    private int port;
    private String userName;
    Canvas canvas = Canvas.getInstance();


    public ScreenSharer(String userName,String ip, int port) throws Exception {
        this.userName = userName;
        this.ip = InetAddress.getByName(ip);
        this.port = port;

    }


    @Override
    public void run() {
        JFrame sharer = new JFrame(userName +"'s Screen Sharer");
        int frameHeight, frameWidth;
        sharer.setSize(800, 450);
        sharer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Socket s = null;
        // Screen Sharing Interface
        try {
            while (true) {
                s = new Socket(ip, port);
                System.out.println("===Get Into While Loop in Client======");
                ObjectInputStream inputStream = new ObjectInputStream(s.getInputStream());
                frameHeight = sharer.getHeight();
                frameWidth = sharer.getWidth();
                canvas.setWindow(inputStream, frameWidth, frameHeight);
                sharer.getContentPane().add(canvas);
                sharer.setVisible(true);
                s.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            assert s != null;
            try {
                s.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}


