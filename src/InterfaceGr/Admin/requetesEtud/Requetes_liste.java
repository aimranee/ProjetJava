package InterfaceGr.Admin.requetesEtud;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import InterfaceGr.Admin.GestionResultat;
import InterfaceGr.Admin.GraphiqueAdmin;


public class Requetes_liste  extends JFrame implements ActionListener {
	JLabel lab1;
	JButton jb0,jb00,jb1,jb2,jb3,jb4,jb5,jb6;
	public Requetes_liste(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,550);
		this.setResizable(false);
		this.setLocation(280,70);
		
		this.setTitle("liste des Requetes");
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(Color.lightGray);
		add(pn);
		//
		lab1=new JLabel("LISTE DE TOUTES LES REQUETES");
		lab1.setBounds(220,10,430,30);
		lab1.setFont(new Font("Arial",Font.BOLD,25));
		lab1.setBorder(BorderFactory.createLineBorder(Color.black));
		pn.add(lab1);
		//
		jb0=new JButton("Gestion de Resultat");
		jb0.setBounds(480,77,180,30);
		jb0.setBackground(Color.gray);
		jb0.setForeground(Color.white);
		jb0.addActionListener(this);
		pn.add(jb0);
		jb00=new JButton("Gestion des Etudiants");
		jb00.setBounds(480,120,180,30);
		jb00.setBackground(Color.gray);
		jb00.setForeground(Color.white);
		jb00.addActionListener(this);
		pn.add(jb00);
		//
		jb1=new JButton("Liste des étudiants par matiere");
		jb1.setBounds(40,80,340,30);
		jb1.setBackground(Color.white);
		jb1.setForeground(Color.blue);
		jb1.addActionListener(this);
		pn.add(jb1);
		//
		jb2=new JButton("Liste des matières d'une filière");
		jb2.setBounds(40,120,340,30);
		jb2.setBackground(Color.white);
		jb2.setForeground(Color.blue);
		jb2.addActionListener(this);
		pn.add(jb2);
		//
		jb3=new JButton("Liste des notes des étudiants dans une matière");
		jb3.setBounds(40,160,340,30);
		jb3.setBackground(Color.white);
		jb3.setForeground(Color.blue);
		jb3.addActionListener(this);
		pn.add(jb3);
		//
		jb4=new JButton("Liste des notes d'un étudiant dans ses matières");
		jb4.setBounds(40,200,340,30);
		jb4.setBackground(Color.white);
		jb4.setForeground(Color.blue);
		jb4.addActionListener(this);
		pn.add(jb4);
		//
		jb5=new JButton("Liste des moyennes des etudiants dans une matière");
		jb5.setBounds(40,240,340,30);
		jb5.setBackground(Color.white);
		jb5.setForeground(Color.blue);
		jb5.addActionListener(this);
		pn.add(jb5);
		//
		
	}
	public static void main(String[] args){
		
		Requetes_liste ls=new Requetes_liste();
		ls.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent p) {
		
		if(p.getSource()==jb0){
			GestionResultat au=new GestionResultat();
			this.dispose();
			au.setVisible(true);
			
		}
		if(p.getSource()==jb00){
			GraphiqueAdmin au=new GraphiqueAdmin();
			this.dispose();
			au.setVisible(true);
			
		}
		//
		if(p.getSource()==jb1){
			List_etd_fl ls=new List_etd_fl();
			ls.setVisible(true);
			
		}
		//
//		if(p.getSource()==jb2){
//			
//		}
		//
//		if(p.getSource()==jb3){
//		}
		//
//		if(p.getSource()==jb4){
//			
//		}
		//
//		if(p.getSource()==jb5){
//			
//		}
		//
		
		
	}

}
