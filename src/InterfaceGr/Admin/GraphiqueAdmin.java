
package InterfaceGr.Admin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Administrative.Etudiant.Etudiants;
import ConnectionOracl.Connect;
import Educative.Absences.AbsenceEtudiant;
import InterfaceGr.Admin.requetesEtud.Liste_Absence;
import InterfaceGr.Etudiant.TraitementEtudaint;

import java.sql.*;

public class GraphiqueAdmin extends JFrame  implements ActionListener{
    Connection con = Connect.getCon();
	
	
	public GraphiqueAdmin(){
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			this.setTitle("Gestion Etudiant");
			this.setSize(1000,650);
			this.setResizable(false);
			this.setLocation(220,70);
			
			JPanel jpanelG=new JPanel();
			jpanelG.setLayout(null);
			jpanelG.setBackground(Color.lightGray);
			add(jpanelG);
				
			label1=new JLabel("Interface Gestion Etudiant");
			label1.setFont(new Font("Arial",Font.BOLD,20));
			label1.setForeground(Color.blue);
			label1.setBounds(70,10,400,30);
			jpanelG.add(label1);
	
				label0=new JLabel("ETUDIANT");
				label0.setFont(new Font("Arial",Font.ROMAN_BASELINE,16));
				label0.setForeground(Color.black);
				label0.setBounds(150,50,100,30);
				jpanelG.add(label0);
	
				// id
				
			lb2=new JLabel("Id");
			lb2.setFont(new Font("Arial",Font.ITALIC,15));
			lb2.setForeground(Color.blue);
			lb2.setBounds(85,90,100,30);
			jpanelG.add(lb2);jtf2=new JTextField();
			jtf2.setBounds(130,90,150,30);
			jpanelG.add(jtf2);
			
	
				// Nom
			lb3=new JLabel("Nom");
			lb3.setFont(new Font("Arial",Font.ITALIC,15));
			lb3.setForeground(Color.blue);
			lb3.setBounds(80,130,100,30);
			jpanelG.add(lb3);
	
			jtf3=new JTextField();
			jtf3.setBounds(130,130,150,30);
			jpanelG.add(jtf3);
			
	// Prenom
			lb4=new JLabel("Prenom");
			lb4.setFont(new Font("Arial",Font.ITALIC,15));
			lb4.setForeground(Color.blue);
			lb4.setBounds(60,170,100,30);
			jpanelG.add(lb4);
		
			jtf4=new JTextField();
			jtf4.setBounds(130,170,150,30);
			jpanelG.add(jtf4);
			
	// datNais
			lb5=new JLabel("DatNaissance");
			lb5.setFont(new Font("Arial",Font.ITALIC,15));
			lb5.setForeground(Color.blue);
			lb5.setBounds(20,210,100,30);
			jpanelG.add(lb5);
				
			jtf5=new JTextField("JJ-MM-AAAA");
			jtf5.setBounds(130,210,150,30);
			jpanelG.add(jtf5);
			
	//sexe
			lb6=new JLabel("Sexe");
			lb6.setFont(new Font("Arial",Font.ITALIC,15));
			lb6.setForeground(Color.blue);
			lb6.setBounds(75,250,100,30);
			jpanelG.add(lb6);
		
			rb1=new JRadioButton("MASC");
			rb1.setBounds(130,250,80,25);
		
			rb2=new JRadioButton("FEM");
			rb2.setBounds(210,250,70,25);
			jpanelG.add(rb1);
			jpanelG.add(rb2);
			ButtonGroup bg=new ButtonGroup();
			bg.add(rb1);
			bg.add(rb2);
			
	//filiere
			lb7=new JLabel("Filiere");
			lb7.setFont(new Font("Arial",Font.ITALIC,15));
			lb7.setForeground(Color.blue);
			lb7.setBounds(65,290,100,30);
			jpanelG.add(lb7);
			jcb=new JComboBox();
			jcb.addItem("Quran");
			jcb.addItem("Mouton");
			jcb.setBounds(130,290,100,25);
			jpanelG.add(jcb);
			
	//les boutons
						//insertion
			jb1=new JButton("Insertion");
			jb1.setBounds(100,390,120,30);
			jb1.setForeground(Color.blue);
			jb1.setBackground(Color.orange);
			jb1.addActionListener(this);
			jpanelG.add(jb1);
			
						//supression
			jb2=new JButton("Suppression");
			jb2.setBounds(240,390,120,30);
			jb2.setForeground(Color.blue);
			jb2.setBackground(Color.orange);
			jb2.addActionListener(this);
			jpanelG.add(jb2);
			
						//modification
			jb3=new JButton("Modification");
			jb3.setBounds(240,440,120,30);
			jb3.setForeground(Color.blue);
			jb3.setBackground(Color.orange);
			jb3.addActionListener(this);
			jpanelG.add(jb3);
			
						//recherche
			jb4=new JButton("Recherche");
			jb4.setBounds(280,90,100,30);
			jb4.setForeground(Color.white);
			jb4.setBackground(Color.orange);
			jb4.addActionListener(this);
			jpanelG.add(jb4);
			
						//actualiser
			jb5=new JButton("Actualiser");
			jb5.setBounds(100,440,120,30);
			jb5.setForeground(Color.blue);
			jb5.setBackground(Color.green);
			jb5.addActionListener(this);
			jpanelG.add(jb5);
		
						//Logout
			jb7=new JButton("Logout");
			jb7.setBounds(100,490,120,30);
			jb7.setForeground(Color.orange);
			jb7.setBackground(Color.gray);
			jb7.addActionListener(this);
			jpanelG.add(jb7);
				
					//Gestion_Resultat
			jb8=new JButton("Gestion_Resultat");
			jb8.setBounds(240,490,140,30);
			jb8.setForeground(Color.orange);
			jb8.setBackground(Color.gray);
			jb8.addActionListener(this);
			jpanelG.add(jb8);
			
			jb11=new JButton("Liste_Absence");
			jb11.setBounds(100,540,120,30);
			jb11.setForeground(Color.orange);
			jb11.setBackground(Color.gray);
			jb11.addActionListener(this);
			jpanelG.add(jb11);

		DefaultTableModel df=new DefaultTableModel();
		init();
		df.addColumn("Id");
		df.addColumn("Nom");
		df.addColumn("Prenom");
		df.addColumn("DatNaissance");
		df.addColumn("Sexe");
		df.addColumn("Filiere");
		tb.setModel(df);
		jpanelG.add(scrollp);
		
		
			String qry="select * from etudiant";
			try{
				st=con.createStatement();
				rst=st.executeQuery(qry);
				while(rst.next()){
					df.addRow(new Object[]{
							rst.getString("id"),rst.getString("Nom"),rst.getString("Prenom"),rst.getString("datNaissance")
							,rst.getString("sexe"),rst.getString("filiere")});
				}
			}
			catch(SQLException ex){
				System.out.println("error dans export donnee from bd");
			}}
	
