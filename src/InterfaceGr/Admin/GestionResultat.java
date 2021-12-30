package InterfaceGr.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import ConnectionOracl.Connect;

import java.sql.*;

public class GestionResultat extends JFrame  implements ActionListener{
    Connection con = Connect.getCon();
	Statement st;
	ResultSet rst;
	JLabel lb0, lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lbid;
	JTextField jtf2,jtf3,jtf4,jtf5,jtf6,jtfid;
	JButton jb1,jb11,jb2,jb3,jb4,jb5,jb7,jb8,jb9;
    JRadioButton rb1,rb2;
    JComboBox jcb1,jcb2;
	JTable tb;
	JScrollPane scrl;
	
	
	public GestionResultat(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Gestion Resultat");
		this.setSize(1000,650);
		this.setResizable(false);
		this.setLocation(350,30);
	JPanel jp=new JPanel();
	jp.setLayout(null);
	jp.setBackground(Color.lightGray);
	add(jp);
	lb1=new JLabel("Interface Gestion Resultat");
	lb1.setFont(new Font("Arial",Font.BOLD,20));
	lb1.setForeground(Color.blue);
	lb1.setBounds(70,10,400,30);
	jp.add(lb1);
	
	lb0=new JLabel("NOTE");
	lb0.setFont(new Font("Arial",Font.BOLD,16));
	lb0.setForeground(Color.black);
	lb0.setBounds(150,50,100,30);
	jp.add(lb0);
	//id
	lbid=new JLabel("NoteID");
	lbid.setFont(new Font("Arial",Font.BOLD,15));
	lbid.setForeground(Color.blue);
	lbid.setBounds(60,100,100,30);
	jp.add(lbid);
	

	jtfid=new JTextField();
	jtfid.setBounds(130,100,150,30);
	jp.add(jtfid);
	
	// matricule
	lb2=new JLabel("Etudiant");
	lb2.setFont(new Font("Arial",Font.BOLD,15));
	lb2.setForeground(Color.blue);
	lb2.setBounds(55,140,100,30);
	jp.add(lb2);
	

	jtf2=new JTextField();
	jtf2.setBounds(130,140,150,30);
	jp.add(jtf2);
	
	
	// Identifiant matiere
	lb3=new JLabel("NoteQuran");
	lb3.setFont(new Font("Arial",Font.BOLD,15));
	lb3.setForeground(Color.blue);
	lb3.setBounds(60,180,100,30);
	jp.add(lb3);
	
	jtf3=new JTextField("0.0");
	jtf3.setBounds(130,180,150,30);
	jp.add(jtf3);
	// controle
		lb4=new JLabel("NoteMouton");
		lb4.setFont(new Font("Arial",Font.BOLD,15));
		lb4.setForeground(Color.blue);
		lb4.setBounds(60,220,100,30);
		jp.add(lb4);
		
		jtf4=new JTextField("0.0");
		jtf4.setBounds(130,220,150,30);
		jp.add(jtf4);
	// examen
		lb5=new JLabel("NoteGeneral");
		lb5.setFont(new Font("Arial",Font.BOLD,15));
		lb5.setForeground(Color.blue);
		lb5.setBounds(60,260,100,30);
		jp.add(lb5);
				
		jtf5=new JTextField("0.0");
		jtf5.setBounds(130,260,150,30);
		jp.add(jtf5);
	
	//travaux pratiques
		lb6=new JLabel("Commentaire");
		lb6.setFont(new Font("Arial",Font.BOLD,15));
		lb6.setForeground(Color.blue);
		lb6.setBounds(100,300,100,30);
		jp.add(lb6);
				
		jtf6=new JTextField("Observation");
		jtf6.setBounds(130,300,150,30);
		jp.add(jtf6);
		
	
			
	//les boutons
	  //insertion
	jb1=new JButton("Insertion BD");
	jb1.setBounds(130,390,90,30);
	jb1.setForeground(Color.blue);
	jb1.setBackground(Color.green);
	jb1.addActionListener(this);
	jp.add(jb1);
	jb11=new JButton("Insertion Fichier");
	jb11.setBounds(130,390,90,30);
	jb11.setForeground(Color.blue);
	jb11.setBackground(Color.green);
	jb11.addActionListener(this);
	jp.add(jb11);
	//supression
	jb2=new JButton("Suppression");
	jb2.setBounds(240,390,110,30);
	jb2.setForeground(Color.blue);
	jb2.setBackground(new Color(250,100,0));
	jb2.addActionListener(this);
	jp.add(jb2);
	//modification
	jb3=new JButton("Modification");
	jb3.setBounds(240,440,120,30);
	jb3.setForeground(Color.blue);
	jb3.setBackground(Color.orange);
	jb3.addActionListener(this);
	jp.add(jb3);
	//recherche
		jb4=new JButton("Recherche");
		jb4.setBounds(280,140,100,30);
		jb4.setForeground(Color.white);
		jb4.setBackground(Color.gray);
		jb4.addActionListener(this);
		jp.add(jb4);
	//actualiser
		jb5=new JButton("Actualiser");
		jb5.setBounds(100,440,120,30);
		jb5.setForeground(Color.blue);
		jb5.setBackground(Color.green);
		jb5.addActionListener(this);
		jp.add(jb5);
		
		//jbmatiere
				jb7=new JButton("Gestion Etudiant");
				jb7.setBounds(100,490,80,30);
				jb7.setForeground(Color.blue);
				jb7.setBackground(Color.white);
				jb7.addActionListener(this);
				jp.add(jb7);
		//jb note
			jb8=new JButton("Logout");
			jb8.setBounds(190,490,80,30);
			jb8.setForeground(Color.blue);
			jb8.setBackground(Color.white);
			jb8.addActionListener(this);
			jp.add(jb8);
		
//			//jb requetes
//			jb9=new JButton("Requetes");
//			jb9.setBounds(100,540,110,30);
//			jb9.setForeground(Color.blue);
//			jb9.setBackground(Color.white);
//			jb9.addActionListener(this);
//			jp.add(jb9);
		
		
		DefaultTableModel df=new DefaultTableModel();
		init();
		df.addColumn("NoteID");
		df.addColumn("Etudiant");
		df.addColumn("NoteQuran");
		df.addColumn("NoteMouton");
		df.addColumn("NoteGeneral");
		df.addColumn("Commentaire");
		tb.setModel(df);
		jp.add(scrl);
		
		String qry="select id,EtudiantId,NoteQuran,NoteMouton,NoteGeneral,Commentaire from resultat";
		try{
			st=con.createStatement();
			rst=st.executeQuery(qry);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("id"),rst.getString("EtudiantId"),rst.getString("NoteQuran"),rst.getString("NoteMouton"),rst.getString("NoteGeneral"),rst.getString("Commentaire")
						
				});
				
			}
		}
		catch(SQLException ex){
			
		}
			
	}
	private void init(){
		tb=new JTable();
		scrl=new JScrollPane();
		scrl.setViewportView(tb);
		scrl.setBounds(400,10,580,530);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionResultat nt=new GestionResultat();
		nt.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//ajout
		if(e.getSource()==jb1){
			String ao,a,b,c,d,f;
			a=jtf2.getText();b=jtf3.getText();c=jtf4.getText();d=jtf5.getText();f=jtf6.getText();
			ao=jtfid.getText();

		String qr="insert into resultat(id,EtudiantId,NoteQuran,NoteMouton,NoteGeneral,Commentaire) values('"+ao+"','"+a+"','"+b+"','"+c+"','"+d+"','"+f+"')";
		try{
			st=con.createStatement();
			if(JOptionPane.showConfirmDialog(this,"voulez vous ins�rer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				st.executeUpdate(qr);
				JOptionPane.showMessageDialog(this,"insertion reuissie!");
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"Echec insertion!",null,JOptionPane.ERROR_MESSAGE);
			
			
		}
			
		}
		/* ajouter dans le fichier */
		if(e.getSource()==jb11){
			String ao,a,b,c,d,f;
			a=jtf2.getText();b=jtf3.getText();c=jtf4.getText();d=jtf5.getText();f=jtf6.getText();
			ao=jtfid.getText();

		String qr="insert into note(id,EtudiantId,NoteQuran,NoteMouton,NoteGeneral,Commentaire) values('"+ao+"','"+a+"','"+b+"','"+c+"','"+d+"','"+f+"')";
		try{
			st=con.createStatement();
			if(JOptionPane.showConfirmDialog(this,"voulez vous ins�rer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				st.executeUpdate(qr);
				JOptionPane.showMessageDialog(this,"insertion reuissie!");
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"Echec insertion!",null,JOptionPane.ERROR_MESSAGE);
			
			
		}
			
		}
		//suppression
				if(e.getSource()==jb2){
					String ao;
					ao=jtfid.getText();
				String query="delete from resultat where id='"+ao+"'";
				try{
					st=con.createStatement();
					if(JOptionPane.showConfirmDialog(this,"Voulez vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(this,"Suppression reussie!");
					}
					
					
				}
				catch(SQLException ex){
					JOptionPane.showMessageDialog(this,"Echec suppression!",null,JOptionPane.ERROR_MESSAGE);
					
				}
					
				}//
				//modification
				if(e.getSource()==jb3){
					String ao,a,b,c,d,f;
			a=jtf2.getText();b=jtf3.getText();c=jtf4.getText();d=jtf5.getText();f=jtf6.getText();
			ao=jtfid.getText();
					
				String query="update resultat set EtudiantId='"+a+"', NoteQuran='"+b+"', NoteMouton='"+c+"', NoteGeneral='"+d+"', Commentaire='"+f+"' where id='"+ao+"' " ;
				try{
					st=con.createStatement();
					if(JOptionPane.showConfirmDialog(this,"Voulez vous modifier?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(this,"modification reussie!");
					}
					
					
				}
				catch(SQLException ex){
					JOptionPane.showMessageDialog(this,"Echec modification!",null,JOptionPane.ERROR_MESSAGE);
					
				}
					
				}//*/
				//recherche
				if(e.getSource()==jb4){
					String a;
					a=jtf2.getText();
				String query="select * from etudiant where matricule='"+a+"'";
				try{
					st=con.createStatement();
					rst=st.executeQuery(query);
					if(rst.next()){
						jtf2.setText(rst.getString("matricule"));
						jtf3.setText(rst.getString("nom"));
						jtf4.setText(rst.getString("prenom"));
						jtf5.setText(rst.getString("datnaissance"));
						//affichage dans le bouton radio
						if(rst.getString("sexe").equals("MASC"))
							rb1.setSelected(true);
						else
							rb2.setSelected(true);
						//affichage dans les combos
						//jcb.setSelectedItem(rst.getString("filiere"));
						jcb2.setSelectedItem(rst.getString("niveau"));	
					}
					else
						JOptionPane.showMessageDialog(this, "Introuvable!",null,JOptionPane.ERROR_MESSAGE);
					
					
				}
				catch(SQLException ex){
				
					
				}
					
				}//

				
		if(e.getSource()==jb5){
			this.dispose();
			GestionResultat cr=new GestionResultat();
			cr.setVisible(true);
			
		}
		
		
		if(e.getSource()==jb7){
			this.dispose();
			GraphiqueAdmin cr=new GraphiqueAdmin();
			cr.setVisible(true);
			
		}
		if(e.getSource()==jb8){
			this.dispose();
			loginForm logout=new loginForm();
			logout.setVisible(true);
			
		}
		
//		if(e.getSource()==jb9){
//			this.dispose();
//			 Requetes_liste ls=new  Requetes_liste();
//			ls.setVisible(true);
//			
//		}
	}

}
