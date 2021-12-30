package InterfaceGr.Prof;

import ConnectionOracl.Connect;

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

        JLabel labelNom = new JLabel("Nom ");
        labelNom.setBounds(70,240,170,25);
        labelNom.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelNom);
            JTextField textNom = new JTextField();
            textNom.setBounds(200,240,100,25);
            panel.add(textNom);

        JLabel labelPrenom = new JLabel("Prenom ");
        labelPrenom.setBounds(70,270,170,25);
        labelPrenom.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelPrenom);

            JTextField textPrenom = new JTextField();
            textPrenom.setBounds(200,270,100,25);
            panel.add(textPrenom);

        JLabel labelNote = new JLabel("Note");
        labelNote.setBounds(70,300,170,25);
        labelNote.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelNote);

            JTextField textNote=new JTextField();
            textNote.setBounds(200,300,100,25);
            panel.add(textNote);

        JLabel labelDescription = new JLabel("Description ");
        labelDescription.setBounds(70,330,170,25);
        labelDescription.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelDescription);

            JTextArea textDescription = new JTextArea();
            textDescription.setFont(new Font("Arial",Font.BOLD,11));

            scroll1=new JScrollPane();
            scroll1.setBounds(200,330,200,80);
            scroll1.setViewportView(textDescription);
            panel.add(scroll1);

        /*table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectTable(evt);
            }
        });*/

        JButton btnEnrg = new JButton("ENREGISTRER");
        btnEnrg.setBounds(30,130,120,25);
        btnEnrg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                String nom, prenom, description;
                String note;
                nom = textNom.getText().toLowerCase();
                prenom = textPrenom.getText().toLowerCase();

                description = textDescription.getText();
                note = textNote.getText();
                if(!nom.equals("")&&!prenom.equals("")&&!note.equals("")) {
                    String id_etudiant = "select id from etudiant where lower(nom) = '" + nom + "' AND lower(prenom) = '" + prenom + "'";
                    try {
                        rs = st.executeQuery(id_etudiant);
                        /*JTextField textId = new JTextField();
                        textId.setText();
                        id = rs*/
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur!", null, JOptionPane.ERROR_MESSAGE);
                    }
                    String rq = "insert into ABSENCEETUDIANT value (RESENCE_seq.nextval,'" + description + "','" + note + "','" + dateFormat.format(date) + "','" + rs + "')'";
                    try {
                        rs = st.executeQuery(rq);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur!", null, JOptionPane.ERROR_MESSAGE);
                    }
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