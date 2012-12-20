
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Ordonnancement;

public class OrdonnancementDAO
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static OrdonnancementDAO singleton;
		private OrdonnancementDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static OrdonnancementDAO getInstance() throws Exception
		{
			if(OrdonnancementDAO.singleton==null)
				singleton= new OrdonnancementDAO();
			return singleton;
		}
		
	/**
	* Permet d'ajouter un Ordonnancement dans la table Ordonnancement
	* @param Ordonnancement a ajouter
	* @return nombre de lignes ajoutees dans la table Ordonnancement
	*/
	public int ajouter(Ordonnancement Ord)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("INSERT INTO Ordonnancement (Ord_Designation,Ord_QteFab,Ord_Ste,Ord_CodeClient,Ord_DelaiCde,Ord_MFab,Ord_DelaiPrv,Ord_DelaiDde,Ord_FamGest,Ord_NumDossier,Ord_CodeGPAO,Ord_IndNomenclature,Ord_NumSerie,Ord_ComInterne) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,Ord.getOrd_Designation());
			    ps.setInt(2,Ord.getOrd_QteFab());
			    ps.setString(3,Ord.getOrd_Ste());
			    ps.setString(4,Ord.getOrd_CodeClient());
			    ps.setDate(5,(java.sql.Date) Ord.getOrd_DelaiCde());
			    ps.setDate(6,(java.sql.Date) Ord.getOrd_MFab());
			    ps.setDate(7, (java.sql.Date) Ord.getOrd_DelaiPrv());
			    ps.setDate(8, (java.sql.Date) Ord.getOrd_DelaiDde());
			    ps.setString(9,Ord.getOrd_FamGest());
			    ps.setString(10,Ord.getOrd_NumDossier());
			    ps.setString(11,Ord.getOrd_CodeGPAO());
			    ps.setString (12,Ord.getOrd_IndNomenclature());
			    ps.setString (13,Ord.getOrd_NumSerie());
			    ps.setString(14,Ord.getOrd_ComInterne());
				
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
	 * Permet de supprimer un ordonnancement de la table
	 * @param ID de l'ordonnancement a supprimer
	 *@return null si aucun ordonnancement ne correspond a cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM Ordonnancement WHERE Ord_ID=?");
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
	* Permet de modifier la quantité ordonnée 
	* @param ID de l'ordonnancement et nouvelle quantité
	* @return nombre de lignes modifiées dans la table Ordonnancement
	* */
	public int modifier(int ID,int Qte)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Ordonnancement SET Ord_QteFab =? WHERE Ord_ID=?");
				ps.setInt(1,Qte);
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
		 * Permet de recuperer un ordonnancement partir de son id
		 * @param id du l'ordonnancement a recuperer
		 * @return l'ordonnancement
		 * @return null si aucun ordonnancement ne correspond a cet id
		 */
		public Ordonnancement getOrdonnancement(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Ordonnancement OrdonnancementRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Ordonnancement WHERE Ord_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					OrdonnancementRetourne = new Ordonnancement(rs.getInt("Ord_ID"),
					rs.getString("Ord_Designation"),
				    rs.getInt("Ord_QteFab"),
				    rs.getString("getOrd_Ste"),
				    rs.getString("Ord_CodeClient"),
				    rs.getDate("Ord_DelaiCde"),
				    rs.getDate("Ord_MFab"),
				    rs.getDate("Ord_DelaiPrv"),
				    rs.getDate("Ord_DelaiDde"),
				    rs.getString("Ord_FamGest"),
				    rs.getString("Ord_NumDossier"),
				    rs.getString("Ord_CodeGPAO"),
				    rs.getString("Ord_IndNomenclature"),
				    rs.getString("Ord_NumSerie"),
				    rs.getString("Ord_ComInterne"));
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
			return OrdonnancementRetourne;
		}
		
		
		/**
		 * Permet de recuperer tous les ordonnancements de la Ordonnancement
		 * @return la liste des ordonnancements
		 */
		public List<Ordonnancement> getListOrdonnancement()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Ordonnancement> ListeOrdonnancement = new ArrayList<Ordonnancement>();
		
			//connexion a la base de donnees
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Ordonnancement");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeOrdonnancement.add(new Ordonnancement(rs.getInt("Ord_ID"),
							rs.getString("Ord_Designation"),
						    rs.getInt("Ord_QteFab"),
						    rs.getString("getOrd_Ste"),
						    rs.getString("Ord_CodeClient"),
						    rs.getDate("Ord_DelaiCde"),
						    rs.getDate("Ord_MFab"),
						    rs.getDate("Ord_DelaiPrv"),
						    rs.getDate("Ord_DelaiDde"),
						    rs.getString("Ord_FamGest"),
						    rs.getString("Ord_NumDossier"),
						    rs.getString("Ord_CodeGPAO"),
						    rs.getString("Ord_IndNomenclature"),
						    rs.getString("Ord_NumSerie"),
						    rs.getString("Ord_ComInterne")));
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
			return ListeOrdonnancement;
		
		}
		
}


