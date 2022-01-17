package Dao;

import Educative.Presences.PresenceEtudiant;

import java.util.List;

public interface IDao <T>{
    boolean createElement (T O);
    boolean updateElement (T O);
    boolean suppElement (int O);
    T getElement (String id);

    //PresenceEtudiant getElement(int id);

    List<T> getAllElements ();
}
