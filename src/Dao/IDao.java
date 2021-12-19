package Dao;

import java.util.List;

public interface IDao <T>{
    boolean createElement (T O);
    boolean updateElement (T O);
    boolean suppElement (T O);
    T getElement (int id);
    List<T> getAllElements ();
}
