package dao;

import java.sql.*;

public class Connexion 
{
	//SQL SERVER
	//final static String url = "jdbc:mysql://localhost/__BDD__";
	//Mysql
	final static String url = "jdbc:sqlserver://10.20.0.103:1433;database=skftraceability";
	final static String login="root";
	final static String pass="root";
	Connection con = null;
	
	public Connexion() throws Exception
	{
		// chargement du pilote sqlServer
		try
		{
			//SQL SERVER
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Mysql
			//Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (Exception e) 
		{
			
			throw new Exception("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier mysql-connector-java-XXXX.jar dans le projet");
		}
		
		try 
		{			
			con = DriverManager.getConnection(url, login, pass);
		} 
		catch (Exception e)
	    {
			System.out.println(e.toString());
			
			throw new Exception("Impossible de se connecter a la base de donnee");
	    } 
	}
	
	public Connection getConnection(){
		
		return this.con;
	}
}

