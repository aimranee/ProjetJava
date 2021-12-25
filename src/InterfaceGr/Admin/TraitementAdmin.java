package InterfaceGr.Admin;

import Administrative.Admin.Admin;
import Dao.IDao;

import java.util.List;

public class TraitementAdmin implements IDao<Admin> {
    @Override
    public boolean createElement(Admin O) {
        return false;
    }

    @Override
    public boolean updateElement(Admin O) {
        return false;
    }

    @Override
    public boolean suppElement(Admin O) {
        return false;
    }

    @Override
    public Admin getElement(int id) {
        return null;
    }

    @Override
    public List<Admin> getAllElements() {
        return null;
    }

}
