package InterfaceGr.Admin;

import javax.swing.*;
import java.awt.*;

public class First_Loading extends JFrame{
    JFrame frame;
    JLabel image=new JLabel(new ImageIcon("/icons/logoD2.jpg"));
    JLabel text=new JLabel("welcome to your application ");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    First_Loading()
    {
        createGUI();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setVisible(true);

    }
   
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,30));
        text.setBounds(110,120,600,40);
        text.setForeground(Color.BLUE);
        frame.add(text);

    }
    public void addMessage()
    {
        message.setBounds(250,320,200,40);
        message.setForeground(Color.black);
        message.setFont(new Font("arial",Font.BOLD,15));
        frame.add(message);
    }
    public void addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLUE);
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    public void runningPBar(){
        int i=0;

        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("LOADING ...");
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args){
    	First_Loading fen = new First_Loading();
    	fen.setVisible(true);
        loginForm login = new loginForm();
        fen.dispose();
        login.setVisible(true);

    }
}
