package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Lieu;

public class LieuDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static LieuDAO singleton;
		private LieuDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static LieuDAO getInstance() throws Exception
		{
			if(LieuDAO.singleton==null)
				singleton=new LieuDAO();
			return singleton;
		}
		
	/**
	* Permet d'ajouter un lieu dans la table Lieu
	* @param lieu a ajouter
	* @return nombre de lignes ajoutees dans la table Lieu
	*/
	public int ajouter(Lieu l)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("INSERT INTO Lieu (L_Nom) VALUES (?)");
				ps.setString(1,l.getL_Nom());
				
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
	 * Permet de supprimer un lieu de la table
	 * @param ID du lieu a supprimer
	 *@return null si aucun lieu ne correspond a cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM Lieu WHERE L_ID=?");
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
		 * Permet de recuperer un lieu partir de son id
		 * @param id du lieu a recuperer
		 * @return le lieu
		 * @return null si aucun lieu ne correspond a cet id
		 */
		public Lieu getLieu(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Lieu LieuRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Lieu WHERE L_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					LieuRetourne = new Lieu(rs.getInt("L_ID"),rs.getString("L_Nom"));
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
			return LieuRetourne;
		}
		
		
		/**
		 * Permet de recuperer tous les lieux de la table
		 * @return la liste des lieux
		 */
		public List<Lieu> getListLieu()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Lieu> ListeLieu = new ArrayList<Lieu>();
		
			//connexion a la base de donnees
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Lieu");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeLieu.add(new Lieu(rs.getInt("L_ID"),rs.getString("L_Nom")));
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
			return ListeLieu;
		
		}
		
}


