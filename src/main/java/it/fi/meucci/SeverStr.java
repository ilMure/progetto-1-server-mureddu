package it.fi.meucci;
import java.io.*;
import java.net.*;
import java.util.*;

public class SeverStr {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaRisposta = null;
    BufferedReader inDalClient = null;
    DataOutputStream outVersoClient;

    public Socket attendi(){
        try {
            System.out.println("1 SERVER is running");
            server = new ServerSocket(7000);
            client = server.accept();
            server.close();
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            System.out.println("Errore durante istanza del server");
        }
        return client;
    }

    public void comunica(){
        try {
            System.out.println("3 ciao client, scrivi una frase che trasfermerò in maiuscolo. Sono in attesa...");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("6 ricevuta la stringa del cliente: " + stringaRicevuta);   

            stringaRisposta = stringaRicevuta.toUpperCase();
            System.out.println("7 invio la stringa di risposta al client...");
            outVersoClient.writeBytes(stringaRisposta+"\n");
        } catch (Exception e) {
            System.out.println("Errore durante la comunicazione");
        }
        
    }
}
