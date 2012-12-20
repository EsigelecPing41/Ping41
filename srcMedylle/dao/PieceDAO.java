package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Piece;

public class PieceDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static PieceDAO singleton;
		private PieceDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static PieceDAO getInstance() throws Exception
		{
			if(PieceDAO.singleton==null)
				singleton=new PieceDAO();
			return singleton;
		}
		
		
	/**
	* Permet d'ajouter une piece dans la table Piece
	* @param piece � ajouter
	* @return nombre de lignes ajout�es dans la table Piece
	*/
	public int ajouter(Piece p)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("INSERT INTO Piece (P_Nom,P_CodeBarre,P_Statut) VALUES (?,?,?)");
				ps.setString(1,p.getP_Nom());
				ps.setString(2,p.getP_CodeBarre());
				ps.setBoolean(3,p.getP_Statut());
				
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
	* Permet de modifier le statut d'une piece dans la table Piece
	* @param ID de la piece � modifier et le nouveau statut
	* @return nombre de lignes modifi�es dans la table Piece
	*/
	public int modifierStatut(int ID,String statut)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Piece SET P_Statut=? WHERE P_ID=?");
				ps.setString(1,statut);
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
	* Permet de modifier le code barre d'une piece dans la table Piece
	* @param ID de la piece � modifier et le nouveau code barre
	* @return nombre de lignes modifi�es dans la table Piece
	*/
	public int modifierCB(int ID,String CB)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Piece SET P_CodeBarre=? WHERE P_ID=?");
				ps.setString(1,CB);
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
	 * Permet de supprimer une piece de la table Piece � partir de son ID
	 * @param ID de la piece � supprimer
	 *@return null si aucune piece ne correspond � cet id
	 */
	public int supprimer(int ID)
	{
		
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("DELETE FROM Piece WHERE P_ID=?");
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
	 * Permet de supprimer une piece de la table Piece � partir de son code barre
	 * @param CB de la piece � supprimer
	 *@return null si aucune piece ne correspond � ce code barre
	 */
	public int supprimer(String CB)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("DELETE FROM Piece WHERE P_CodeBarre=?");
				ps.setString(1,CB);
	
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
		 * Permet de r�cup�rer une piece � partir de son ID
		 * @param ID de la piece � r�cup�rer
		 * @return la piece
		 * @return null si aucune piece ne correspond � cet id
		 */
		public Piece getPiece(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Piece PieceRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Piece WHERE P_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					PieceRetourne = new Piece(rs.getInt("P_ID"),rs.getString("P_Nom"),rs.getString("P_CodeBarre"),rs.getBoolean("P_Statut"));
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
			return PieceRetourne;
		}
		
		/**
		 * Permet de r�cup�rer une piece a partir de son code barre
		 * @param CB de la piece � r�cup�rer
		 * @return la piece
		 * @return null si aucune piece ne correspond � ce code barre
		 */
		public Piece getPiece(String CB)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Piece PieceRetourne = null;
	
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Piece WHERE P_CodeBarre=?");
				ps.setString(1,CB);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					PieceRetourne = new Piece(rs.getInt("P_ID"),rs.getString("P_Nom"),rs.getString("P_CodeBarre"),rs.getBoolean("P_Statut"));
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
			return PieceRetourne;
		}
		
		/**
		 * Permet de r�cup�rer toutes les pieces de la table
		 * @return la liste des pieces
		 */
		public List<Piece> getListPiece()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Piece> ListePieces = new ArrayList<Piece>();
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Piece");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListePieces.add(new Piece(rs.getInt("P_ID"),rs.getString("P_Nom"),rs.getString("P_CodeBarre"),rs.getBoolean("P_Statut")));
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
			return ListePieces;
		
		}
}


