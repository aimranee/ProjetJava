package InterfaceGr.Prof;

import Administrative.Etudiant.Etudiants;
import ConnectionOracl.Connect;
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

public class GraphiquesProf extends JFrame {
    Statement st;
    ResultSet rs;
    JPanel panel = new JPanel();
    Connection con = Connect.getCon();
    JTable table,table1 = new JTable();
    JScrollPane scroll,scroll1,scroll2 = new JScrollPane();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public GraphiquesProf() {

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

        String req="select * from etudiant";
        try {
            st=con.createStatement();
            rs = st.executeQuery(req);
            while (rs.next()){
                df.addRow(new Object[]{
                    rs.getString("ID"),
                    rs.getString("NOM"),
                    rs.getString("PRENOM"),
                    rs.getString("Datnaissance"),
                    rs.getString("Sexe"),
                    rs.getString("Filiere")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erreur base de donnée !",null,JOptionPane.ERROR_MESSAGE);
        }
/*
        JLabel labelTitre2=new JLabel("Formulaire d'absences");
        labelTitre2.setBounds(50,200,800,30);
        labelTitre2.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(labelTitre2);

        DefaultTableModel df1 = new DefaultTableModel();
        init1();
        panel.add(scroll2);

        df1.addColumn("ID");
        df1.addColumn("Nom");
        df1.addColumn("Prenom");
        df1.addColumn("Datnaissance");
        df1.addColumn("Sexe");
        df1.addColumn("Filiere");
        table.setModel(df1);
        String req1="select * from etudiant";

        try {
            List<Etudiants> listEtudiant = new ArrayList<>();
            TraitementEtudaint listE = new TraitementEtudaint();
            listEtudiant = listE.getAllElements();
            Iterator<Etudiants> it = listEtudiant.iterator();

            /*while (it.hasNext()){
                df1.addRow(new Object[]{
                    rs.getString("ID"),
                    rs.getString("NOM"),
                    rs.getString("PRENOM"),
                    rs.getString("PRENOM"),
                    rs.getString("PRENOM"),
                    rs.getString("PRENOM")
                });
            }
            String[] columns = new String[] {
                    "ID", "Nom", "Prenom", "Datnaissance", "Sexe", "Filiere"
            };
            //DefaultTableModel tableModel = new DefaultTableModel(columns,0);
            JTable table = new JTable();

            String[][] data = null;

        String id,nom,prenom,datNaissance,sexe;
        Etudiants etu;
            while (it.hasNext()){
                etu = it.next();
                id=etu.getId();
                nom=etu.getNom();
                prenom=etu.getPrenom();
                datNaissance=etu.getDatNaissance();
                sexe=etu.getSexe();
                String filiere=etu.getFiliere();


            }
        for (int i=0, j=0;i< table.size();i+=2, j++){

            data[j][0] = table.get(i);
            data[j][1] = table.get(i+1);
        }
        init(data,columns);
        panel.add(scroll1);
        String[] entetes = new String[]{"Soiree", "Date", "NB Places Dispo", "Réserver"};

        String[][] donnees = new String[8][8];

        DefaultTableModel model = new DefaultTableModel(donnees,entetes);

        JTable tableau = new JTable(donnees, entetes);
*/

        //

            //DefaultTableModel df = new DefaultTableModel();

            //panel.add(scroll1);

        //} catch (SQLException e) {
          //  JOptionPane.showMessageDialog(null,"Erreur base de donnée !",null,JOptionPane.ERROR_MESSAGE);
        //}



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

                String etudiant_ID, nom, description, halaka_ID;
                etudiant_ID = textId.getText();
                halaka_ID = textHalaka.getText();
                nom = textNom.getText().toLowerCase();
                description = textDescription.getText();

                LocalDateTime localDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateSeance = localDateTime.format(formatter);

                if(!etudiant_ID.equals("")&&!nom.equals("")&&!halaka_ID.equals("")) {

                    final BufferedReader in;
                    final PrintWriter out;
                    try {

                        Socket profSocket = new Socket("127.0.0.1", 5000);

                        //flux pour envoyer
                        out = new PrintWriter(profSocket.getOutputStream());
                        //flux pour recevoir
                        in = new BufferedReader(new InputStreamReader(profSocket.getInputStream()));

                        Thread envoyer = new Thread(new Runnable() {

                            @Override
                            public void run() {

                                out.println(dateSeance);
                                out.println(description);
                                out.println(etudiant_ID);
                                out.println(halaka_ID);
                                out.flush();
                                System.out.println("done");

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
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,"ERREUR SERVER",null,JOptionPane.ERROR_MESSAGE);
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
                GraphiquesProf tb=new GraphiquesProf();
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
        //DefaultTableModel model = new DefaultTableModel(data,columns);
        //JTable tableau = new JTable(data, columns);
    }

    private void init1(){
        table1=new JTable();
        scroll2=new JScrollPane();
        scroll2.setBounds(450,250,500,160);
        scroll2.setViewportView(table1);
    }

    public static void main(String[] args) throws IOException {
        GraphiquesProf prof = new GraphiquesProf();
        prof.setVisible(true);
    }
}