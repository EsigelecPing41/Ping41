package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Action;
import dao.Connexion;


/**
 * Classe d'accès aux données contenues dans la table Action
 * */

	public class ActionDAO {
		private static Connection con;
		
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static ActionDAO singleton;
		private  ActionDAO() throws Exception
			{
				Connexion connect;
				connect = new Connexion();
				con = connect.getConnection();	
			}
	
		public ActionDAO getInstance() throws Exception
		{
			if(ActionDAO.singleton==null)
				singleton=new ActionDAO();
			return singleton;
			}
		

	/**
	 * Permet d'ajouter une Action
	 * @param aActionà ajouter
	 * @return le nombre de lignes ajoutées dans la table
	 */
	public static int ajouter(Action a)
	{

			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try {
	
				ps = con.prepareStatement("INSERT INTO ActionDAO (A_Date,A_IDOperateur,A_IDOperation) VALUES (?,?,?)");
				ps.setDate(1,(Date)a.getA_Date());
				ps.setInt(2,a.getA_IDOperateur());
				ps.setInt(3,a.getA_IDOperation());

				
				//on execute la requete 
				retour=ps.executeUpdate();
				
	
			} catch (Exception ee) {
				ee.printStackTrace();
			} finally {
				//fermeture du getConnection().preparedStatement et de la connexion
				try {if (ps != null)ps.close();} catch (Exception t) {}
			}
			return retour;	
		}


	/**
	* Permet de modifier la date d'un Action dans la table Action
	* @param A_Date de la designation du Action à modifier 
	* @return nombre de lignes modifiées dans la table Action
	*/
	public int modifierDate(Date A_Date ,int AA_ID,int AP_ID)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Action SET A_Date=? WHERE (AA_ID, AP_ID)=(?,?)");
				ps.setDate(1,A_Date);
				ps.setInt(2,AP_ID);
				ps.setInt(3,AA_ID);
				
				
				//on execute la requete 
				retour=ps.executeUpdate();
				
		     } 
			catch (Exception e)
		     {
				e.printStackTrace();
		     } 
			finally 
		     {
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			 }
			 return retour;
		
	}


	/**
	* Permet de modifier l'operateur du Action dans la table Action
	* @param A_IDOperateur de l'operateur du Action à modifier 
	* @return nombre de lignes modifiées dans la table Action
	*/
	public int modifierOperateur(int AA_ID,int AP_ID ,int A_IDOperateur)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Action SET A_IDOperateur=? WHERE (AA_ID,AP_ID)=(?,?)");
				ps.setInt(1,A_IDOperateur);
				ps.setInt(2,AP_ID);
				ps.setInt(3,AA_ID);
				
				//on execute la requete 
				retour=ps.executeUpdate();
				
		     } 
			catch (Exception e)
		     {
				e.printStackTrace();
		     } 
			finally 
		     {
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			 }
			 return retour;
		
	}
	

	/**
	* Permet de modifier l'operation du Action dans la table Action
	* @param A_IDOperation de l'operation de dossier du Action à modifier 
	* @return nombre de lignes modifiées dans la table Action
	*/
	public int modifierOperation(int AA_ID,int AP_ID  ,int A_IDOperation)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Action SET A_IDOperation=? WHERE (AA_ID,AP_ID)=(?,?)");
				ps.setInt(1,A_IDOperation);
				ps.setInt(2,AP_ID);
				ps.setInt(3,AA_ID);
				
				//on execute la requete 
				retour=ps.executeUpdate();
				
		     } 
			catch (Exception e)
		     {
				e.printStackTrace();
		     } 
			finally 
		     {
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			 }
			 return retour;
		
	}


			
		
	/**
	 * Permet de supprimer un Action dans la table Action
	 * @param int AA_ID,int AP_ID  du Action  à supprimer
	 *@return null si aucun Action ne correspond à cet ID du Action
	 */
	public int supprimer(int AA_ID,int AP_ID )
	{
		PreparedStatement ps=null;
		int retour=0;
		
		//connexion a la base de données
		try {
			ps = con.prepareStatement("DELETE FROM Action WHERE (AA_ID,AP_ID)=(?,?)");
			ps.setInt(1,AP_ID);
			ps.setInt(2,AA_ID);
						
			//on execute la requete 
			retour=ps.executeUpdate();

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			//fermeture du rs,preparedStatement et de la connexion
			
			try {if (ps != null)ps.close();} catch (Exception t) {}
		}
		return retour;
	
	}	
	
	/**
	 * Permet de récupérer un Action d'un Action 
	 * @param int AA_ID,int AP_ID  est l'ID du Action à récupérer
	 * @return le Action
	 * @return null si aucun Action ne correspond à cet ID
	 */
	public static ActionDAO getActionDAO(int AA_ID,int AP_ID )
	{					
		PreparedStatement ps = null;
		ResultSet rs=null;
		ActionDAO retour=null;
	
		//connexion a la base de données
		try {

			ps = con.prepareStatement("SELECT * FROM Action WHERE (AA_ID,AP_ID) LIKE (?,?)");
			ps.setInt(1,AP_ID);
			ps.setInt(2,AA_ID);
						
			//on execute la requete 
			rs=ps.executeQuery();
			if(rs.next())
				retour=new ActionDAO ();
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			//fermeture du rs,preparedStatement et de la connexion
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
		}
		return retour;
	
	}
				
	
	/**
	 * Permet de récupérer tous les Actions de livraison de la table
	 * @return la liste des Actions de livraison
	 */
	public List<ActionDAO> getListActionDAO()
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<ActionDAO> retour=new ArrayList<ActionDAO>();
	
		//connexion a la base de données
		try {
			ps = con.prepareStatement("SELECT * FROM Action");
									
			//on execute la requete 
			rs=ps.executeQuery();
			//on parcourt les lignes du resultat
			while(rs.next())
				retour.add(new ActionDAO ());
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			//fermeture du rs,preparedStatement et de la connexion
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
		}
		return retour;
	
	}

	/**
	 * Permet de récupérer UN Action de la table
	 * @return leActiondemande
	 */
	public List<ActionDAO> getListActionDAO(int AA_ID,int AP_ID )
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<ActionDAO> retour=new ArrayList<ActionDAO>();
	
		//connexion a la base de données
		try {
			ps = con.prepareStatement("SELECT * FROM Action");
									
			//on execute la requete 
			rs=ps.executeQuery();
			//on parcourt les lignes du resultat
			while(rs.next())
				retour.add(new ActionDAO ());
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			//fermeture du rs,preparedStatement et de la connexion
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
		}
		return retour;
	
	}

       
	}

