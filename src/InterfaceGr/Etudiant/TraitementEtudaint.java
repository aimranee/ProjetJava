package InterfaceGr.Etudiant;

import Administrative.Etudiant.Etudiants;
import Dao.IDao;
import ConnectionOracl.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraitementEtudaint implements IDao<Etudiants> {
	Connection con ;
	
    @Override
    public boolean createElement(Etudiants O) {
    	con = Connect.getCon();
		String req = "insert into etudiant(Nom,Prenom,datNaissance,sexe,filiere) values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ps.setString(1,O.getNom());
			ps.setString(2,O.getPrenom());
			ps.setString(3,O.getDatNaissance());
			ps.setString(4,O.getSexe());
			ps.setString(5,O.getFiliere());
			ps.executeUpdate();
			System.out.println("Bien Ajouter");
		    }catch(SQLException e) {
		    	e.printStackTrace();
		    }
        return true;
    }

    @Override
    public boolean updateElement(Etudiants O) {
    	
    	 con = Connect.getCon();
 		String req = "update etudiant set Nom=?,Prenom=? ,datNaissance=? ,sexe=? ,filiere=? where id=?";
 		try {
 			PreparedStatement ps = con.prepareStatement(req);
 			ps.setString(1,O.getNom());
 			ps.setString(2,O.getPrenom());
 			ps.setString(3,O.getDatNaissance());
 			ps.setString(4,O.getSexe());
 			ps.setString(5,O.getFiliere());
 			ps.setString(6,O.getId());
 			ps.executeUpdate();			
 			System.out.println("Bien Modifier");
 		    }catch(SQLException e) {
 		    	e.printStackTrace();
 		    }
 		
        return true;
    }

    @Override
    public boolean suppElement(Etudiants O) {
    	con = Connect.getCon();
		String req = "delete from etudiant where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ps.setString(1,O.getId());
			ps.executeUpdate();
			System.out.println("Bien supprimer");
		    }catch(SQLException e) {
		    	e.printStackTrace();
		    }
		
        return true;
    }
    
    @Override
    public Etudiants getElement(String id) {
    	Etudiants clt = null;
		 con = Connect.getCon();
		String req = "select * from etudiant where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ps.setString(1,id);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				 clt = new Etudiants(id,res.getString("Nom"),res.getString("Prenom"),res.getString("datNaissance"),res.getString("sexe"),res.getString("filiere"));
			}
		}catch(SQLException e) {
	    	e.printStackTrace();
	    }
		return clt;
    }

    @Override
    public List<Etudiants> getAllElements() {
    	List<Etudiants> lp = new ArrayList<Etudiants>();
		 con = Connect.getCon();
		String req = "select * from etudiant";
		try {
			PreparedStatement pst = con.prepareStatement(req);
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				Etudiants p = new Etudiants(res.getString("id"),res.getString("Nom"),res.getString("Prenom"),res.getString("datNaissance"),res.getString("sexe"),res.getString("filiere"));
				lp.add(p);
			}
		}catch(SQLException e) {
	    	e.printStackTrace();
	    }
		return lp;
    }
//    public static void main(String [] args) {
//    	TraitementEtudaint fen = new TraitementEtudaint();
//    	Etudiants et = new Etudiants(1,"hamza","toto");
//    	List<Etudiants> lp = new ArrayList<Etudiants>();
//    	lp= fen.getAllElements();
//    	System.out.println(lp);
//    }
}
