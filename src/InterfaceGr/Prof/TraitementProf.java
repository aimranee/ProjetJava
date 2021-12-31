package InterfaceGr.Prof;

import ConnectionOracl.Connect;
import Dao.IDao;
import Educative.Absences.AbsenceEtudiant;

import javax.swing.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class TraitementProf implements IDao<AbsenceEtudiant> {
    Connection con ;

    @Override
    public boolean createElement(AbsenceEtudiant O) {
        con = Connect.getCon();
        String req = "insert into presence values(absenceEtudiant_seq.nextval,?,?,?,?,?)";
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
            JOptionPane.showMessageDialog(null, "Erreur!123", null, JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    @Override
    public boolean updateElement(AbsenceEtudiant O) {
        return false;
    }

    @Override
    public boolean suppElement(AbsenceEtudiant O) {
        return false;
    }

    @Override
    public AbsenceEtudiant getElement(String id) {
        return null;
    }


    @Override
    public List<AbsenceEtudiant> getAllElements() {
        List<AbsenceEtudiant> listAbsences = new ArrayList<>();
        con = Connect.getCon();
        String req = "SELECT * FROM Etudiant";
        try{
            PreparedStatement ps = con.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                AbsenceEtudiant P = new AbsenceEtudiant (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                listAbsences.add(P);
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return listAbsences;
    }

}
