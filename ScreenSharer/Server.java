package ScreenSharing.ScreenSharer;


import ScreenSharing.Chatroom.ClientHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

public class Server {

    private ServerSocket ss;

    private Server(ServerSocket ss) {
        this.ss = ss;
    }

    public void startCaptureScreenServer() {
        while(true) {
            try {
                Socket s = ss.accept();
                System.out.println("A new client has connected");
//                ClientHandler clientHandler = new ClientHandler(s);
                ObjectOutputStream outputStream = new ObjectOutputStream(s.getOutputStream());
                BufferedImage bufferedImg = captureScreen();
                ImageIO.write(bufferedImg, "jpg", outputStream);
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    };

    public void startChatRoomServer() {
        try {
            Socket s = ss.accept();
            System.out.println("===Chat Server has connected===");
            ClientHandler clientHandler = new ClientHandler(s);
            Thread thread = new Thread(clientHandler);
            thread.start();
        } catch(Exception e ) {
            e.printStackTrace();
        }
    }

    private BufferedImage captureScreen() throws Exception{
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        String cursorPath = "/Users/mars/JavaLearning/SocketLearning/src/ScreenSharing/cursor.png";
        BufferedImage bufferedImg = robot.createScreenCapture(rectangle);
        Image cursor = ImageIO.read(new File(cursorPath));
        int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        int y = (int) MouseInfo.getPointerInfo().getLocation().getY();
        Graphics2D graphics2D = bufferedImg.createGraphics();

        graphics2D.drawImage(cursor, x, y, 30, 30, null); // cursor.gif is 16x16 size.
        return bufferedImg;
    }

    public void closeServer() {
        try {
            if (ss != null) {
                ss.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(5056);
        Server server = new Server(ss);
        server.startCaptureScreenServer();
    }


}



