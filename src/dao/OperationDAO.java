package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.EtatOperation;
import Modele.Operation;

public class OperationDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static OperationDAO singleton;
		private OperationDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static OperationDAO getInstance() throws Exception
		{
			if(OperationDAO.singleton==null)
				singleton=new OperationDAO();
			return singleton;
		}
		
		
	/**
	* Permet d'ajouter une operation dans la table operation
	* @param operation � ajouter
	* @return nombre de lignes ajout�es dans la table Operation
	*/
	public int ajouter(Operation Op)
	{
			PreparedStatement ps = null;
			int retour=0;
			EtatOperation etatOperation = Op.getOp_EO();
			
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("INSERT INTO Operation (Op_Libelle,Op_EO_ID) VALUES (?,?)");
				ps.setString(1,Op.getOp_Libelle());
				ps.setInt(2,etatOperation.getE_ID());
				
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
	/**
	* Permet de modifier l'ID de l'assemblage d'une operation 
	* @param ID de l'operation a modifier et nouvel ID Assemblage
	* @return nombre de lignes modifiees dans la table Operation
	* */
	public int modifierIDAssemblage(int ID,int ID_Assemblage)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donnees
			try 
			{
				ps = con.prepareStatement("UPDATE Operation SET Op_A_ID=? WHERE Op_ID=?");
				ps.setInt(1,ID_Assemblage);
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
	
	/* Permet de modifier le nom d'une operation 
	* @param ID de l'operation � modifier et nouveau nom
	* @return nombre de lignes modifi�es dans la table Operation
	* */
	public int modifier(int ID,String libelle)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Operation SET Op_Libelle=? WHERE Op_ID=?");
				ps.setString(1,libelle);
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
	* Permet de modifier l'etat d'une operation 
	* @param ID de l'operation � modifier et l'ID du nouvel etat
	* @return nombre de lignes modifi�es dans la table Operation
	* */
	public int modifier(int ID,int EO)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Operation SET Op_EO_ID=? WHERE Op_ID=?");
				ps.setInt(1,EO);
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
	 * Permet de supprimer une operation de la table Operation � partir de son ID
	 * @param ID de l'operation � supprimer
	 *@return null si aucune operation ne correspond � cet id
	 */
	public int supprimer(int ID)
	{
		
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("DELETE FROM Operation WHERE Op_ID=?");
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
	 * Permet de supprimer une operation de la table Operation � partir de son libelle
	 * @param libelle de l'operation � supprimer
	 *@return null si aucune operation ne correspond � ce libelle
	 */
	public int supprimer(String nom)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("DELETE FROM Operation WHERE Op_Libelle=?");
				ps.setString(1,nom);
	
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
		 * Permet de r�cup�rer une operation � partir de son ID
		 * @param ID de l'operation � r�cup�rer
		 * @return l'operation
		 * @return null si aucune operation ne correspond � cet id
		 */
		public Operation getOperation(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null, result = null;
			Operation OperationRetourne = null;
			EtatOperation etatOperation = null;
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Operation WHERE Op_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
				{
					ps = con.prepareStatement("SELECT * FROM EtatOperation WHERE E_ID=?");
					ps.setInt(1, rs.getInt("Op_EO_ID"));
					result = ps.executeQuery();
					etatOperation = new EtatOperation(result.getInt("E_ID"),result.getString("E_Etat"));
					OperationRetourne = new Operation(rs.getInt("Op_ID"),rs.getString("Op_A_Nom"),rs.getString("Op_Libelle"),etatOperation);
				}
					
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
			return OperationRetourne;
		}
		
		/**
		 * Permet de r�cup�rer une operation a partir de son libelle
		 * @param libelle de l'operation � r�cup�rer
		 * @return l'operation
		 * @return null si aucune operation ne correspond � ce libelle
		 */
		public Operation getOperation(String nom)
		{
			PreparedStatement ps = null;
			ResultSet rs=null, result = null;
			Operation OperationRetourne = null;
			EtatOperation etatOperation = null;
	
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Operation WHERE Op_Libelle=?");
				ps.setString(1,nom);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
				{
					ps = con.prepareStatement("SELECT * FROM EtatOperation WHERE E_ID=?");
					ps.setInt(1, rs.getInt("Op_EO_ID"));
					result = ps.executeQuery();
					etatOperation = new EtatOperation(result.getInt("E_ID"),result.getString("E_Etat"));
					OperationRetourne = new Operation(rs.getInt("Op_ID"),rs.getString("Op_A_Nom"),rs.getString("Op_Libelle"),etatOperation);
				}
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
			return OperationRetourne;
		}
		
		/**
		 * Permet de r�cup�rer toutes operations de la table
		 * @return la liste des operations
		 */
		public List<Operation> getListOperation()
		{
			PreparedStatement ps = null;
			ResultSet rs=null, result = null;
			List<Operation> ListeOperations = new ArrayList<Operation>();
			EtatOperation etatOperation = null;
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Operation");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
				{
					//rs.getInt("Op_EO_ID");
					ps = con.prepareStatement("SELECT * FROM EtatOperation WHERE E_ID=?");
					ps.setInt(1, rs.getInt("Op_EO_ID"));
					result = ps.executeQuery();
					etatOperation = new EtatOperation(result.getInt("E_ID"),result.getString("E_Etat"));
					
					ListeOperations.add(new Operation(rs.getInt("Op_ID"),rs.getString("Op_A_Nom"),rs.getString("Op_Libelle"),etatOperation));
		
				}
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
			return ListeOperations;
		
		}
		
		/**
		 * Permet de r�cup�rer toutes les operations sur une piece a partir de l'id de la piece je pense que c'est
		 * @return la liste des operations effectues sur la piece
		 */
		public List<Operation> getListOperationPiece(int ID_Piece)
		{
			PreparedStatement ps = null;
			ResultSet rs=null, result = null;
			List<Operation> ListeOperations = new ArrayList<Operation>();
			EtatOperation etatOperation = null;
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT AP_Op_ID FROM ActionPiece WHERE AP_P_ID="+ID_Piece);					
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
				{
					ps = con.prepareStatement("SELECT * FROM Operation WHERE Op_ID="+rs.getInt("Op_ID"));
					//on execute la requete 
					rs=ps.executeQuery();
					//on parcourt les lignes du resultat
					if(rs.next())
					{
						ps = con.prepareStatement("SELECT * FROM EtatOperation WHERE E_ID=?");
						ps.setInt(1, rs.getInt("Op_EO_ID"));
						result = ps.executeQuery();
						etatOperation = new EtatOperation(result.getInt("E_ID"),result.getString("E_Etat"));
						
						ListeOperations.add(new Operation(rs.getInt("Op_ID"),rs.getString("Op_A_Nom"),rs.getString("Op_Libelle"),etatOperation));
					}
				}
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
			return ListeOperations;
		
		}
		
		/**
		 * Permet de r�cup�rer toutes les operations sur un assemblage a partir de l'id de l'assemblage
		 * @return la liste des operations effectues sur l'assemblage
		 */
		public List<Operation> getListOperationAssemblage(int ID_Assemblage)
		{
			PreparedStatement ps = null;
			ResultSet rs=null, result = null;
			List<Operation> ListeOperations = new ArrayList<Operation>();
			EtatOperation etatOperation = null;
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT AA_Op_ID FROM ActionAssemblage WHERE AA_A_ID="+ID_Assemblage);					
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
				{
					ps = con.prepareStatement("SELECT * FROM Operation WHERE Op_ID="+rs.getInt("Op_ID"));
					//on execute la requete 
					rs=ps.executeQuery();
					//on parcourt les lignes du resultat
					if(rs.next())
					{
						
						ps = con.prepareStatement("SELECT * FROM EtatOperation WHERE E_ID=?");
						ps.setInt(1, rs.getInt("Op_EO_ID"));
						result = ps.executeQuery();
						etatOperation = new EtatOperation(result.getInt("E_ID"),result.getString("E_Etat"));
						ListeOperations.add(new Operation(rs.getInt("Op_ID"),rs.getString("Op_A_Nom"),rs.getString("Op_Libelle"),etatOperation));
					}
				}
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
			return ListeOperations;
		
		}
		
}

