package InterfaceGr.Prof;

import Administrative.Etudiant.Etudiants;
import ConnectionOracl.Connect;
import Educative.Absences.AbsenceEtudiant;
import Educative.Presences.PresenceEtudiant;
import InterfaceGr.Etudiant.TraitementEtudaint;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class GraphiquesProf extends JFrame implements Serializable{
    static ObjectInputStream ois = null;
    static ObjectOutputStream oos = null;
    static AbsenceEtudiant abcense;
    static Socket profSocket;
    static List<Etudiants> listEtudiant;
    Statement st;
    ResultSet rs;
    JPanel panel = new JPanel();
    Connection con = Connect.getCon();
    JTable table,table1 = new JTable();
    JScrollPane scroll,scroll1,scroll2 = new JScrollPane();
    public GraphiquesProf() throws IOException, ClassNotFoundException {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle ("Page Prof");
        this.setSize (1000,600);
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
        panel.add(scroll1);

        df.addColumn("ID");
        df.addColumn("Nom");
        df.addColumn("Prenom");
        df.addColumn("Datnaissance");
        df.addColumn("Sexe");
        df.addColumn("Filiere");
        table.setModel(df);

        try {
            profSocket = new Socket("127.0.0.1", 5000);
            listEtudiant = new ArrayList<Etudiants>();
            oos = new ObjectOutputStream(profSocket.getOutputStream());
            ois = new ObjectInputStream(profSocket.getInputStream());
            Object object = ois.readObject();
            listEtudiant = (List<Etudiants>)object;

            for (int i=0; i<listEtudiant.size(); i++){

                String id = listEtudiant.get(i).getId();
                String nom = listEtudiant.get(i).getNom();
                String prenom = listEtudiant.get(i).getPrenom();
                String datNaissance = listEtudiant.get(i).getDatNaissance();
                String sexe = listEtudiant.get(i).getSexe();
                String filiere = listEtudiant.get(i).getFiliere();

                df.addRow(new Object[]{id, nom, prenom, datNaissance, sexe, filiere});
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Erreur Serveur!!!",null,JOptionPane.ERROR_MESSAGE);
        }



        JLabel labelId = new JLabel("Etudiant ID ");
        labelId.setBounds(70,240,170,25);
        labelId.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelId);
            JTextField textId = new JTextField();
            textId.setBounds(200,240,140,25);
            panel.add(textId);

        JLabel labelHalaka = new JLabel("Halaka ID ");
        labelHalaka.setBounds( 70,300,170,25);
        labelHalaka.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelHalaka);
            JTextField textHalaka = new JTextField();
            textHalaka.setBounds(200,300,140,25);
            panel.add(textHalaka);

        JLabel labelNom = new JLabel("Nom ");
        labelNom.setBounds(70,270,170,25);
        labelNom.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelNom);
            JTextField textNom = new JTextField();
            textNom.setBounds(200,270,140,25);
            panel.add(textNom);

        JLabel labelDescription = new JLabel("Description ");
        labelDescription.setBounds(70,330,170,25);
        labelDescription.setFont(new Font("Arial",Font.BOLD,16));
        panel.add(labelDescription);

            JTextArea textDescription = new JTextArea();
            textDescription.setFont(new Font("Arial",Font.BOLD,11));

            scroll=new JScrollPane();
            scroll.setBounds(200,330,200,100);
            scroll.setViewportView(textDescription);
            panel.add(scroll);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateSeance = localDateTime.format(formatter);
        
        DefaultTableModel df1 = new DefaultTableModel();
        init1();
        panel.add(scroll2);

        df1.addColumn("Etudiant ID");
        df1.addColumn("Nom");
        df1.addColumn("Halaka Id");
        df1.addColumn("Date seance");
        df1.addColumn("Description");
        table1.setModel(df1);



        JButton btnEnrg = new JButton("ENREGISTRER");
        btnEnrg.setBounds(55,470,120,25);
        btnEnrg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom, description;
                String etudiant_ID, halaka_ID;
                etudiant_ID = textId.getText();
                halaka_ID = textHalaka.getText();
                nom = textNom.getText().toLowerCase();
                description = textDescription.getText();

                LocalDateTime localDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateSeance = localDateTime.format(formatter);

                if(!etudiant_ID.equals("")&&!nom.equals("")&&!halaka_ID.equals("")) {
                    try {
                        profSocket = new Socket("127.0.0.1", 5000);

                    //flux pour envoyer
                    Thread envoyer = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                oos = new ObjectOutputStream(profSocket.getOutputStream());
                                ois = new ObjectInputStream(profSocket.getInputStream());

                                abcense = new AbsenceEtudiant(dateSeance, description, etudiant_ID, halaka_ID);
                                oos.writeObject(abcense);
                                System.out.println("done");
                                profSocket.close();
                            }catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    envoyer.start();
                    df1.addRow(new Object[]{
                            etudiant_ID,
                            nom,
                            halaka_ID,
                            dateSeance,
                            description
                    });
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"Erreur Serveur!!!",null,JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Completez le formulaire!",null,JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnEnrg);

        //bouton pour actualiser la fenetre
        JButton btnActu=new JButton("ACTUALISER");
        btnActu.setBounds(250,470,120,25);
        btnActu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                dispose();
                GraphiquesProf tb= null;
                try {
                    tb = new GraphiquesProf();
                } catch (IOException e) {
                    e.printStackTrace();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                tb.setVisible(true);
            }
        });
        panel.add(btnActu);
    }

    private void init(/*Object[] [] data, String [] columns*/){
        table=new JTable();
        //JTable table = new JTable( data, columns);
        scroll1=new JScrollPane();
        scroll1.setBounds(200,70,600,120);
        scroll1.setViewportView(table);
    }

    private void init1(){
        table1=new JTable();
        scroll2=new JScrollPane();
        scroll2.setBounds(450,250,500,160);
        scroll2.setViewportView(table1);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GraphiquesProf prof = new GraphiquesProf();
        prof.setVisible(true);
    }
}