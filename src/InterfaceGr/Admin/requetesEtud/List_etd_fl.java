package InterfaceGr.Admin.requetesEtud;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConnectionOracl.Connect;

import java.sql.*;

public class List_etd_fl extends JFrame implements ActionListener{
	JLabel lab1,lab2;
	JComboBox jcb1,jcb2;
	JButton jb1,jb2,jb3;
	JTable tb;
	JScrollPane scrl;
	Statement st;
	ResultSet rst;
    Connection con = Connect.getCon();
	public List_etd_fl(){
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

			this.setTitle("liste des etudiants par matiere ");
			this.setSize(1000,600);
			this.setLocation(280,70);
			this.setResizable(false);
			JPanel pn=new JPanel();
			pn.setLayout(null);
			pn.setBackground(Color.cyan);
			add(pn);
			//
			lab1=new JLabel("LISTE DES ETUDIANTS PAR MATIERE");
			lab1.setBounds(190,10,480,45);
			lab1.setFont(new Font("Arial",Font.BOLD,25));
			lab1.setBorder(BorderFactory.createLineBorder(Color.black));
			pn.add(lab1);
		//label1
			lab1=new JLabel("MATIERE :");
			lab1.setBounds(60,80,80,30);
			lab1.setFont(new Font("Arial",Font.BOLD,15));
			pn.add(lab1);
		//combo1
			jcb1=new JComboBox();
			jcb1.addItem("Quran");
			jcb1.addItem("Mouton");
			jcb1.setBounds(140,80,80,30);
			pn.add(jcb1);
		
					jb1=new JButton("Recherche");
					jb1.setBounds(640,80,100,30);
					jb1.setBackground(Color.white);
					jb1.setForeground(Color.blue);
					jb1.addActionListener(this);
					pn.add(jb1);
				
				//
					DefaultTableModel df=new DefaultTableModel();
					init();
					df.addColumn("Matricule");
					df.addColumn("Nom");
					df.addColumn("Prenom");
					df.addColumn("DatNaissance");
					df.addColumn("Sexe");
					tb.setModel(df);
					pn.add(scrl);
		
	}
	private void init(){
		tb=new JTable();
		scrl=new JScrollPane();
		scrl.setViewportView(tb);
		scrl.setBounds(10,150,960,400);
		
	}
		public static void main(String[] args){
				
			List_etd_fl ls=new List_etd_fl();
				ls.setVisible(true);
			}
		
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==jb1){
		String a;
		a=jcb1.getSelectedItem().toString();
		DefaultTableModel df=new DefaultTableModel();
		df.addColumn("ID");
		df.addColumn("Nom");
		df.addColumn("Prenom");
		df.addColumn("DatNaissance");
		df.addColumn("Sexe");
		tb.setModel(df);
		String qry="select * from etudiant where filiere='"+a+"'";
				
		try{
			st=con.createStatement();
			rst=st.executeQuery(qry);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("id"),rst.getString("Nom"),
						rst.getString("Prenom"),rst.getString("datNaissance")
						,rst.getString("sexe")});
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"INTROUVABLE",null,JOptionPane.ERROR_MESSAGE);
		}
	}
}
}
