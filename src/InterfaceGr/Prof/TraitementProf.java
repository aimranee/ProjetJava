package InterfaceGr.Prof;

import ConnectionOracl.Connect;
import Dao.IDao;
import Educative.Absences.AbsenceEtudiant;

import javax.swing.*;
import java.sql.*;

import java.util.List;

public class TraitementProf implements IDao<AbsenceEtudiant> {
    Connection con ;

    @Override
    public boolean createElement(AbsenceEtudiant O) {
        con = Connect.getCon();
        String req = "insert into absenceetudiant values(absenceetudiant_seq.nextval,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setString(1,O.getDateAbsence());
            ps.setString(2,O.getDescription());
            ps.setString(3,O.getEtudiantId());
            ps.setString(4,O.getHalakaId());

            ps.executeUpdate();
            System.out.println("Bien Ajouter");
        }catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ID Etudiant ou ID halaka introuvable !!", null, JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    @Override
    public boolean updateElement(AbsenceEtudiant O) {
        return false;
    }

    @Override
    public boolean suppElement(int O) {
        return false;
    }

    @Override
    public AbsenceEtudiant getElement(String id) {
        return null;
    }

    @Override
    public List<AbsenceEtudiant> getAllElements() {
        return null;
    }

}
