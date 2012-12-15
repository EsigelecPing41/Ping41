package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Fournisseur;

public class FournisseurDAO 
{
		private Connection con;
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
		 * @param Fournisseur � ajouter
		 * @return nombre de lignes ajout�es dans la table Fournisseur
		 */
	public int ajouter(Fournisseur f)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("INSERT INTO Fournisseur (F_Nom,F_Adresse,F_Description) VALUES (?,?,?)");
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
		 * @param ID du Fournisseur � supprimer
		 *@return null si aucun Fournisseur ne correspond � cet id
		 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("DELETE FROM Fournisseur WHERE F_ID=?");
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
		 * Permet de r�cup�rer un Fournisseur � partir de son id
		 * @param id du Fournisseur � r�cup�rer
		 * @return le Fournisseur
		 * @return null si aucun Fournisseur ne correspond � cet id
		 */
		public Fournisseur getFournisseur(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Fournisseur FournisseurRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Fournisseur WHERE F_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					FournisseurRetourne = new Fournisseur(rs.getInt("F_ID"),rs.getString("F_Nom"),rs.getString("F_Adresse"),rs.getString("F_Description"));
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
		 * Permet de r�cup�rer un Fournisseur � partir de son nom
		 * @param nom du Fournisseur � r�cup�rer
		 * @return le Fournisseur
		 * @return null si aucun Fournisseur ne correspond � ce nom
		 */
		public Fournisseur getFournisseur(String nom)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Fournisseur FournisseurRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Fournisseur WHERE F_Nom=?");
				ps.setString(1,nom);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					FournisseurRetourne = new Fournisseur(rs.getInt("F_ID"),rs.getString("F_Nom"),rs.getString("F_Adresse"),rs.getString("F_Description"));
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
		 * Permet de r�cup�rer tous les Fournisseurs de la table
		 * @return la liste des Fournisseurs
		 */
		public List<Fournisseur> getListFournisseur()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Fournisseur> ListeFournisseur = new ArrayList<Fournisseur>();
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Fournisseur");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeFournisseur.add(new Fournisseur(rs.getInt("F_ID"),rs.getString("F_Nom"),rs.getString("F_Adresse"),rs.getString("F_Description")));
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


