package InterfaceGr.Admin;
import java.io.*;

import Administrative.Etudiant.Resultat;

public class SerialiseResul {

		public  void seriale(Resultat p) {
		try {
			FileOutputStream file = new FileOutputStream("ResultatEtudiant.txt");
			ObjectOutputStream ois = new ObjectOutputStream(file);
			try {
			ois.writeObject(p);
			ois.flush();
			System.out.println(p +" a ete serialise ");
			}finally {
				try {
					ois.close();
				}finally {
					file.close();
				}
			}
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
	}
	}
