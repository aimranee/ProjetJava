package Serveur;

import Administrative.Etudiant.Etudiants;
import Educative.Absences.AbsenceEtudiant;
import Educative.Presences.PresenceEtudiant;
import InterfaceGr.Prof.TraitementProf;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur implements Serializable{
    static ServerSocket socketserver = null;
    static Socket profSocket;
    static ObjectInputStream ois = null;
    static ObjectOutputStream oos = null;
    static AbsenceEtudiant absence;

    public static void main(String[] test) {

        try {
            System.out.println("syteme att...");
            socketserver = new ServerSocket(5000);
        while (true){
            Thread recevoir= new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        profSocket = socketserver.accept();
                        System.out.println("client connecter");
                        oos = new ObjectOutputStream(profSocket.getOutputStream());
                        ois = new ObjectInputStream(profSocket.getInputStream());

                        absence = (AbsenceEtudiant) ois.readObject();
                        //tant que le client est connecté
                        String date = absence.getDateAbsence();
                        String desc = absence.getDescription();
                        String etud = absence.getEtudiantId();
                        String hala = absence.getHalakaId();

                        AbsenceEtudiant absence = new AbsenceEtudiant(date, desc, etud, hala);
                        TraitementProf trait = new TraitementProf();
                        trait.createElement(absence);

                        //sortir de la boucle si le client a déconecté
                        System.out.println("Client déconecté");
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
        }
        }catch (IOException e) {
            e.printStackTrace();

        }
    }
}
