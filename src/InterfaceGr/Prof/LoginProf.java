package InterfaceGr.Prof;

import javax.swing.*;

import InterfaceGr.PageMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

public class LoginProf extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel jLabel1 = new JLabel("Login Prof");
    JLabel userLabel = new JLabel("USERNAME");
    JTextField userTextField = new JTextField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");


    public LoginProf() {
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
    
    //test username prof from base de donnee ==> 

    /* String sql = "Select * from users where username = ? and password = ?";
    String sql1 = "select type from users WHERE username ='"+textnom.getText()+"'";
    try{  
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestionrestaurant","root","");
            
        pst=con.prepareStatement(sql);
        pst1=con.prepareStatement(sql1);
        pst.setString(1, textnom.getText());
        char[] ps=textmotdepasse.getPassword();
        String pss =new String(ps);
        pst.setString(2, pss);
        //System.out.println(textmotdepasse1.getPassword());
        rs = pst.executeQuery();
        rs1 = pst1.executeQuery();            
        while(rs1.next()){
            type = rs1.getString("type");
        }
        if(rs.next()){
            nom=textnom.getText();
            mp=textmotdepasse.getText();
        if(type.equals("cis")){
            this.setVisible(false);
            Cuisinier.Accueil paca = new Cuisinier.Accueil();
            paca.setVisible(true);
        }
        if(type.equals("cui")){
            this.setVisible(false);
            Caisier.Accueil pace = new Caisier.Accueil ();
            pace.setVisible(true);
        }
        if(type.equals("ser")){
            this.setVisible(false);
            Serveuse.Accueil pacs = new Serveuse.Accueil();
            pacs.setVisible(true);
        }
        }else{
            nom=textnom.getText();
            mp=textmotdepasse.getText();
            if((nom.length()!=0)||(mp.length()!=0)){
            fay.setText("nom ou bien le mot de passe n'est pas correct !!!!");
            //textnom.setBackground(Color.red);
            //textmotdepasse.setBackground(Color.red);
            fay.setForeground(Color.RED);
            }else{
            //textnom.setBackground(Color.red);
            //textmotdepasse.setBackground(Color.red);
            fay.setForeground(Color.RED);
            if((nom.length()==0)&&(mp.length()==0)){
                fay.setText("les champs est vide !!!!");
            }
            if(nom.length()==0){
                  fay.setText("le champs de votre nom est vide !!!!");  
                  
            }
            if((mp.length()==0)){
                  fay.setText("le champs de votre mot de passe est vide !!!!");
            }
            
            }
        
        }
            //JOptionPane.showMessageDialog(null, "nom et le mot de passe et n'est pas correct !!!! ")
        st = con.createStatement();
    }catch(Exception e){
        System.out.printf("erreur   "+e.getMessage());//getMessage c'est une fonction  pour afficher l'Erreur ou se trouve ?!!!!!
        JOptionPane.showMessageDialog(null, "Erreur de connexion\n  "+ e.getMessage());
    }        // TODO add your handling code here:
    }
    */
}
