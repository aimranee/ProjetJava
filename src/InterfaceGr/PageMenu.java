package InterfaceGr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import InterfaceGr.Admin.GraphiqueAdmin;

public class PageMenu extends JFrame  implements ActionListener{

	
	
	
	public PageMenu(){
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			this.setTitle("Page Menu");
			this.setSize(580,290);
			this.setResizable(false);
			this.setLocation(350,220);
			JPanel jp=new JPanel();
			jp.setLayout(null);
			jp.setBackground(Color.lightGray);
			add(jp);
			lb1=new JLabel("Choisir la Gestion que vous voulez");
			lb1.setFont(new Font("Arial",Font.BOLD,25));
			lb1.setForeground(Color.blue);
			lb1.setBounds(90,30,420,30);
			jp.add(lb1);

			jb1=new JButton("Gestion des etudiants");
			jb1.setBounds(100,110,190,60);
			jb1.setForeground(Color.white);
			jb1.setFont(new Font("Arial",Font.BOLD,15));
			jb1.setBackground(new Color(51, 102, 255));
			jb1.addActionListener(this);
			jp.add(jb1);
	
			jb2=new JButton("Gestion des profs");
			jb2.setBounds(300,110,190,60);
			jb2.setForeground(Color.white);
			jb2.setFont(new Font("Arial",Font.BOLD,15));
			jb2.setBackground(new Color(51, 102, 255));
			jb2.addActionListener(this);
			jp.add(jb2);
			}
	
					public static void main(String[] args) {
						PageMenu igr=new PageMenu();
						igr.setVisible(true);
				
					}

			@Override
			public void actionPerformed(ActionEvent e) {
						
					//			gestion etudiant
				if(e.getSource()==jb1 ){
					GraphiqueAdmin gad = new GraphiqueAdmin();
					gad.setVisible(true);
					this.dispose();
				}
				if(e.getSource()==jb2 ){
						JOptionPane.showMessageDialog(this,"Cette Partie est en cours de traitement");
					}
				}
			
			JLabel lb0, lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
			JTextField jtf2,jtf3,jtf4,jtf5;
			JButton jb1,jb2,jb3,jb4,jb5,jb7,jb8,jb9,jb10;
		    JRadioButton rb1,rb2;
			JTable tb;
			JScrollPane scrl;
	}


