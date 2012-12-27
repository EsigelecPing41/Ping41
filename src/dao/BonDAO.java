package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Bon;
import dao.Connexion;


/**
 * Classe d'accès aux données contenues dans la table Bon
 * */

public class BonDAO {
	private static Connection con;
	
	//singleton attribut permettant de mettre en oeuvre le design pattern singleton
	private static BonDAO singleton;
	private  BonDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

	public BonDAO getInstance() throws Exception
	{
		if(BonDAO.singleton==null)
			singleton=new BonDAO();
		return singleton;
		}
	

	/**
	 * Permet d'ajouter unBon
	 * @param aBonà ajouter
	 * @return le nombre de lignes ajoutées dans la table
	 */
	public static int ajouter(Bon a)
	{

			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try {
	
				ps = con.prepareStatement("INSERT INTO BonDAO (B_Designation,B_Reference,B_NumDossier,_Quantite) VALUES (?,?,?,?)");
				ps.setString(1,a.getB_Designation());
				ps.setString(2,a.getB_Reference());
				ps.setString(3,a.getB_NumDossier());
				ps.setInt(4,a.getB_Quantite());
	
				
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
	* Permet de modifier la designation d'un bon dans la table Bon
	* @param B_Designation de la designation du bon à modifier 
	* @return nombre de lignes modifiées dans la table Bon
	*/
	public int modifierDesignation(String B_Designation ,int BExp_ID, int Bliv_ID, int BCom_ID)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Bon SET B_Designation=? WHERE (BExp_ID, Bliv_ID, BCom_ID)=(?,?,?,?)");
				ps.setInt(1, BExp_ID);
				ps.setInt(2, Bliv_ID);
				ps.setInt(3, BCom_ID);
				ps.setString(4,B_Designation);
				
				
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
	* Permet de modifier la reference du bon dans la table Bon
	* @param B_Reference de la reference du bon à modifier 
	* @return nombre de lignes modifiées dans la table Bon
	*/
	public int modifierReference(int BExp_ID, int Bliv_ID, int BCom_ID,String B_Reference)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Bon SET B_Reference=? WHERE (BExp_ID, Bliv_ID, BCom_ID)=(?,?,?,?)");
				ps.setInt(1, BExp_ID);
				ps.setInt(2, Bliv_ID);
				ps.setInt(3, BCom_ID);
				ps.setString(4,B_Reference);
			
				
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
	* Permet de modifier le numero de dossier du bon dans la table Bon
	* @param B_NumDossier de le numero de dossier du bon à modifier 
	* @return nombre de lignes modifiées dans la table Bon
	*/
	public int modifierNumDossier(int BExp_ID, int Bliv_ID, int BCom_ID ,String B_NumDossier)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Bon SET B_NumDossier=? WHERE (BExp_ID, Bliv_ID, BCom_ID)=(?,?,?,?)");
				ps.setInt(1, BExp_ID);
				ps.setInt(2, Bliv_ID);
				ps.setInt(3, BCom_ID);
				ps.setString(4,B_NumDossier);
				
				
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
	* Permet de modifier la quantite dans la table Bon
	* @param B_Quantite de la quantite à modifier 
	* @return nombre de lignes modifiées dans la table Bon
	*/
	
	public int modifierQuantite(int BExp_ID, int Bliv_ID, int BCom_ID ,int B_Quantite)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Bon SET B_Quantite=? WHERE (BExp_ID, Bliv_ID, BCom_ID)=(?,?,?,?)");
				ps.setInt(1, BExp_ID);
				ps.setInt(2, Bliv_ID);
				ps.setInt(3, BCom_ID);
				ps.setInt(4,B_Quantite);
				
				
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
	 * Permet de supprimer un Bon dans la table Bon
	 * @param int BExp_ID, int Bliv_ID, int BCom_ID du Bon  à supprimer
	 *@return null si aucun Bon ne correspond à cet ID du Bon
	 */
	public int supprimer(int BExp_ID, int Bliv_ID, int BCom_ID)
	{
		PreparedStatement ps=null;
		int retour=0;
		
		//connexion a la base de données
		try {
			ps = con.prepareStatement("DELETE FROM Bon WHERE (BExp_ID, Bliv_ID, BCom_ID)=(?,?,?,?)");
			ps.setInt(1, BExp_ID);
			ps.setInt(2, Bliv_ID);
			ps.setInt(3, BCom_ID);
						
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
	 * Permet de récupérer un Bon d'un Bon 
	 * @param int BExp_ID, int Bliv_ID, int BCom_ID est l'ID du Bon à récupérer
	 * @return le Bon
	 * @return null si aucun Bon ne correspond à cet ID
	 */
	public static BonDAO getBonDAO(int BExp_ID, int Bliv_ID, int BCom_ID)
	{					
		PreparedStatement ps = null;
		ResultSet rs=null;
		BonDAO retour=null;
	
		//connexion a la base de données
		try {

			ps = con.prepareStatement("SELECT * FROM Bon WHERE (BExp_ID,Bliv_ID,BCom_ID) LIKE (?,?,?)");
			ps.setInt (1,BExp_ID);
			ps.setInt (2,Bliv_ID);
			ps.setInt (3,BCom_ID);
						
			//on execute la requete 
			rs=ps.executeQuery();
			if(rs.next())
				retour=new BonDAO ();
			

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
	 * Permet de récupérer tous les Bons de livraison de la table
	 * @return la liste des Bons de livraison
	 */
	public List<BonDAO> getListBonDAO()
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<BonDAO> retour=new ArrayList<BonDAO>();
	
		//connexion a la base de données
		try {
			ps = con.prepareStatement("SELECT * FROM Bon");
									
			//on execute la requete 
			rs=ps.executeQuery();
			//on parcourt les lignes du resultat
			while(rs.next())
				retour.add(new BonDAO ());
			

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
	 * Permet de récupérer UN Bon de la table
	 * @return leBondemande
	 */
	public List<BonDAO> getListBonDAO(int BExp_ID, int Bliv_ID, int BCom_ID )
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<BonDAO> retour=new ArrayList<BonDAO>();
	
		//connexion a la base de données
		try {
			ps = con.prepareStatement("SELECT * FROM Bon");
									
			//on execute la requete 
			rs=ps.executeQuery();
			//on parcourt les lignes du resultat
			while(rs.next())
				retour.add(new BonDAO ());
			

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
	 * Permet de récupérer UNBonde la table par rapport au Numero Dossier
	 * @return leBondemande
	 */
	public List<BonDAO> getListBonDAO(String B_NumDossier)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<BonDAO> retour=new ArrayList<BonDAO>();
	
		//connexion a la base de données
		try {
			ps = con.prepareStatement("SELECT * FROM Bon");
									
			//on execute la requete 
			rs=ps.executeQuery();
			//on parcourt les lignes du resultat
			while(rs.next())
				retour.add(new BonDAO ());
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			//fermeture du rs,preparedStatement et de la connexion
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
		}
		return retour;
	
	}
			
			
	
				
	/**			//main permettant de tester la classe
				public static void main(int[] args){
					BonDAO BonDAO=new BonDAO();
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode ajouter");
					System.out.println("********************");
					
					//test de la méthode ajouter
					Bon a=new Bon();
					int retour= dao.BonDAO.ajouter(a);
					System.out.println(retour+ " lignes ajoutées");

					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode supprimer");
					System.out.println("********************");
					
					//test de la méthode supprimer
					String B_NumDossier = null;
					int retour1= BonDAO.supprimer(B_NumDossier);
					System.out.println(retour1+ " lignes supprimées");
					
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getBonDAO avec B_NumDossier");
					System.out.println("********************");
					
					//test de la méthode getBon avec B_NumDossier
					BonDAO a2=dao.BonDAO.getBonDAO(B_NumDossier);
					System.out.println(a2);

					
										
					
					System.out.println("\n********************");
					System.out.println("Test de la méthode getListBonDAO");
					System.out.println("********************");
					
					//test de la méthode getListbonDAO
					List<BonDAO> liste=BonDAO.getListBonDAO();
					System.out.println(liste);
					
				}   **/
       
	}

