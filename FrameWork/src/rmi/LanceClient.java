package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class LanceClient {

  public static void main(String[] args) {
    System.out.println("Lancement du client");
  //  if (System.getSecurityManager() == null) {
   //   System.setSecurityManager(new RMISecurityManager());
   // }
    try {
      Remote r = Naming.lookup("rmi://127.0.0.1/TestRMI");
     
      if (r instanceof Information) {
        String s = ((Information) r).getInformation();
        System.out.println("chaine renvoyee = " + s);
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (NotBoundException e) {
      e.printStackTrace();
    }
    System.out.println("Fin du client");
  }
}