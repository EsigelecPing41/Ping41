package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Assemblage;

public class AssemblageDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static AssemblageDAO singleton;
		private AssemblageDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static AssemblageDAO getInstance() throws Exception
		{
			if(AssemblageDAO.singleton==null)
				singleton=new AssemblageDAO();
			return singleton;
		}
		
		
	/**
	* Permet d'ajouter un assemblage dans la table Assemblage
	* @param assemblage a ajouter
	* @return nombre de lignes ajoutes dans la table Assemblage
	*/
	public int ajouter(Assemblage a)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("INSERT INTO Assemblage(A_Nom,A_Ref) VALUES (?,?)");
				ps.setString(1,a.getA_Nom());
				ps.setString(2,a.getA_Ref());

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
	 * Permet d'ajouter une piece dans un assemblage à partir de l'id de la piece
	 * @param l'assemblage dans lequel on veut ajouter la pice et l'id de la piece
	 *@return true ajout avec succes, false si erreur
	 */
	public boolean ajouterPiece(Assemblage a,int ID)
	{
		return a.ajouterPieceAssemblage(ID);
	}
	
	/**
	 * Permet de supprimer une piece dans un assemblage à partir de l'id de la piece
	 * @param l'assemblage dans lequel on veut supprimer la pice et l'id de la piece
	 *@return true suppression avec succes, false si erreur
	 */
	public boolean supprimerPiece(Assemblage a,int ID)
	{
		return a.supprimerPieceAssemblage(ID);
	}
		
	/**
	 * Permet de supprimer un assemblage de la table assemblage
	 * @param ID de l'assemblage a supprimer
	 *@return null si aucun assemblage ne correspond a cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM Assemblage WHERE A_ID=?");
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
	 * Permet de supprimer un assemblage de la table assemblage
	 * @param reference de l'assemblage a supprimer
	 *@return null si aucun assemblage ne correspond a cet reference
	 */
	public int supprimer(String ref)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM Assemblage WHERE A_Ref=?");
				ps.setString(1,ref);
	
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
		 * Permet de recuperer un assemblage partir de son id
		 * @param id de l'assemblage a recuperer
		 * @return l'assemblage
		 * @return null si aucun assemblage ne correspond a cet id
		 */
		public Assemblage getAssemblage(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Assemblage AssemblageRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Assemblage WHERE A_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					AssemblageRetourne = new Assemblage(rs.getInt("A_ID"),rs.getString("A_Nom"),rs.getString("A_Ref"));
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
			return AssemblageRetourne;
		}
		
		/**
		* Permet de modifier le nom de l'assemblage
		* @param ID de l'assemblage et le nouveau nom
		* @return nombre de lignes modifiées dans la table Assemblage
		* */
		public int modifierNom(int ID,String nom)
		{
				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de données
				try 
				{
					ps = con.prepareStatement("UPDATE Assemblage SET A_Nom =? WHERE A_ID=?");
					ps.setString(1,nom);
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
		* Permet de modifier la reference de l'assemblage
		* @param ID de l'assemblage et la nouvelle reference
		* @return nombre de lignes modifiées dans la table Assemblage
		* */
		public int modifierRef(int ID,String reference)
		{
				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de données
				try 
				{
					ps = con.prepareStatement("UPDATE Assemblage SET A_Ref =? WHERE A_ID=?");
					ps.setString(1,reference);
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
		 * Permet de recuperer un assemblage partir de sa reference
		 * @param reference de l'assemblage a recuperer
		 * @return l'assemblage
		 * @return null si aucun assemblage ne correspond a cette reference
		 */
		public Assemblage getAssemblage(String ref)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Assemblage AssemblageRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Assemblage WHERE A_Ref=?");
				ps.setString(1,ref);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					AssemblageRetourne = new Assemblage(rs.getInt("A_ID"),rs.getString("A_Nom"),rs.getString("A_Ref"));
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
			return AssemblageRetourne;
		}
		
		
		/**
		 * Permet de recuperer tous les assemblages de la table
		 * @return la liste des assemblages
		 */
		public List<Assemblage> getListAssemblage()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Assemblage> ListeAssemblage = new ArrayList<Assemblage>();
		
			//connexion a la base de donn?es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Assemblage");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeAssemblage.add(new Assemblage(rs.getInt("A_ID"),rs.getString("A_Nom"),rs.getString("A_Ref")));
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
			return ListeAssemblage;
		
		}
}


