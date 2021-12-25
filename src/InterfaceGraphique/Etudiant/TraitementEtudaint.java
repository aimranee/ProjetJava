package InterfaceGraphique.Etudiant;

import Administrative.Etudiant.Etudiants;
import Dao.IDao;
import ConnectionOracl.ConnectionOracl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TraitementEtudaint implements IDao<Etudiants> {

    @Override
    public boolean createElement(Etudiants O) {
    	
        return false;
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
