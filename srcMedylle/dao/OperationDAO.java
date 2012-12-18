package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("INSERT INTO Operation (Op_Libelle,Op_Etat) VALUES (?,?)");
				ps.setString(1,Op.getOp_Libelle());
				//ps.setString(2,Op.getOp_Etat());
				
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
	* Permet de modifier une operation dans la table Operation
	* @param ID de l'operation � modifier
	* @return nombre de lignes modifi�es dans la table Operation
	* */
	public int modifier(int ID)
	{
			Operation Op = getOperation(ID);
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Operation SET Op_Libelle=? WHERE Op_ID=?");
				ps.setString(1,Op.getOp_Libelle());
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
			ResultSet rs=null;
			Operation OperationRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Operation WHERE Op_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					OperationRetourne = new Operation(rs.getInt("Op_ID"),rs.getString("Op_Libelle"));
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
			ResultSet rs=null;
			Operation OperationRetourne = null;
	
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Operation WHERE Op_Libelle=?");
				ps.setString(1,nom);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					OperationRetourne = new Operation(rs.getInt("Op_ID"),rs.getString("Op_Libelle"));
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
		 * Permet de r�cup�rer toutes les pieces de la table
		 * @return la liste des pieces
		 */
		public List<Operation> getListOperation()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Operation> ListeOperations = new ArrayList<Operation>();
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Operation");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeOperations.add(new Operation(rs.getInt("Op_ID"),rs.getString("Op_Libelle")));
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

