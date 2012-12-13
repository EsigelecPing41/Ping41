package Modele;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion 
{
	final static String url = "jdbc:mysql://localhost/__BDD__";
	final static String login="root";
	final static String pass="";
	Connection con = null;
	
	public Connexion()
	{
		
		// chargement du pilote sqlServer
		try 
		{
			Class.forName("com.sqlserver.jdbc.Driver");
		} 
		catch (ClassNotFoundException e2) 
		{
			System.out.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier mysql-connector-java-XXXX.jar dans le projet");
		}
		
		try 
		{
			
			con = DriverManager.getConnection(url, login, pass);
			
			
	     } 
		catch (Exception e)
	     {
			e.printStackTrace();
	     } 
	}
	
	public Connection getConnection(){
		
		return this.con;
	}
}
