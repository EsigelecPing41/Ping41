package dao;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import Modele.Commande;
import dao.Connexion;


	/**
	 * Classe d'accès aux données contenues dans la table Commande
	 * */

	public class CommandeDAO {
		private static Connection con;
		
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static CommandeDAO singleton;
		private  CommandeDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}
		public CommandeDAO getInstance() throws Exception
		{
			if(CommandeDAO.singleton==null)
				singleton=new CommandeDAO();
			return singleton;
		}
					/**
					 * Permet d'ajouter un Commande dans la table Commande
					 * @param a Commande à ajouter
					 * @return le nombre de lignes ajoutées dans la table
					 */
					public static int ajouter(Commande a)
					{

						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("INSERT INTO CommandeDAO (Com_Date,Com_ID,Com_F_ID,Com_BCom_ID,Com_P_ID) VALUES (?,?,?,?,?)");
							ps.setDate(1,(Date)a.getCom_Date());
							ps.setInt(2,a.getCom_ID());
							ps.setInt(3,a.getCom_F_ID());
							ps.setInt(4,a.getCom_BCom_ID());
							ps.setInt(5,a.getCom_P_ID());

							
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
					* Permet de modifier la date de la Commande dans la table Commande
					* @param Com_Date la date de la Commande à modifier 
					* @return nombre de lignes modifiées dans la table Commande
					*/
					public int modifierDate(int Com_ID ,Date Com_Date)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE Commande SET Com_Date=? WHERE Com_ID=?");
								ps.setDate(1,Com_Date);
								ps.setInt(2,Com_ID);
								
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
					* Permet de modifier le Bon de Commande dans la table Commande
					* @param Com_BCom_ID de le Bon de Commande à modifier
					* @return nombre de lignes modifiées dans la table Commande
					*/
					public int modifierBonCommande(int Com_ID ,int Com_BCom_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE Commande SET Com_BCom_ID=? WHERE Com_ID=?");
								ps.setInt(1,Com_BCom_ID);
								ps.setInt(2,Com_ID);
								
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
					* Permet de modifier le Fournisseur d'une Commande dans la table Commande
					* @param Com_F_ID de le Fournisseur d'une Commande à modifier
					* @return nombre de lignes modifiées dans la table Commande
					*/
					public int modifierFournisseur(int Com_ID ,int Com_F_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE Commande SET Com_F_ID=? WHERE Com_ID=?");
								ps.setInt(1,Com_F_ID);
								ps.setInt(2,Com_ID);
								
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
					* Permet de modifier la Piece d'une Commande dans la table Commande
					* @param Com_P_ID de la Piece d'une Commande à modifier 
					* @return nombre de lignes modifiées dans la table Commande
					*/
					public int modifierPiece(int Com_ID ,int Com_P_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE Commande SET Com_P_ID=? WHERE Com_ID=?");
								ps.setInt(1,Com_P_ID);
								ps.setInt(2,Com_ID);
								
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
					 * Permet de supprimer une Commande dans la table Commande
					 * @param Com_ID de la Commande à supprimer
					 *@return null si aucune Commande ne correspond à ce Com_ID du Commande 
					 */
					public int supprimer(int Com_ID)
					{
						PreparedStatement ps=null;
						int retour=0;
						
						//connexion a la base de données
						try {
							ps = con.prepareStatement("DELETE FROM Commande WHERE Com_ID=?");
							ps.setInt(1, Com_ID);
				
										
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
					 * Permet de récupérer une Commande 
					 * @param Com_ID est l'ID de la Commande
					 * @return la Commande
					 * @return null si aucune Commande ne correspond à cet ID
					 */
					public static CommandeDAO getCommandeDAO(int Com_ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						CommandeDAO retour=null;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("SELECT * FROM Commande WHERE Com_ID LIKE ?");
							ps.setInt(1,Com_ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new CommandeDAO ();
							

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
					 * Permet de récupérer toutes les Commandes de la table
					 * @return la liste des Commandes
					 */
					public List<CommandeDAO> getListCommandeDAO()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<CommandeDAO> retour=new ArrayList<CommandeDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM Commande");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new CommandeDAO ());
							

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
					 * Permet de récupérer toutes les Commandes de la table pour UNE piece
					 * @return la liste des Commandes
					 */
					public List<CommandeDAO> getListCommandeDAO(int Com_P_ID)
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<CommandeDAO> retour=new ArrayList<CommandeDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM Commande");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new CommandeDAO ());
							

						} catch (Exception ee) {
							ee.printStackTrace();
						} finally {
							//fermeture du rs,preparedStatement et de la connexion
							try {if (rs != null)rs.close();} catch (Exception t) {}
							try {if (ps != null)ps.close();} catch (Exception t) {}
						}
						return retour;
					
					}

			
					
					
	/**				//main permettant de tester la classe
					public static void main(int[] args){
						CommandeDAO CommandeDAO=new CommandeDAO();
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode ajouter");
						System.out.println("********************");
						
						//test de la méthode ajouter
						Commande a=new Commande();
						int retour= dao.CommandeDAO.ajouter(a);
						System.out.println(retour+ " lignes ajoutées");

						
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode supprimer");
						System.out.println("********************");
						
						//test de la méthode supprimer
						Date ComDate= null;
						int retour1= CommandeDAO.supprimer(ComDate);
						System.out.println(retour1+ " lignes supprimées");
						
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode getCommandeDAO avec ComDate");
						System.out.println("********************");
						
						//test de la méthode getCommande avec ComDate
						CommandeDAO a2=dao.CommandeDAO.getCommandeDAO(ComDate);
						System.out.println(a2);

						
											
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode getListCommandeDAO");
						System.out.println("********************");
						
						//test de la méthode getListCommandeDAO
						List<CommandeDAO> liste=CommandeDAO.getListCommandeDAO();
						System.out.println(liste);
						
					}   **/     
		}