				private void init(){
					tb=new JTable();
					scrollp=new JScrollPane();
					scrollp.setViewportView(tb);
					scrollp.setBounds(400,10,580,530);
				}

				public static void main(String[] args) {
					GraphiqueAdmin igr=new GraphiqueAdmin();
					igr.setVisible(true);
			
				}

	@Override
	public void actionPerformed(ActionEvent e) {
		
					//ajout
		
				if(e.getSource()==jb1){
					String a, b,c,d,f,g,h;
				a=jtf2.getText();b=jtf3.getText();c=jtf4.getText();d=jtf5.getText();
				if(rb1.isSelected()) f=rb1.getText(); else f=rb2.getText();
				g=jcb.getSelectedItem().toString();
				try{
					TraitementEtudaint fen = new TraitementEtudaint();
					 Etudiants  etudiant = new Etudiants(a,b,c,d,f,g);
					if(JOptionPane.showConfirmDialog(this,"Voulez vous ajoutez?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
						fen.createElement(etudiant);
						JOptionPane.showMessageDialog(this,"Insertion reussie!");
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this,"Echec insertion!",null,JOptionPane.ERROR_MESSAGE);
				}}
				
					//suppression
				
				if(e.getSource()==jb2){
					int a;
					a=Integer.parseInt(jtf2.getText());
					TraitementEtudaint fen = new TraitementEtudaint();

					//String query="delete from etudiant where id='"+a+"'";
					try{
						//st=con.createStatement();
						if(JOptionPane.showConfirmDialog(this,"Voulez vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
							//st.executeUpdate(query);
							fen.suppElement(a);
							JOptionPane.showMessageDialog(this,"Suppression reussie!");
						}
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(this,"Echec suppression!",null,JOptionPane.ERROR_MESSAGE);
					}
				}
				
				//modification
				
				if(e.getSource()==jb3){
					String a,b,c,d,f,g;
				a= jtf2.getText();b=jtf3.getText();c=jtf4.getText();d=jtf5.getText();
				if(rb1.isSelected()) f=rb1.getText(); else f=rb2.getText();
				g=jcb.getSelectedItem().toString();
				try{
					TraitementEtudaint fen = new TraitementEtudaint();
			    	Etudiants et = new Etudiants(a,b,c,d,f,g);					
			    	if(JOptionPane.showConfirmDialog(this,"Voulez vous modifier?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
			    		fen.updateElement(et);
						JOptionPane.showMessageDialog(this,"modification reussie!");
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this,"Echec modification!",null,JOptionPane.ERROR_MESSAGE);
				}}
				
				//recherche
				
				if(e.getSource()==jb4){
					String a;
					a=jtf2.getText();
				String query="select * from etudiant where id='"+a+"'";
				try{
					st=con.createStatement();
					rst=st.executeQuery(query);
					if(rst.next()){
						jtf2.setText(rst.getString("id"));
						jtf3.setText(rst.getString("Nom"));
						jtf4.setText(rst.getString("Prenom"));
						jtf5.setText(rst.getString("datNaissance"));
						
						//affichage dans le bouton radio
						
						if(rst.getString("sexe").equals("MASC"))
							rb1.setSelected(true);
						else
							rb2.setSelected(true);
						jcb.setSelectedItem(rst.getString("filiere"));
					}
					else
						JOptionPane.showMessageDialog(this, "Introuvable!",null,JOptionPane.ERROR_MESSAGE);
				}
				catch(SQLException ex){
				}}

				//					admin 
				
			if(e.getSource()==jb5){
				this.dispose();
				GraphiqueAdmin cr=new GraphiqueAdmin();
				cr.setVisible(true);
			}
		
				//			login 
			
			if(e.getSource()==jb7){
				if(JOptionPane.showConfirmDialog(this,"Voulez vous vraiment se deconnecte?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
					this.dispose();
					loginForm logout =new loginForm();
					logout.setVisible(true);
				}
			}
				//			resultats
			
			if(e.getSource()==jb8){
				this.dispose();
				GestionResultat nt=new GestionResultat();
				nt.setVisible(true);
			}
			if(e.getSource()==jb11){
				Liste_Absence nt=new Liste_Absence();
				nt.setVisible(true);
			}
	}
	
	JLabel label0, label1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
	JTextField jtf2,jtf3,jtf4,jtf5;
	JButton jb1,jb2,jb3,jb4,jb5,jb7,jb8,jb9,jb10,jb11;
    JRadioButton rb1,rb2;
    JComboBox jcb,jcb2;
	JTable tb;
	JScrollPane scrollp;
	Statement st;
	ResultSet rst;

}
