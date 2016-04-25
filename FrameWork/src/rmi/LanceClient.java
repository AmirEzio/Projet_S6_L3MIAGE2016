package rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class LanceClient {
	int port=1666 ;	
  public static void main(String[] args) {
    System.out.println("Lancement du client");
    if (System.getSecurityManager() == null)
	{  
	     System.setSecurityManager(new RMISecurityManager());
	}
//	SecurityManager mg = System.getSecurityManager();
//	try{
//		mg.checkAccept(InetAddress.getLocalHost().getHostAddress(),1666);
//	}
//	catch(Exception e)
//	{
//		System.out.println("fail");
//		
//	}
    
    try {
      Remote r = Naming.lookup("rmi://F216-12:1666/TestRMI");
     
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