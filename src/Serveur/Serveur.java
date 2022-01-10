package Serveur;

import Administrative.Etudiant.Etudiants;
import Educative.Absences.AbsenceEtudiant;
import Educative.Presences.PresenceEtudiant;
import InterfaceGr.Etudiant.TraitementEtudaint;
import InterfaceGr.Prof.TraitementProf;
import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serveur implements Serializable{
    static ServerSocket socketserver = null;
    
    static Socket profSocket;
    static ObjectInputStream ois = null;
    static ObjectOutputStream oos = null;
    static AbsenceEtudiant absence;

    public static void main(String[] test) throws IOException {

        try {
            System.out.println("syteme att...");
            socketserver = new ServerSocket(5000);
            boolean i=true;
        while (true){

            profSocket = socketserver.accept();
            System.out.println("client connecter");
            oos = new ObjectOutputStream(profSocket.getOutputStream());
            ois = new ObjectInputStream(profSocket.getInputStream());
            Thread recevoir= new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        absence = (AbsenceEtudiant) ois.readObject();
                        //tant que le client est connecté
                        String date = absence.getDateAbsence();
                        String desc = absence.getDescription();
                        String etud = absence.getEtudiantId();
                        String hala = absence.getHalakaId();

                        AbsenceEtudiant absence = new AbsenceEtudiant(date, desc, etud, hala);
                        TraitementProf trait = new TraitementProf();
                        trait.createElement(absence);
                        
                        /* traitement admin ajouter */
                        
                       
                        //sortir de la boucle si le client a déconecté
                        System.out.println("Client déconecté");
//                        System.exit(-1);
                        //fermer le flux et la session socket
                        profSocket.close();

                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        try {
                            profSocket.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            socketserver.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            recevoir.start();

            if (i==true){
                Thread envoie= new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Etudiants> listEtudiant = new ArrayList<Etudiants>();
                        TraitementEtudaint listE = new TraitementEtudaint();
                        listEtudiant = listE.getAllElements();
                        try {
                            oos.writeObject(listEtudiant);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                });
                envoie.start();
                i=false;
            }




            //profSocket.close();
        }
        }catch (IOException e) {
            e.printStackTrace();
            socketserver.close();


        }

    }
}
