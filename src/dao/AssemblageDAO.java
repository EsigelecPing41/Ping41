package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Assemblage;
import Modele.CritereQualite;
import Modele.Piece;

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
				ps = con.prepareStatement("INSERT INTO Assemblage(A_Nom,A_CodeBarre,A_Statut,A_ListPieces) VALUES (?,?,?,?)");
				ps.setString(1,a.getA_Nom());
				ps.setString(2,a.getA_CodeBarre());
				ps.setBoolean(3,a.getA_Statut());
				ps.setString(4,a.getListPieces());

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
	 * Permet d'ajouter une piece dans un assemblage à partir du code barre de la piece
	 * @param l'assemblage dans lequel on veut ajouter la piece et le code barre de la piece
	 *@return nombre de lignes impactées
	 */
	public int AjouterPiece(int ID, String CB)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String chaine = " ";
		boolean doublon=false;
		int retour=0;
		
		//connexion a la base de donnees
		try 
		{	
			ps = con.prepareStatement("SELECT A_ListPieces FROM Assemblage WHERE A_ID=?");
			ps.setInt(1,ID);
						
			//on execute la requete 
			rs = ps.executeQuery();
			if(rs.next())
				chaine = rs.getString("A_List");
				if(chaine==null)
					chaine = CB;
				else
					{
					String tableau[] = chaine.split(",");
					for(int i=0; i< tableau.length; i++)
					{
						if(tableau[i]==CB)
							doublon=true;
					}
					if (doublon==false)
						chaine = chaine +','+ CB;
					}
					ps = con.prepareStatement("UPDATE Assemblage SET A_ListPieces =? WHERE A_ID=?");
					ps.setString(1,chaine);
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
	 * Permet supprimer une piece dans un assemblage à partir du code barre de la piece
	 * @param l'assemblage dans lequel on veut supprimer la piece et le code barre de la piece
	 *@return nombre de lignes impactées
	 */
	public int SupprimerPiece(int ID, String CB)
	{
		PreparedStatement ps = null;
		ResultSet rs=null;
		String chaine = " ";
		int retour=0;
		
		//connexion a la base de donnees
		try 
		{	
			ps = con.prepareStatement("SELECT A_ListPieces FROM Assemblage WHERE A_ID=?");
			ps.setInt(1,ID);
						
			//on execute la requete 
			rs = ps.executeQuery();
			if(rs.next())
				chaine = rs.getString("A_List");
				if(chaine!=null)
					{
					String tableau[] = chaine.split(",");
						for(int i=0; i< tableau.length; i++)
						{
							if(tableau[i]==CB)
								tableau[i]= " ";
						}
					
						chaine = " ";
						for(int i=1; i< tableau.length; i++)
						{
							if(tableau[i]!= " ")
								if(chaine == " ")
									chaine = tableau[i];
								else
									chaine = chaine +','+ tableau[i];
						}
					}
					ps = con.prepareStatement("UPDATE Assemblage SET A_ListPieces =? WHERE A_ID=?");
					ps.setString(1,chaine);
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
	 * @param code barre de l'assemblage a supprimer
	 *@return null si aucun assemblage ne correspond a ce code barre
	 */
	public int supprimer(String CB)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("DELETE FROM Assemblage WHERE A_CodeBarre=?");
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
					AssemblageRetourne = new Assemblage(rs.getInt("A_ID"),rs.getString("A_Nom"),rs.getString("A_CodeBarre"),rs.getBoolean("A_Statut"),rs.getString("A_ListPieces"));
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
		* Permet de modifier le code barre de l'assemblage
		* @param ID de l'assemblage et le nouveau code barre
		* @return nombre de lignes modifiées dans la table Assemblage
		* */
		public int modifierCB(int ID,String CB)
		{
				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de données
				try 
				{
					ps = con.prepareStatement("UPDATE Assemblage SET A_CodeBarre =? WHERE A_ID=?");
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
		* Permet de modifier le statut de l'assemblage
		* @param ID de l'assemblage et le nouveau statut
		* @return nombre de lignes modifiées dans la table Assemblage
		* */
		public int modifierStatut(int ID,boolean statut)
		{
				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de données
				try 
				{
					ps = con.prepareStatement("UPDATE Assemblage SET A_Statut =? WHERE A_ID=?");
					ps.setBoolean(1,statut);
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
		 * Permet de recuperer un assemblage partir de son code barre
		 * @param code barre de l'assemblage a recuperer
		 * @return l'assemblage
		 * @return null si aucun assemblage ne correspond a ce code barre
		 */
		public Assemblage getAssemblage(String CB)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Assemblage AssemblageRetourne = null;
	
		
			//connexion a la base de donnees
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Assemblage WHERE A_CodeBarre=?");
				ps.setString(1,CB);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					AssemblageRetourne = new Assemblage(rs.getInt("A_ID"),rs.getString("A_Nom"),rs.getString("A_CodeBarre"),rs.getBoolean("A_Statut"),rs.getString("A_ListPieces"));
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
					ListeAssemblage.add(new Assemblage(rs.getInt("A_ID"),rs.getString("A_Nom"),rs.getString("A_CodeBarre"),rs.getBoolean("A_Statut"),rs.getString("A_ListPieces")));
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
		

		/**
		 * Permet de récupérer toutes les pieces d'un assemblage à partir de l'ID de l'assemblage
		 * @param ID de l'assemblage
		 * @return null si aucun assemblage ne correspond a cet ID
		 **/
		public List<Piece> getListPieceAssemblage(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			String chaine = " ";
			List<Piece> retour=new ArrayList<Piece>();
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("SELECT A_ListPieces FROM Assemblage WHERE A_ID=" +ID);		
					//on execute la requete 
					rs = ps.executeQuery();
					if(rs.next())
						chaine = rs.getString("A_ListPieces");
							String tableau[] = chaine.split(",");
							for(int i=0; i< tableau.length; i++)
							{
								ps = con.prepareStatement("SELECT * FROM Piece WHERE P_CodeBarre=" +tableau[i]);		
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new Piece(rs.getInt("P_ID"),rs.getString("P_Nom"),rs.getString("P_CodeBarre"),rs.getBoolean("P_Satut")));
							}
			 } 
			catch (Exception ee) 
			{
				ee.printStackTrace();
			} 
			finally 
			{
				//fermeture du rs,preparedStatement et de la connexion
				try {if (rs != null)rs.close();} catch (Exception t) {}
				try {if (ps != null)ps.close();} catch (Exception t) {}
			}
			return retour;
		
		}
		

		/**
		 * Permet de récupérer toutes les pieces d'un assemblage à partir du code barre de l'assemblage
		 * @param code barre de l'assemblage
		 * @return null si aucun assemblage ne correspond a ce code barre
		 **/
		public List<Piece> getListPieceAssemblage(String CB)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			String chaine = " ";
			List<Piece> retour=new ArrayList<Piece>();
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("SELECT A_ListPieces FROM Assemblage WHERE A_CodeBarre=" +CB);		
					//on execute la requete 
					rs = ps.executeQuery();
					if(rs.next())
						chaine = rs.getString("A_ListPieces");
							String tableau[] = chaine.split(",");
							for(int i=0; i< tableau.length; i++)
							{
								ps = con.prepareStatement("SELECT * FROM Piece WHERE P_CodeBarre=" +tableau[i]);		
								//on execute la requete 
								rs=ps.executeQuery();
								//on parcourt les lignes du resultat
								while(rs.next())
									retour.add(new Piece(rs.getInt("P_ID"),rs.getString("P_Nom"),rs.getString("P_CodeBarre"),rs.getBoolean("P_Satut")));
							}
			 } 
			catch (Exception ee) 
			{
				ee.printStackTrace();
			} 
			finally 
			{
				//fermeture du rs,preparedStatement et de la connexion
				try {if (rs != null)rs.close();} catch (Exception t) {}
				try {if (ps != null)ps.close();} catch (Exception t) {}
			}
			return retour;
		
		}
}


