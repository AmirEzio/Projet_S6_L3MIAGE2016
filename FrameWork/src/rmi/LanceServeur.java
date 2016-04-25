package rmi;


import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class LanceServeur {


	public static void main(String[] args) {
		try {
			int port=1666 ;
			LocateRegistry.createRegistry(port);


			System.out.println("Mise en place du Security Manager ...");
			if (System.getSecurityManager() == null)
			{  
			     System.setSecurityManager(new RMISecurityManager());
			}
			SecurityManager mg = System.getSecurityManager();
			try{
				mg.checkAccept(InetAddress.getLocalHost().getHostAddress(), port);
			}
			catch(Exception e)
			{
				System.out.println("fail");
				
			}
			InformationImpl informationImpl = new InformationImpl();
			System.out.println("Ip local : " + InetAddress.getLocalHost());
			//String url = "rmi://152.77.82.112:"+port+ "/TestRMI";
			String url = "rmi://" + InetAddress.getLocalHost().getHostName()+":"+port+ "/TestRMI";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, informationImpl);

			System.out.println("Serveur lancé");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
