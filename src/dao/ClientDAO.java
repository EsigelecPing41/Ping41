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
	* @param client à ajouter
	* @return nombre de lignes ajoutées dans la table Client
	*/
	public int ajouter(Client c)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("INSERT INTO Client (C_CodeClient,C_Nom,C_Login,C_Adresse,C_Description,C_Mdp) VALUES (?,?,?,?,?,?)");
				ps.setString(1,c.getC_CodeClient());
				ps.setString(2,c.getC_Nom());
				ps.setString(3,c.getC_Login());
				ps.setString(4,c.getC_Adresse());
				ps.setString(5,c.getC_Description());
				ps.setString(6,c.getC_Mdp());
				
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
	 * @param code client du client à supprimer
	 *@return null si aucun client ne correspond à ce code client
	 */
	public int supprimer(String C_CodeClient)
	{
			PreparedStatement ps=null;
			int retour=0;
			
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("DELETE FROM Client WHERE C_CodeClient=?");
				ps.setString(1,C_CodeClient);
	
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
	* @param code du client et le nouveau nom
	* @return nombre de lignes modifiées dans la table Client
	* */
	public int modifierNom(String C_CodeClient,String nom)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Nom =? WHERE C_CodeClient=?");
				ps.setString(1,nom);
				ps.setString(2,C_CodeClient);
				
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
	* Permet de modifier le login du client
	* @param code du client et le nouveau login
	* @return nombre de lignes modifiées dans la table Client
	* */
	public int modifierLogin(String C_CodeClient,String login)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Login =? WHERE C_CodeClient=?");
				ps.setString(1,login);
				ps.setString(2,C_CodeClient);
				
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
	* @return nombre de lignes modifiées dans la table Client
	* */
	public int modifierAdresse(String C_CodeClient,String adresse)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Adresse =? WHERE C_CodeClient=?");
				ps.setString(1,adresse);
				ps.setString(2,C_CodeClient);
				
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
	* @param code du client et la nouvelle description
	* @return nombre de lignes modifiées dans la table Client
	* */
	public int modifierDescription(String C_CodeClient,String description)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Description =? WHERE C_CodeClient=?");
				ps.setString(1,description);
				ps.setString(2,C_CodeClient);
				
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
	* @param code du client et le nouveau mot de passe
	* @return nombre de lignes modifiées dans la table Client
	* */
	public int modifierMdp(String C_CodeClient,String mdp)
	{
			PreparedStatement ps = null;
			int retour=0;
		
			//connexion a la base de données
			try 
			{
				ps = con.prepareStatement("UPDATE Client SET C_Mdp =? WHERE C_CodeClient=?");
				ps.setString(1,mdp);
				ps.setString(2,C_CodeClient);
				
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
		 * Permet de récupérer un client à partir de son code
		 * @param code du client à récupérer
		 * @return le client
		 * @return null si aucun client ne correspond à ce code
		 */
		public Client getCLient(String C_CodeClient)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Client ClientRetourne = null;
	
		
			//connexion a la base de données
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Client WHERE C_CodeClient=?");
				ps.setString(1,C_CodeClient);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					ClientRetourne = new Client(rs.getString("C_CodeClient"),rs.getString("C_Nom"),rs.getString("C_Login"),rs.getString("C_Adresse"),rs.getString("C_Description"),rs.getString("C_Mdp"));
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
		 * Permet de récupérer un client à partir de son login et de son mot de passe
		 * @return login et mot de passe du client a recuperer
		 * @return null si aucun client ne correspond à ce code
		 */
		public Client getCLient(String C_Login,String C_Mdp)
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			Client ClientRetourne = null;
	
		
			//connexion a la base de données
			try 
			{	
				ps = con.prepareStatement("SELECT * FROM Client WHERE C_Login=? AND C_Mdp=?");
				ps.setString(1,C_Login);
				ps.setString(2,C_Mdp);
							
				//on execute la requete 
				rs = ps.executeQuery();
				if(rs.next())
					ClientRetourne = new Client(rs.getString("C_CodeClient"),rs.getString("C_Nom"),rs.getString("C_Login"),rs.getString("C_Adresse"),rs.getString("C_Description"),rs.getString("C_Mdp"));
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
		 * Permet de récupérer tous les clients de la table
		 * @return la liste des clients
		 */
		public List<Client> getListClient()
		{
			PreparedStatement ps = null;
			ResultSet rs=null;
			List<Client> ListeClient = new ArrayList<Client>();
		
			//connexion a la base de données
			try 
			{
				
				ps = con.prepareStatement("SELECT * FROM CLient");
										
				//on execute la requete 
				rs=ps.executeQuery();
				//on parcourt les lignes du resultat
				while(rs.next())
					ListeClient.add(new Client(rs.getString("C_CodeClient"),rs.getString("C_Nom"),rs.getString("C_Login"),rs.getString("C_Adresse"),rs.getString("C_Description"),rs.getString("C_Mdp")));
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


