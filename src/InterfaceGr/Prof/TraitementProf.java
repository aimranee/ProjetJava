package InterfaceGr.Prof;

import Administrative.Prof.Profs;
import ConnectionOracl.Connect;
import Dao.IDao;
import Educative.Absences.Absences;
import Educative.Presences.PresenceEtudiant;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;

public class TraitementProf implements IDao<PresenceEtudiant> {
    Connection con ;

    @Override
    public boolean createElement(PresenceEtudiant O) {
        con = Connect.getCon();
        String req = "insert into presence values(PRESENCE_seq.nextval,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1,O.getDescription());
            ps.setString(2,O.getNote());
            ps.setString(3,O.getDateSeance());
            ps.setString(4,O.getEtudiant_id());
            ps.setString(5,O.getHalaka_id());

            ps.executeUpdate();
            System.out.println("Bien Ajouter");
        }catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur!123", null, JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    @Override
    public boolean updateElement(PresenceEtudiant O) {
        return false;
    }

    @Override
    public boolean suppElement(PresenceEtudiant O) {
        return false;
    }

    @Override
    public PresenceEtudiant getElement(int id) {
        return null;
    }

    @Override
    public List<PresenceEtudiant> getAllElements() {
        return null;
    }

}
