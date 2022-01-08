package InterfaceGr.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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

import Administrative.Etudiant.Resultat;
import ConnectionOracl.Connect;

import java.sql.*;

public class DeserialiseResul extends JFrame implements ActionListener{
	JLabel lable1,lab2;JComboBox jcb1,jcb2;
	JButton jb1,jb2,jb3;
	JTable table;
	JScrollPane scrl;
	Statement st;
	ResultSet rst;
    Connection con = Connect.getCon();
	public DeserialiseResul(){

			this.setTitle("Les Donnees dans le fichier");
			this.setSize(1000,600);
			this.setLocation(280,70);
			this.setResizable(false);
			JPanel pn=new JPanel();
			pn.setLayout(null);
			pn.setBackground(Color.gray);
			add(pn);
			//
			lable1=new JLabel("Les Donnees inserer dans le fichier");
			lable1.setBounds(190,10,480,45);
			lable1.setForeground(Color.blue);
			lable1.setFont(new Font("Arial",Font.BOLD,25));
			lable1.setBorder(BorderFactory.createLineBorder(Color.black));
			pn.add(lable1);
		//label1
			
		
					jb1=new JButton("Recherche");
					jb1.setBounds(640,80,100,30);
					jb1.setBackground(Color.DARK_GRAY);
					jb1.setForeground(Color.orange);
					jb1.addActionListener(this);
					pn.add(jb1);
				
				//
					DefaultTableModel df=new DefaultTableModel();
					init();
					df.addColumn("NoteID");
					df.addColumn("Etudiant");
					df.addColumn("NoteQuran");
					df.addColumn("NoteMouton");
					df.addColumn("NoteGeneral");
					df.addColumn("Commentaire");
					table.setModel(df);
					pn.add(scrl);
		
	}
	private void init(){
		table=new JTable();
		scrl=new JScrollPane();
		scrl.setViewportView(table);
		scrl.setBounds(10,150,960,400);
		
	}
		public static void main(String[] args){
				
			DeserialiseResul ls=new DeserialiseResul();
				ls.setVisible(true);
			}
		
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == jb1) {
		
	
		DefaultTableModel df=new DefaultTableModel();
		df.addColumn("NoteID");
		df.addColumn("Etudiant");
		df.addColumn("NoteQuran");
		df.addColumn("NoteMouton");
		df.addColumn("NoteGeneral");
		df.addColumn("Commentaire");
		table.setModel(df);
		
		Resultat s = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ResultatEtudiant.txt"));
		
				s = (Resultat) ois.readObject();
			
			}catch(IOException ioe) {
				ioe.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		if(s != null) {
			System.out.println(s +" a ete deserialise ");
		}
				
		try{
			
			
				df.addRow(new Object[]{
						s.getId(),s.getEtudiantId(),
						s.getNoteQuran(),s.getNoteMouton()
						,s.getNoteGeneral(),s.getCommentaire()});
			
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this,"INTROUVABLE",null,JOptionPane.ERROR_MESSAGE);
		}
	
}
}
}
