package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.Connexion;
import Modele.BonLivraison;

		/**
		 * Classe d'accès aux données contenues dans la table Bon de Livraison
		 * */

		public class BonLivraisonDAO {
			private static Connection con;
			
			//singleton attribut permettant de mettre en oeuvre le design pattern singleton
			private static BonLivraisonDAO singleton;
			private  BonLivraisonDAO() throws Exception
			{
				Connexion connect;
				connect = new Connexion();
				con = connect.getConnection();	
			}

			public BonLivraisonDAO getInstance() throws Exception
			{
				if(BonLivraisonDAO.singleton==null)
					singleton=new BonLivraisonDAO();
				return singleton;
				}
			
		
			/**
			 * Permet d'ajouter un Bon de Livraison 
			 * @param a Bon de Livraison à ajouter
			 * @return le nombre de lignes ajoutées dans la table
			 */
			public static int ajouter(BonLivraison a)
			{

				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de données
				try {

					ps = con.prepareStatement("INSERT INTO BonLivraisonDAO (Bliv_ID,Bliv_Fournisseur,Bliv_Date) VALUES (?,?,?)");
					ps.setInt(1,a.getBliv_ID());
					ps.setString(2,a.getBliv_Fournisseur());
					ps.setDate(3,(Date)a.getBliv_Date());

					
					//on execute la requete 
					retour=ps.executeUpdate();
					

				} catch (Exception ee) {
					ee.printStackTrace();
				} finally {
					//fermeture du getConnection().preparedStatement et de la connexion
					try {if (ps != null)ps.close();} catch (Exception t) {}
				}
				return retour;				}


			/**
			* Permet de modifier la date d'un bon dans la table BonLivraison
			* @param Bliv_Date de la date du bon à modifier 
			* @return nombre de lignes modifiées dans la table BonLivraison
			*/
			public int modifierDate (int Bliv_ID ,Date Bliv_Date)				
			{
				PreparedStatement ps = null;
				int retour=0;
			
				//connexion a la base de données
				try 
				{
					ps = con.prepareStatement("UPDATE BonLivraison SET Bliv_Date=? WHERE Bliv_ID=?");
					ps.setDate(1, Bliv_Date);
					ps.setInt(2,Bliv_ID);
					
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
			* Permet de modifier le fournisseur dans la table BonLivraison
			* @param Bliv_Fournisseur de le fournisseur à modifier 
			* @return nombre de lignes modifiées dans la table BonLivraison
			*/
			public int modifierFournisseur (int Bliv_ID ,String Bliv_Fournisseur)
			{
					PreparedStatement ps = null;
					int retour=0;
				
					//connexion a la base de données
					try 
					{
						ps = con.prepareStatement("UPDATE BonLivraison SET Bliv_Fournisseur=? WHERE Bliv_ID=?");
						ps.setString(1,Bliv_Fournisseur);
						ps.setInt(2,Bliv_ID);
						
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
			 * Permet de supprimer un BonLivraison dans la table BonLivraison
			 * @param Bliv_ID du Bon  à supprimer
			 *@return null si aucun Bon ne correspond à cet ID du BonLivraison
			 */
			public int supprimer(int Bliv_ID)
			{
				PreparedStatement ps=null;
				int retour=0;
				
				//connexion a la base de données
				try {
					ps = con.prepareStatement("DELETE FROM BonLivraison WHERE Bliv_ID=?");
					ps.setInt(1, Bliv_ID);
		
								
					//on execute la requete 
					retour=ps.executeUpdate();

				} catch (Exception ee) {
					ee.printStackTrace();
				} finally {
					//fermeture du rs,preparedStatement et de la connexion
					
					try {if (ps != null)ps.close();} catch (Exception t) {}
				}
				return retour;
			
			}	
			
			/**
			 * Permet de récupérer un BonLivraison d'un Bon 
			 * @param Bliv_ID est l'ID du Bon à récupérer
			 * @return le Bon
			 * @return null si aucun Bon ne correspond à cet ID
			 */
			public static BonLivraisonDAO getBonLivraisonDAO(int Bliv_ID)
			{					
				PreparedStatement ps = null;
				ResultSet rs=null;
				BonLivraisonDAO retour=null;
			
				//connexion a la base de données
				try {

					ps = con.prepareStatement("SELECT * FROM BonLivraison WHERE Bliv_ID LIKE ?");
					ps.setInt (1,Bliv_ID);
								
					//on execute la requete 
					rs=ps.executeQuery();
					if(rs.next())
						retour=new BonLivraisonDAO ();
					

				} catch (Exception ee) {
					ee.printStackTrace();
				} finally {
					//fermeture du rs,preparedStatement et de la connexion
					try {if (rs != null)rs.close();} catch (Exception t) {}
					try {if (ps != null)ps.close();} catch (Exception t) {}
				}
				return retour;
			
			}
						
			
			/**
			 * Permet de récupérer tous les Bons de livraison de la table
			 * @return la liste des Bons de livraison
			 */
			public List<BonLivraisonDAO> getListBonLivraisonDAO()
			{
				PreparedStatement ps = null;
				ResultSet rs=null;
				List<BonLivraisonDAO> retour=new ArrayList<BonLivraisonDAO>();
			
				//connexion a la base de données
				try {
					ps = con.prepareStatement("SELECT * FROM BonLivraison");
											
					//on execute la requete 
					rs=ps.executeQuery();
					//on parcourt les lignes du resultat
					while(rs.next())
						retour.add(new BonLivraisonDAO ());
					

				} catch (Exception ee) {
					ee.printStackTrace();
				} finally {
					//fermeture du rs,preparedStatement et de la connexion
					try {if (rs != null)rs.close();} catch (Exception t) {}
					try {if (ps != null)ps.close();} catch (Exception t) {}
				}
				return retour;
			
			}

			/**
			 * Permet de récupérer UN Bon de livraison de la table
			 * @return le Bon de livraison demande
			 */
			public List<BonLivraisonDAO> getListBonLivraisonDAO(int Bliv_ID)
			{
				PreparedStatement ps = null;
				ResultSet rs=null;
				List<BonLivraisonDAO> retour=new ArrayList<BonLivraisonDAO>();
			
				//connexion a la base de données
				try {
					ps = con.prepareStatement("SELECT * FROM BonLivraison");
											
					//on execute la requete 
					rs=ps.executeQuery();
					//on parcourt les lignes du resultat
					while(rs.next())
						retour.add(new BonLivraisonDAO ());
					

				} catch (Exception ee) {
					ee.printStackTrace();
				} finally {
					//fermeture du rs,preparedStatement et de la connexion
					try {if (rs != null)rs.close();} catch (Exception t) {}
					try {if (ps != null)ps.close();} catch (Exception t) {}
				}
				return retour;
			
			}
			
			
			/**
			 * Permet de récupérer UN Bon de livraison de la table par rapport au Numero Dossier
			 * @return le Bon de livraison demande
			 */
			public List<BonLivraisonDAO> getListBonLivraisonDAO(String Bliv_NumDossier)
			{
				PreparedStatement ps = null;
				ResultSet rs=null;
				List<BonLivraisonDAO> retour=new ArrayList<BonLivraisonDAO>();
			
				//connexion a la base de données
				try {
					ps = con.prepareStatement("SELECT * FROM BonLivraison");
											
					//on execute la requete 
					rs=ps.executeQuery();
					//on parcourt les lignes du resultat
					while(rs.next())
						retour.add(new BonLivraisonDAO ());
					

				} catch (Exception ee) {
					ee.printStackTrace();
				} finally {
					//fermeture du rs,preparedStatement et de la connexion
					try {if (rs != null)rs.close();} catch (Exception t) {}
					try {if (ps != null)ps.close();} catch (Exception t) {}
				}
				return retour;
			
			}
					
						
						
			
						
						//main permettant de tester la classe
	/**					public static void main(int[] args){
							BonLivraisonDAO BonLivraisonDAO=new BonLivraisonDAO();
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode ajouter");
							System.out.println("********************");
							
							//test de la méthode ajouter
							BonLivraison a=new BonLivraison();
							int retour= dao.BonLivraisonDAO.ajouter(a);
							System.out.println(retour+ " lignes ajoutées");

							
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode supprimer");
							System.out.println("********************");
							
							//test de la méthode supprimer
							int BLiv_ID= (Integer) null;
							int retour1= BonLivraisonDAO.supprimer(BLiv_ID);
							System.out.println(retour1+ " lignes supprimées");
							
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode getBonLivraisonDAO avec BLiv_ID");
							System.out.println("********************");
							
							//test de la méthode getBonLivraison avec BLiv_ID
							BonLivraisonDAO a2=dao.BonLivraisonDAO.getBonLivraisonDAO(BLiv_ID);
							System.out.println(a2);

							
												
							
							System.out.println("\n********************");
							System.out.println("Test de la méthode getListBonLivraisonDAO");
							System.out.println("********************");
							
							//test de la méthode getListBonLivraisonDAO
							List<BonLivraisonDAO> liste=BonLivraisonDAO.getListBonLivraisonDAO();
							System.out.println(liste);
							
						}**/
		       
			}





