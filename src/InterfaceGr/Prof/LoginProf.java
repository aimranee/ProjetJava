package InterfaceGr.Prof;

import javax.swing.*;

import InterfaceGr.PageMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginProf extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel jLabel1 = new JLabel("Login Prof");
    JLabel userLabel = new JLabel("USERNAME");
    JTextField userTextField = new JTextField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");


    LoginProf() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        loginButton.setBounds(80, 260, 100, 30);
        resetButton.setBounds(220, 260, 100, 30);
		jLabel1.setFont(new java.awt.Font("Doppio One", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 225));
        jLabel1.setText("Login Prof");
        jLabel1.setBounds(120, 20, 300, 100);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(userTextField);
        container.add(loginButton);
        container.add(resetButton);
        container.add(jLabel1);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            userText = userTextField.getText();
            if (userText.equalsIgnoreCase("prof")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
//                PageMenu pm = new PageMenu();
//                this.dispose();
//                pm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username");
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
        }
    }


    public static void main(String[] a) {
        LoginProf frame = new LoginProf();
        frame.setTitle("Login Form Prof");
        frame.setVisible(true);
        frame.setBounds(300, 90, 440, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}
