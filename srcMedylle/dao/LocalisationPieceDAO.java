package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.LocalisationPiece;

public class LocalisationPieceDAO 
{
		private static final String BDD_LOCALISATION_PIECE  = "LocalisationPiece";
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static LocalisationPieceDAO singleton;
		private LocalisationPieceDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static LocalisationPieceDAO getInstance() throws Exception
		{
			if(LocalisationPieceDAO.singleton==null)
				singleton=new LocalisationPieceDAO();
			return singleton;
		}
		
	/**
	* Permet d'ajouter une localisationPiece dans la table LocalisationPiece
	* @param LocalisationPiece a ajouter
	* @return nombre de lignes ajoutees dans la table LocalisationPiece
	*/
	public int ajouter(LocalisationPiece lp)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("INSERT INTO "+BDD_LOCALISATION_PIECE+" (LocP_Date ,LocP_O_ID ,LocP_L_ID,LocP_P_ID) VALUES (?,?,?,?)");
				ps.setDate(1,(Date)lp.getLP_Date());
				ps.setInt(2,lp.getLP_O_ID());
				ps.setInt(3,lp.getLP_L_ID());
				ps.setInt(4,lp.getLP_P_ID());
				
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
	 * Permet de supprimer une localisationPiece de la table LocalisationPiece
	 * @param ID de la LocalisationPiece a supprimer
	 *@return null si aucune localisationPiece ne correspond cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM "+BDD_LOCALISATION_PIECE+" WHERE LocP_ID=?");
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
		 * Permet de recuperer une localisationPiece a partir de son id
		 * @param id de la localisationPiece a recuperer
		 * @return la localisationPiece
		 * @return null si aucune localisationPiece ne correspond a cet id
		 */
		public LocalisationPiece getLocalisationPiece(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			LocalisationPiece LocalisationPieceRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_PIECE+" WHERE LocP_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					LocalisationPieceRetourne = new LocalisationPiece(rs.getInt("LocP_ID"),rs.getDate("LocP_Date"),rs.getInt("Loc_O_ID"),rs.getInt("Loc_L_ID"),rs.getInt("Loc_P_ID"));
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
			return LocalisationPieceRetourne;
		}
		
		/**
		 * Permet de recuperer une localisationPiece a partir de l'ID de la piece recherche
		 * @param ID de la piece dont on veut la localisationPiece
		 * @return la localisationPiece
		 * @return null si aucune piece ne correspond a cet ID
		 */
		public LocalisationPiece getLocalisationPieceID(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			LocalisationPiece LocalisationPieceRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_PIECE+" WHERE LocP_P_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					LocalisationPieceRetourne = new LocalisationPiece(rs.getInt("LocP_ID"),rs.getDate("LocP_Date"),rs.getInt("LocP_O_ID"),rs.getInt("Loc_L_ID"),rs.getInt("LocP_P_ID"));
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
			return LocalisationPieceRetourne;
		}
		
		
		/**
		 * Permet de recuperer toutes les LocalisationPieces de la table
		 * @return la liste des LocalisationPieces
		 */
		public List<LocalisationPiece> getListLocalisationPiece()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<LocalisationPiece> ListeLocalisationPiece = new ArrayList<LocalisationPiece>();
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_PIECE+"");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeLocalisationPiece.add(new LocalisationPiece(rs.getInt("LocP_ID"),rs.getDate("LocP_Date"),rs.getInt("LocP_O_ID"),rs.getInt("LocP_L_ID"),rs.getInt("Loc_P_ID")));
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
			return ListeLocalisationPiece;
		
		}
		
		/**
		 * Permet de r�cup�rer tous les LocalisationPieces de la table
		 * @return la liste des LocalisationPieces
		 */
		public List<LocalisationPiece> getListLocalisationPieceLieu(int L_ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<LocalisationPiece> ListeLocalisationPiece = new ArrayList<LocalisationPiece>();
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_PIECE+" where LocP_L_ID=?");
				ps.setInt(1,L_ID);
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeLocalisationPiece.add(new LocalisationPiece(rs.getInt("LocP_ID"),rs.getDate("LocP_Date"),rs.getInt("LocP_O_ID"),rs.getInt("Loc_L_ID"),rs.getInt("LocP_P_ID")));
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
			return ListeLocalisationPiece;
		
		}
}



