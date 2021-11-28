package ScreenSharing.ScreenSharer;

import ScreenSharing.Chatroom.ChatRoomPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NamePanel extends JPanel implements ActionListener {
    private JLabel nameLabel = new JLabel("Your Name: ");
    private JLabel ipLabel = new JLabel("IP: ");
    private JLabel portLabel = new JLabel("Port: ");
    private JTextField nameField = new UserPanel.HintTextField("Put your name in here");
    private JTextField ipField = new UserPanel.HintTextField("IP");
    private JTextField portField = new UserPanel.HintTextField("port");
    private JButton confirmNameBtn = new JButton("Confirm");
    public String userName;
    public boolean sharetime = false;
    private JFrame frame;

    public NamePanel(JFrame frame) {
        this.frame = frame;
        //nameLabel.setFont(new Font("helvetica", Font.BOLD, 10));
        nameField.setSize(100, 5);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 50, 500));
        add(Box.createVerticalGlue());
        add(nameLabel);
        add(nameField);
        add(Box.createRigidArea(new Dimension(10, 20)));
        add(ipLabel);
        add(ipField);
        add(Box.createRigidArea(new Dimension(10, 20)));
        add(portLabel);
        add(portField);
        add(confirmNameBtn);
        add(Box.createRigidArea(new Dimension(10, 180)));
        confirmNameBtn.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        userName = nameField.getText();
        sharetime = true;
        try {
            Runnable sc = new ScreenSharer(userName, ipField.getText(), Integer.parseInt(portField.getText()));
            Thread m2 = new Thread(sc);
            m2.start();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


    public String getName() {
        return userName;
    }
}
