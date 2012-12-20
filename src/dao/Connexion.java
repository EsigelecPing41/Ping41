package dao;

import java.sql.*;
import java.util.Enumeration;

public class Connexion 
{
	//SQL SERVER
	//final static String url = "jdbc:mysql://localhost/__BDD__";
	//Mysql
	final static String url = "jdbc:mysql://localhost/SKFTraceability";
	final static String login="root";
	final static String pass="";
	Connection con = null;
	
	public Connexion() throws Exception
	{
		
		// chargement du pilote sqlServer
		try 
		{
			//SQL SERVER
			//Class.forName("com.sqlserver.jdbc.Driver");
			//Mysql
			Class.forName("com.mysql.jdbc.Driver");
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
			throw new Exception("Impossible de se connecter a la base de donnee");
	    } 
	}
	
	public Connection getConnection(){
		
		return this.con;
	}
}
