package InterfaceGr.Prof;

import ConnectionOracl.Connect;
import Educative.Presences.PresenceEtudiant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GraphiquesProf extends JFrame {
    Statement st;
    ResultSet rs;
    JPanel panel = new JPanel();
    Connection con = Connect.getCon();
    JTable table = new JTable();
    JScrollPane scroll,scroll1 = new JScrollPane();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public GraphiquesProf(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle ("Page Prof");
        this.setSize (900,750);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        panel.setLayout(null);
        add(panel);
        panel.setBackground(Color.lightGray);

        JLabel labelTitre1=new JLabel("List des Etudiants");
        labelTitre1.setBounds(400,20,800,30);
        labelTitre1.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(labelTitre1);

        DefaultTableModel df = new DefaultTableModel();
        init();
        panel.add(scroll);

        df.addColumn("ID");
        df.addColumn("Nom");
        df.addColumn("Prenom");
        table.setModel(df);
        String req="select * from etudiant";
        try {
            st=con.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()){
                df.addRow(new Object[]{
                        rs.getString("ID"),
                        rs.getString("NOM"),
                        rs.getString("PRENOM")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erreur base de donnée !",null,JOptionPane.ERROR_MESSAGE);
        }

        JLabel labelTitre2=new JLabel("Formulaire de présences");
        labelTitre2.setBounds(50,200,800,30);
        labelTitre2.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(labelTitre2);

        JLabel labelId = new JLabel("Etudiant ID ");
        labelId.setBounds(70,240,170,25);
        labelId.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelId);
            JTextField textId = new JTextField();
            textId.setBounds(200,240,100,25);
            panel.add(textId);

        JLabel labelHalaka = new JLabel("Halaka ID ");
        labelHalaka.setBounds(70,270,170,25);
        labelHalaka.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelHalaka);
            JTextField textHalaka = new JTextField();
            textHalaka.setBounds(200,270,100,25);
            panel.add(textHalaka);

        JLabel labelNom = new JLabel("Nom ");
        labelNom.setBounds(70,300,170,25);
        labelNom.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelNom);
            JTextField textNom = new JTextField();
            textNom.setBounds(200,300,100,25);
            panel.add(textNom);

        JLabel labelNote = new JLabel("Note ");
        labelNote.setBounds(70,330,170,25);
        labelNote.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelNote);

            JTextField textNote=new JTextField();
            textNote.setBounds(200,330,100,25);
            panel.add(textNote);

        JLabel labelDescription = new JLabel("Description ");
        labelDescription.setBounds(70,360,170,25);
        labelDescription.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelDescription);

            JTextArea textDescription = new JTextArea();
            textDescription.setFont(new Font("Arial",Font.BOLD,11));

            scroll1=new JScrollPane();
            scroll1.setBounds(200,360,200,50);
            scroll1.setViewportView(textDescription);
            panel.add(scroll1);

        /*table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectTable(evt);
            }
        });*/

        JButton btnEnrg = new JButton("ENREGISTRER");
        btnEnrg.setBounds(70,430,120,25);
        btnEnrg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String etudiant_ID, note, nom, description, halaka_ID;
                etudiant_ID = textId.getText();
                halaka_ID = textHalaka.getText();
                nom = textNom.getText().toLowerCase();
                description = textDescription.getText();
                note = textNote.getText();

                LocalDateTime localDateTime = LocalDateTime.now();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateSeance = localDateTime.format(formatter);

                PresenceEtudiant present = new PresenceEtudiant(dateSeance, description, note, etudiant_ID, halaka_ID);

                if(!etudiant_ID.equals("")&&!nom.equals("")&&!halaka_ID.equals("")&&!note.equals("")) {

                    TraitementProf trait = new TraitementProf();
                    trait.createElement(present);

                }else{
                    JOptionPane.showMessageDialog(null,"Completez le formulaire!",null,JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnEnrg);
    }

    private void init(){
        table=new JTable();
        scroll=new JScrollPane();
        scroll.setBounds(200,70,600,120);
        scroll.setViewportView(table);
    }
    /*private void selectTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectClientMouseClicked
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int Myindex = table.getSelectedRow();
        textNom.setText(model.getValueAt(Myindex, 1).toString());
        textPrenom.setText(model.getValueAt(Myindex, 2).toString());
    }*/

    public static void main(String[] args) {
        GraphiquesProf prof = new GraphiquesProf();
        prof.setVisible(true);
    }
    //private javax.swing.JTextField textNom,textPrenom;
}
/*private void selectClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectClientMouseClicked
        DefaultTableModel model = (DefaultTableModel)selectClient.getModel();
        int Myindex = selectClient.getSelectedRow();
        numD.setText(model.getValueAt(Myindex, 0).toString());
    }*/