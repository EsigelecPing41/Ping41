package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Operateur;

public class OperateurDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static OperateurDAO singleton;
		private OperateurDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static OperateurDAO getInstance() throws Exception
		{
			if(OperateurDAO.singleton==null)
				singleton=new OperateurDAO();
			return singleton;
		}
		
		
	/**
	 * Permet d'ajouter un operateur dans la classe Operateur
	 * @param operateur � ajouter
	 * @return nombre de lignes ajout�es dans la table Operateur
	 */
	public int ajouter(Operateur o)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("INSERT INTO Operateur (O_Nom,O_Prenom,O_MotDePasse) VALUES (?,?,?)");
				ps.setString(1,o.getO_Nom());
				ps.setString(2,o.getO_Prenom());
				ps.setString(3,o.getO_MotDePasse());
				
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
	* Permet de supprimer un operateur de la classe Operateur
	* @param ID de l'operateur � supprimer
	*@return null si aucun operateur ne correspond � cet id
    */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("DELETE FROM Operateur WHERE O_ID=?");
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
	* Permet de modifier le nom de l'operateur
	* @param ID de l'operateur et le nouveau nom
	* @return nombre de lignes modifi�es dans la table Operateur
	* */
	public int modifierNom(int ID,String nom)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Operateur SET O_Nom =? WHERE O_ID=?");
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
	* Permet de modifier le prenom de l'operateur
	* @param ID de l'operateur et la nouveau prenom
	* @return nombre de lignes modifi�es dans la table Operateur
	* */
	public int modifierPrenom(int ID,String prenom)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Operateur SET O_Prenom =? WHERE O_ID=?");
				ps.setString(1,prenom);
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
	* Permet de modifier le mot de passe de l'operateur
	* @param ID de l'operateur et le nouveau mot de passe
	* @return nombre de lignes modifi�es dans la table Operateur
	* */
	public int modifierMdp(int ID,String mdp)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Operateur SET O_Mdp =? WHERE O_ID=?");
				ps.setString(1,mdp);
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
		 * Permet de r�cup�rer un operateur � partir de son id
		 * @param id de l'operateur � r�cup�rer
		 * @return l'operateur
		 * @return null si aucun operateur ne correspond � cet id
		 */
		public Operateur getOperateur(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Operateur OperateurRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Operateur WHERE O_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					OperateurRetourne = new Operateur(rs.getInt("O_ID"),rs.getString("O_Nom"),rs.getString("O_Prenom"),rs.getString("O_MotDePasse"));
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
			return OperateurRetourne;
		}
		
		/**
		 * Permet de r�cup�rer un operateur � partir de son nom et prenom
		 * @param nom et prenom de l'operateur � r�cup�rer
		 * @return l'operateur
		 * @return null si aucun operateur ne correspond � ces nom et prenom
		 */
		public Operateur getOperateur(String nom,String prenom)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Operateur OperateurRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				System.out.println("et là ?");
				ps = con.prepareStatement("SELECT * FROM Operateur WHERE O_login=? AND O_password=?");
				ps.setString(1,nom);
				ps.setString(2,prenom);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					OperateurRetourne = new Operateur(rs.getInt("O_ID"),rs.getString("O_Nom"),rs.getString("O_Prenom"),rs.getString("O_Password"));
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
			return OperateurRetourne;
		}
	
		/**
		 * Permet de r�cup�rer tous les operateurs de la table
		 * @return la liste des operateurs
		 */
		public List<Operateur> getListOperateur()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Operateur> ListeOperateurs = new ArrayList<Operateur>();
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM Operateur");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeOperateurs.add(new Operateur(rs.getInt("O_ID"),rs.getString("O_Nom"),rs.getString("O_Prenom"),rs.getString("O_MotDePasse")));
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
			return ListeOperateurs;
		
		}
}


