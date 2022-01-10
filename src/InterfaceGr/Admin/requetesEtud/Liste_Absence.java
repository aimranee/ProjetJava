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

public class Liste_Absence extends JFrame implements ActionListener{
	
    Connection con = Connect.getCon();
	public Liste_Absence(){
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			
			this.setTitle("liste des Absences ");
			this.setSize(1000,600);
			this.setLocation(280,70);
			this.setResizable(false);
			JPanel pn=new JPanel();
			pn.setLayout(null);
			pn.setBackground(Color.gray);
			add(pn);
			//
			lab1=new JLabel("liste des Absences");
			lab1.setBounds(190,10,480,45);
			lab1.setForeground(Color.black);
			lab1.setFont(new Font("Arial",Font.BOLD,20));
			lab1.setBorder(BorderFactory.createLineBorder(Color.black));
		
					jb1=new JButton("Recherche");
					jb1.setBounds(640,80,100,30);
					jb1.setBackground(Color.DARK_GRAY);
					jb1.setForeground(Color.orange);
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
				
			Liste_Absence ls=new Liste_Absence();
				ls.setVisible(true);
			}
			
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
//			String a;
//			a=jcb1.getSelectedItem().toString();
			DefaultTableModel df=new DefaultTableModel();
			df.addColumn("ID");
			df.addColumn("DateAbsence");
			df.addColumn("Description");
			df.addColumn("EtudiantID");
			df.addColumn("HalakaID");
			tb.setModel(df);
			String qry="select * from absenceetudiant ";
				
		try{
			st=con.createStatement();
			rst=st.executeQuery(qry);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("id"),rst.getString("DateAbsence"),
						rst.getString("Description"),rst.getString("etudiantID")
						,rst.getString("halaka_id")});
			}
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"INTROUVABLE",null,JOptionPane.ERROR_MESSAGE);
		}
	}
}
			JLabel lab1,lab2;
			JComboBox jcb1,jcb2;
			JButton jb1,jb2,jb3;
			JTable tb;
			JScrollPane scrl;
			Statement st;
			ResultSet rst;
}
