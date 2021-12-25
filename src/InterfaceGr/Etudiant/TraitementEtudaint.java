package InterfaceGr.Etudiant;

import Administrative.Etudiant.Etudiants;
import Dao.IDao;
import ConnectionOracl.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TraitementEtudaint implements IDao<Etudiants> {
	Connection con ;
	
    @Override
    public boolean createElement(Etudiants O) {
    	con = Connect.getCon();
		String req = "insert into clients(version,titre,nom,prenom) values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(req);
//			ps.setInt(1,O.getVersion());
//			ps.setString(2,O.getTitre());
			ps.setString(3,O.getNom());
			ps.setString(4,O.getPrenom());
			ps.executeUpdate();
			System.out.println("Bien Ajouter");
		    }catch(SQLException e) {
		    	e.printStackTrace();
		    }
        return true;
    }

    @Override
    public boolean updateElement(Etudiants O) {
        return false;
    }

    @Override
    public boolean suppElement(Etudiants O) {
        return false;
    }
    
    @Override
    public Etudiants getElement(int id) {
        return null;
    }

    @Override
    public List<Etudiants> getAllElements() {
        return null;
    }
}
