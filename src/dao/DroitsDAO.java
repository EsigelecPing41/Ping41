package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Droits;

public class DroitsDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static DroitsDAO singleton;
		private DroitsDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static DroitsDAO getInstance() throws Exception
		{
			if(DroitsDAO.singleton==null)
				singleton=new DroitsDAO();
			return singleton;
		}
		
		
		
	/**
	* Permet d'ajouter un droit dans la table Droits
	* @param droit à ajouter
	* @return nombre de lignes ajoutées dans la table Droits
	*/
	public int ajouter(Droits d)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("INSERT INTO Droits (D_O_ID,D_Module,D_Acces) VALUES (?,?,?)");
				ps.setInt(1,d.getD_O_ID());
				ps.setInt(2,d.getD_Module());
				ps.setBoolean(3,d.getD_Acces());
			
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
	 * Permet de supprimer un droit de la table Droit
	 * @param ID du droit à supprimer
	 *@return null si aucun droit ne correspond à cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("DELETE FROM Droits WHERE D_ID=?");
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
	* Permet de modifier l'id operateur
	* @param ID du droit et le nouvel id operateur
	* @return nombre de lignes modifiées dans la table Droits
	* */
	public int modifierOperateur(int ID,int IDOperateur)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Droits SET D_O_ID =? WHERE D_ID=?");
				ps.setInt(1,IDOperateur);
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
	* Permet de modifier l'acces
	* @param ID du droit et le nouvel acces
	* @return nombre de lignes modifiées dans la table Droits
	* */
	public int modifierAcces(int ID,boolean acces)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Droits SET D_Acces =? WHERE D_ID=?");
				ps.setBoolean(1,acces);
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
	* Permet de modifier le module
	* @param ID du droit et le nouveau module
	* @return nombre de lignes modifiées dans la table Droits
	* */
	public int modifierModule(int ID,int Module)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Droits SET D_Module =? WHERE D_ID=?");
				ps.setInt(1,Module);
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
	 * Permet de verifier un droit à partir de l'id user et le module
	 * @param id user et le module
	 * @return false acces refuse, true acces autorise
	 */
	public boolean verifierDroitAcces(int D_O_ID, int D_Module)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		boolean autorise = false;
		//connexion a la base de données
		try 
		{	
			ps = con.prepareStatement("SELECT D_Acces FROM Droits WHERE D_O_ID=? AND D_Module=?");
			ps.setInt(1,D_O_ID);
			ps.setInt(2,D_Module);
						
			//on execute la requete 
			rs = ps.executeQuery();
			if(rs.next())
				autorise = rs.getBoolean("D_Acces");
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
		return autorise;
	}
	
	
	
		/**
		 * Permet de récupérer un droit à partir de son id
		 * @param id du droit à récupérer
		 * @return le droit
		 * @return null si aucun droit ne correspond à cet id
		 */
		public Droits getDroit(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Droits DroitRetourne = null;
	
		
			//connexion a la base de données
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Droits WHERE D_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					DroitRetourne = new Droits(rs.getInt("D_ID"),rs.getInt("D_O_ID"),rs.getInt("D_Module"),rs.getBoolean("D_Acces"));
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
			return DroitRetourne;
		}
		
		
		/**
		 * Permet de récupérer tous les droits de la table
		 * @return la liste des droits
		 */
		public List<Droits> getListDroits()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Droits> ListeDroits = new ArrayList<Droits>();
		
			//connexion a la base de données
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Droits");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeDroits.add(new Droits(rs.getInt("D_ID"),rs.getInt("D_O_ID"),rs.getInt("D_Module"),rs.getBoolean("D_Acces")));
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
			return ListeDroits;
		
		}
}


