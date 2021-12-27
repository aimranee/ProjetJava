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
		String req = "insert into etudiant(Nom,Prenom,HalakaId) values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ps.setString(1,O.getNom());
			ps.setString(2,O.getPrenom());
			ps.setInt(3,O.getHalakaId());
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
 		String req = "update etudiant set Nom=?,Prenom=?,HalakaId=? where id=? and Nom=?";
 		try {
 			PreparedStatement ps = con.prepareStatement(req);
 			ps.setString(1,O.getNom());
 			ps.setString(2,O.getPrenom());
 			ps.setInt(3,O.getHalakaId());
 			ps.setInt(4,O.getId());
 			ps.setString(5,O.getNom());
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
			ps.setInt(1,O.getId());
			ps.executeUpdate();
			System.out.println("Bien supprimer");
		    }catch(SQLException e) {
		    	e.printStackTrace();
		    }
		
        return true;
    }
    
    @Override
    public Etudiants getElement(int id) {
    	Etudiants clt = null;
		 con = Connect.getCon();
		String req = "select * from etudiant where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(req);
			ps.setInt(1,id);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				 clt = new Etudiants(id,res.getString("Nom"),res.getString("Prenom"),res.getInt("HalakaId"));
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
				Etudiants p = new Etudiants(res.getInt("id"),res.getString("Nom"),res.getString("Prenom"),res.getInt("HalakaId"));
				lp.add(p);
			}
		}catch(SQLException e) {
	    	e.printStackTrace();
	    }
		return lp;
    }
    public static void main(String [] args) {
    	TraitementEtudaint fen = new TraitementEtudaint();
    	Etudiants et = new Etudiants("ghann","salah",1);
    	fen.createElement(et);
    }
}
