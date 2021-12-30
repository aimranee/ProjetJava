package InterfaceGr.Prof;

import Administrative.Prof.Profs;
import Dao.IDao;

import java.util.List;

public class TraitementProf implements IDao<Profs> {
    @Override
    public boolean createElement(Profs O) {
        return false;
    }

    @Override
    public boolean updateElement(Profs O) {
        return false;
    }

    @Override
    public boolean suppElement(Profs O) {
        return false;
    }

    @Override
    public Profs getElement(String id) {
        return null;
    }

    @Override
    public List<Profs> getAllElements() {
        return null;
    }
}
