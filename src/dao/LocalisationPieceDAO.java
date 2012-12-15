package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.LocalisationPiece;
import Modele.LocalisationPiece;

public class LocalisationPieceDAO 
{
		private static final String BDD_LOCALISATION_PIECE  = "localisationpiece";
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
	* Permet d'ajouter un LocalisationPiece dans la table LocalisationPiece
	* @param LocalisationPiece � ajouter
	* @return nombre de lignes ajout�es dans la table LocalisationPiece
	*/
	public int ajouter(LocalisationPiece c)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("INSERT INTO "+BDD_LOCALISATION_PIECE+" (LocP_ID ,LocP_Date ,O_ID ,L_ID) VALUES (?,?,?,?)");
				ps.setInt(1,c.getLP_Id());
				ps.setDate(2,(Date)c.getLP_Date());
				ps.setInt(3,c.getLP_O_ID());
				ps.setInt(4,c.getLP_L_ID());
				
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
	 * Permet de supprimer un LocalisationPiece de la table LocalisationPiece
	 * @param ID du LocalisationPiece � supprimer
	 *@return null si aucun LocalisationPiece ne correspond � cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donn�es
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
		 * Permet de r�cup�rer un LocalisationPiece � partir de son id
		 * @param id du LocalisationPiece � r�cup�rer
		 * @return le LocalisationPiece
		 * @return null si aucun LocalisationPiece ne correspond � cet id
		 */
		public LocalisationPiece getLocalisationPiece(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			LocalisationPiece LocalisationPieceRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_PIECE+" WHERE LocP_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					LocalisationPieceRetourne = new LocalisationPiece(rs.getInt("LocP_ID"),rs.getDate("LocP_Date"),rs.getInt("O_ID"),rs.getInt("L_ID"));
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
		 * Permet de r�cup�rer un LocalisationPiece � partir de son nom
		 * @param nom du LocalisationPiece � r�cup�rer
		 * @return le LocalisationPiece
		 * @return null si aucun LocalisationPiece ne correspond � ce nom
		 */
		public LocalisationPiece getLocalisationPiece(String nom)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			LocalisationPiece LocalisationPieceRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_PIECE+" WHERE C_Nom=?");
				ps.setString(1,nom);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					LocalisationPieceRetourne = new LocalisationPiece(rs.getInt("LocP_ID"),rs.getDate("LocP_Date"),rs.getInt("O_ID"),rs.getInt("L_ID"));
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
		 * Permet de r�cup�rer tous les LocalisationPieces de la table
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
					ListeLocalisationPiece.add(new LocalisationPiece(rs.getInt("LocP_ID"),rs.getDate("LocP_Date"),rs.getInt("O_ID"),rs.getInt("L_ID")));
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
				
				ps = con.prepareStatement("SELECT * FROM "+BDD_LOCALISATION_PIECE+" where L_ID=?");
				ps.setInt(1,L_ID);
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeLocalisationPiece.add(new LocalisationPiece(rs.getInt("LocP_ID"),rs.getDate("LocP_Date"),rs.getInt("O_ID"),rs.getInt("L_ID")));
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


