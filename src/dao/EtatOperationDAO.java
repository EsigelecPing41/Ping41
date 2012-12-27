
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.EtatOperation;

public class EtatOperationDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static EtatOperationDAO singleton;
		private EtatOperationDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static EtatOperationDAO getInstance() throws Exception
		{
			if(EtatOperationDAO.singleton==null)
				singleton=new EtatOperationDAO();
			return singleton;
		}
		
	/**
	* Permet d'ajouter un EtatOperation dans la table EtatOperation
	* @param EtatOperation a ajouter
	* @return nombre de lignes ajoutees dans la table EtatOperation
	*/
	public int ajouter(EtatOperation eo)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("INSERT INTO EtatOperation (E_Etat) VALUES (?)");
				ps.setString(1,eo.getE_Etat());
				
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
	 * Permet de supprimer un EtatOperation de la table
	 * @param ID de l'EtatOperation a supprimer
	 *@return null si aucun EtatOperation ne correspond a cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM EtatOperation WHERE E_ID=?");
				ps.setInt(1,ID);
	
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
	* Permet de modifier etat operation
	* @param ID de l'etat operation a modifier et le nouvel etat
	* @return nombre de lignes modifiées dans la table EtatOperation
	* */
	public int modifierEtat(int ID,String etat)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE EtatOperation SET E_Etat=? WHERE E_ID=?");
				ps.setString(1,etat);
				ps.setInt(2,ID);
				
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
		 * Permet de recuperer un EtatOperation partir de son id
		 * @param id de l'EtatOperation a recuperer
		 * @return l'EtatOperation
		 * @return null si aucun EtatOperation ne correspond a cet id
		 */
		public EtatOperation getEtatOperation(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			EtatOperation EtatOperationRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM EtatOperation WHERE E_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					EtatOperationRetourne = new EtatOperation(rs.getInt("E_ID"),rs.getString("E_Etat"));
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			finally 
			{
				try 
				{
					if (rs != null)
					rs.close();
				} 
				catch (Exception t)
				{
					
				}
				
				try 
				{
					if (ps != null)
						ps.close();
				} 
				catch (Exception t) 
				{
					
				}
			}
			return EtatOperationRetourne;
		}
		
		
		/**
		 * Permet de recuperer tous les EtatOperation de la table
		 * @return la liste des EtatOperation
		 */
		public List<EtatOperation> getListEtatOperation()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<EtatOperation> ListeEtatOperation = new ArrayList<EtatOperation>();
		
			//connexion a la base de donnees
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM EtatOperation");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeEtatOperation.add(new EtatOperation(rs.getInt("E_ID"),rs.getString("E_Etat")));
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					if (rs != null)
						rs.close();
				} 
				catch (Exception t) 
				{
					
				}
				
				try
				{
					if (ps != null)
						ps.close();
				}
				catch (Exception t) 
				{
					
				}
			}
			return ListeEtatOperation;
		
		}
		
}


