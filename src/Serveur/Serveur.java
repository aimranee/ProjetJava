package Serveur;

import Educative.Absences.AbsenceEtudiant;
import Educative.Presences.PresenceEtudiant;
import InterfaceGr.Prof.TraitementProf;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur {

    public static void main(String[] test) {

        final ServerSocket serveurSocket;
        final Socket profSocket;
        final BufferedReader in;
        final PrintWriter out;

        try {
            System.out.println("syteme att...");
            serveurSocket = new ServerSocket(5000);
            profSocket = serveurSocket.accept();
            System.out.println("client connecter");
            out = new PrintWriter(profSocket.getOutputStream());
            in = new BufferedReader (new InputStreamReader (profSocket.getInputStream()));

            Thread recevoir= new Thread(new Runnable() {
                String msg ;
                @Override
                public void run() {
                    try {
                        //tant que le client est connecté
                        String date = in.readLine();
                        String desc = in.readLine();
                        String etud = in.readLine();
                        String hala = in.readLine();

                        AbsenceEtudiant absence = new AbsenceEtudiant(date, desc, etud, hala);
                        TraitementProf trait = new TraitementProf();
                        trait.createElement(absence);

                        //sortir de la boucle si le client a déconecté
                        System.out.println("Client déconecté");
                        //fermer le flux et la session socket


                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            profSocket.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            serveurSocket.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            recevoir.start();
        }catch (IOException e) {
            e.printStackTrace();

        }
    }
}