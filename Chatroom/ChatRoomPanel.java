package ScreenSharing.Chatroom;

import ScreenSharing.ScreenSharer.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class ChatRoomPanel extends JPanel implements Runnable {

    private Socket socket;
    private String userName;
    ChatRoom client = null;

    public ChatRoomPanel(String userName) throws Exception {
        //client = new ChatRoom(userName);
        this.userName = userName;
    }
//    public static void main(String[] args) {
//        ChatRoomPanel p = new ChatRoomPanel();
//        Thread m = new Thread(p);
//        m.start();
//    }

    @Override
    public void run() {

        try {
            client = new ChatRoom(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("ChatRoom");
        frame.setSize(500, 200);
        JTextField inputField = new UserPanel.HintTextField("Chat here");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> messageList = new JList<>(listModel);


        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String text = inputField.getText();
                    System.out.println(userName + ": " + text);
                    client.listenForMessage();
                    client.sendMessage(text);

                    listModel.addElement("You: " + text);
                    inputField.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        setLayout(new BorderLayout());
        frame.add(new JScrollPane(this), BorderLayout.CENTER);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
