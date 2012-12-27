package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.Client;

public class ClientDAO 
{
		private	 Connection con;
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static ClientDAO singleton;
		private ClientDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}

		public static ClientDAO getInstance() throws Exception
		{
			if(ClientDAO.singleton==null)
				singleton=new ClientDAO();
			return singleton;
		}
		
		
		
	/**
	* Permet d'ajouter un client dans la table Client
	* @param client � ajouter
	* @return nombre de lignes ajout�es dans la table Client
	*/
	public int ajouter(Client c)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("INSERT INTO Client (C_Nom,C_Adresse,C_Description,C_Mdp) VALUES (?,?,?,?)");
				ps.setString(1,c.getC_Nom());
				ps.setString(2,c.getC_Adresse());
				ps.setString(3,c.getC_Description());
				ps.setString(4,c.getC_Mdp());
				
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
	 * Permet de supprimer un client de la table CLient
	 * @param ID du client � supprimer
	 *@return null si aucun client ne correspond � cet id
	 */
	public int supprimer(int ID)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("DELETE FROM Client WHERE C_ID=?");
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
	* Permet de modifier le nom du client
	* @param ID du client et le nouveau nom
	* @return nombre de lignes modifi�es dans la table Client
	* */
	public int modifierNom(int ID,String nom)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Nom =? WHERE C_ID=?");
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
	* Permet de modifier l'adresse du client
	* @param ID du client et la nouvelle adresse
	* @return nombre de lignes modifi�es dans la table Client
	* */
	public int modifierAdresse(int ID,String adresse)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Adresse =? WHERE C_ID=?");
				ps.setString(1,adresse);
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
	* Permet de modifier la description du client
	* @param ID du client et la nouvelle description
	* @return nombre de lignes modifi�es dans la table Client
	* */
	public int modifierDescription(int ID,String description)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Description =? WHERE C_ID=?");
				ps.setString(1,description);
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
	* Permet de modifier le mot de passe du client
	* @param ID du client et le nouveau mot de passe
	* @return nombre de lignes modifi�es dans la table Client
	* */
	public int modifierMdp(int ID,String mdp)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de donn�es
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Mdp =? WHERE C_ID=?");
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
		 * Permet de r�cup�rer un client � partir de son id
		 * @param id du client � r�cup�rer
		 * @return le client
		 * @return null si aucun client ne correspond � cet id
		 */
		public Client getCLient(int ID)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Client ClientRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Client WHERE C_ID=?");
				ps.setInt(1,ID);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					ClientRetourne = new Client(rs.getInt("C_ID"),rs.getString("C_Nom"),rs.getString("C_Adresse"),rs.getString("C_Description"),rs.getString("C_Mdp"));
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
			return ClientRetourne;
		}
		
		/**
		 * Permet de r�cup�rer un client � partir de son nom
		 * @param nom du client � r�cup�rer
		 * @return le client
		 * @return null si aucun client ne correspond � ce nom
		 */
		public Client getCLient(String nom)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Client ClientRetourne = null;
	
		
			//connexion a la base de donn�es
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Client WHERE C_Nom=?");
				ps.setString(1,nom);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					ClientRetourne = new Client(rs.getInt("C_ID"),rs.getString("C_Nom"),rs.getString("C_Adresse"),rs.getString("C_Description"),rs.getString("C_Mdp"));
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
			return ClientRetourne;
		}
		
		
		/**
		 * Permet de r�cup�rer tous les clients de la table
		 * @return la liste des clients
		 */
		public List<Client> getListClient()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Client> ListeClient = new ArrayList<Client>();
		
			//connexion a la base de donn�es
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM CLient");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeClient.add(new Client(rs.getInt("C_ID"),rs.getString("C_Nom"),rs.getString("C_Adresse"),rs.getString("C_Description"),rs.getString("C_Mdp")));
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
			return ListeClient;
		
		}
}


