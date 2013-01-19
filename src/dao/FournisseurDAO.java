package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Fournisseur;

public class FournisseurDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static FournisseurDAO singleton;
		private FournisseurDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static FournisseurDAO getInstance() throws Exception
		{
			if(FournisseurDAO.singleton==null)
				singleton=new FournisseurDAO();
			return singleton;
		}
		
		
		/**
		 * Permet d'ajouter un Fournisseur dans la table Fournisseur
		 * @param Fournisseur à ajouter
		 * @return nombre de lignes ajoutées dans la table Fournisseur
		 */
	public int ajouter(Fournisseur f)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("INSERT INTO Fournisseur (F_CodeFournisseur,F_Nom,F_Adresse,F_Description) VALUES (?,?,?,?)");
				ps.setString(1,f.getF_CodeFournisseur());
				ps.setString(1,f.getF_Nom());
				ps.setString(2,f.getF_Adresse());
				ps.setString(3,f.getF_Description());
				
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
		 * Permet de supprimer un Fournisseur de la table Fournisseur
		 * @param code fournisseur du Fournisseur à supprimer
		 *@return null si aucun Fournisseur ne correspond à cet id
		 */
	public int supprimer(String code)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("DELETE FROM Fournisseur WHERE F_CodeFournisseur=?");
				ps.setString(1,code);
	
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
	* Permet de modifier le nom du fournisseur
	* @param code du fournisseur et le nouveau nom
	* @return nombre de lignes modifiées dans la table Fournisseur
	* */
	public int modifierNom(String code,String nom)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Fournisseur SET F_Nom =? WHERE F_CodeFournisseur=?");
				ps.setString(1,nom);
				ps.setString(2,code);
				
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
	* Permet de modifier l'adresse du fournisseur
	* @param code du fournisseur et la nouvelle adresse
	* @return nombre de lignes modifiées dans la table Fournisseur
	* */
	public int modifierAdresse(String code,String adresse)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Fournisseur SET F_Adresse =? WHERE F_CodeFournisseur=?");
				ps.setString(1,adresse);
				ps.setString(2,code);
				
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
	* Permet de modifier la description d'un fournisseur
	* @param code du fournisseur et la nouvelle description
	* @return nombre de lignes modifiées dans la table Fournisseur
	* */
	public int modifierDescription(String code,String description)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Fournisseur SET F_Description =? WHERE F_CodeFournisseur=?");
				ps.setString(1,description);
				ps.setString(2,code);
				
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
		 * Permet de récupérer un Fournisseur à partir de son code
		 * @param code du Fournisseur à récupérer
		 * @return le Fournisseur
		 * @return null si aucun Fournisseur ne correspond à cet code fournisseur
		 */
		public Fournisseur getFournisseur(String code)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Fournisseur FournisseurRetourne = null;
	
		
			//connexion a la base de données
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Fournisseur WHERE F_CodeFournisseur=?");
				ps.setString(1,code);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					FournisseurRetourne = new Fournisseur(rs.getString("F_CodeFournisseur"),rs.getString("F_Nom"),rs.getString("F_Adresse"),rs.getString("F_Description"));
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
			return FournisseurRetourne;
		}
		
		/**
		 * Permet de récupérer un Fournisseur à partir de son nom
		 * @param nom du Fournisseur à récupérer
		 * @return le Fournisseur
		 * @return null si aucun Fournisseur ne correspond à ce nom
		 */
		public Fournisseur getFournisseurNom(String nom)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Fournisseur FournisseurRetourne = null;
	
		
			//connexion a la base de données
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Fournisseur WHERE F_Nom=?");
				ps.setString(1,nom);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					FournisseurRetourne = new Fournisseur(rs.getString("F_CodeFournisseur"),rs.getString("F_Nom"),rs.getString("F_Adresse"),rs.getString("F_Description"));
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
			return FournisseurRetourne;
		}
		
		/**
		 * Permet de récupérer tous les Fournisseurs de la table
		 * @return la liste des Fournisseurs
		 */
		public List<Fournisseur> getListFournisseur()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Fournisseur> ListeFournisseur = new ArrayList<Fournisseur>();
		
			//connexion a la base de données
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Fournisseur");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeFournisseur.add(new Fournisseur(rs.getString("F_CodeFournisseur"),rs.getString("F_Nom"),rs.getString("F_Adresse"),rs.getString("F_Description")));
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
			return ListeFournisseur;
		
		}
}


