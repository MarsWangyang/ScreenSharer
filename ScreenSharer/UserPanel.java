package ScreenSharing.ScreenSharer;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class UserPanel {
    public static class HintTextField extends JTextField implements FocusListener {

        private final String hint;
        private boolean showingHint;

        public HintTextField(final String hint) {
            super(hint);
            this.hint = hint;
            this.showingHint = true;
            super.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText("");
                showingHint = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(hint);
                showingHint = true;
            }
        }

        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
        }
    }

//    public static void main(String[] args) {
//        // Home Page
//        JFrame frame = new JFrame("test frame");
//        JPanel userPanel = new JPanel();
//        JButton button = new JButton();
//        String homeButtonPath = "/Users/mars/JavaLearning/SocketLearning/src/ScreenSharing/HomeButton.png";
//        int imgWidth = 331;
//        int imgHeight = 172;
//        double ratio = (double) imgWidth / imgHeight;
//
//        //Name Page
//        JPanel namePanel = new JPanel();
//        JLabel nameLabel = new JLabel("Your Name");
//        JTextField nameField = new HintTextField("Put your name in here");
//        JButton confirmNameBtn = new JButton("Confirm");
//        String userName;
//
//
//        try {
//            BufferedImage bfImg = ImageIO.read(new File(homeButtonPath));
//            Image homeButton = bfImg.getScaledInstance(imgWidth, imgHeight, Image.SCALE_DEFAULT);
//            button.setIcon(new ImageIcon(homeButton));
//            button.setMargin(new Insets(0, 0, 0, 0));
//            button.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    frame.setContentPane(namePanel);
//                    frame.revalidate();
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        // Name Panel
//        nameLabel.setFont(new Font("helvetica", Font.BOLD, 20));
//        nameField.setSize(100, 10);
//        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
//        namePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 50, 500));
//        namePanel.add(Box.createVerticalGlue());
//        namePanel.add(nameLabel);
//        namePanel.add(nameField);
//        namePanel.add(Box.createRigidArea(new Dimension(10, 20)));
//        namePanel.add(confirmNameBtn);
//        confirmNameBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
////                frame.setContentPane();
//                frame.revalidate();
//            }
//        });
//        userName = nameField.getText();
//        namePanel.add(Box.createRigidArea(new Dimension(10, 180)));
//        // First Panel
//        userPanel.setLayout(null);
//        userPanel.add(button);
//        button.setBounds(215, 100, imgWidth, imgHeight);
//        frame.setLocation(315, 200);
//        frame.setSize(800, 450);
//        frame.getContentPane().add(userPanel);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

}
