package dao;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import dao.Connexion;
import Modele.Expedition;


	/**
	 * Classe d'accès aux données contenues dans la table Expedition
	 * */

	public class ExpeditionDAO {

private static Connection con;
		
		//singleton attribut permettant de mettre en oeuvre le design pattern singleton
		private static ExpeditionDAO singleton;
		private  ExpeditionDAO() throws Exception
		{
			Connexion connect;
			connect = new Connexion();
			con = connect.getConnection();	
		}
		public ExpeditionDAO getInstance() throws Exception
		{
			if(ExpeditionDAO.singleton==null)
				singleton=new ExpeditionDAO();
			return singleton;
		}
					/**
					 * Permet d'ajouter un Expedition dans la table Expedition
					 * @param a Expedition à ajouter
					 * @return le nombre de lignes ajoutées dans la table
					 */
					public static int ajouter(Expedition a)
					{

						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("INSERT INTO ExpeditionDAO (Exp_Date,Exp_A_ID,Exp_BExp_ID,Exp_C_ID,Exp_ID) VALUES (?,?,?,?,?)");
							ps.setDate(1,(Date)a.getExp_Date());
							ps.setInt(2,a.getExp_A_ID());
							ps.setInt(3,a.getExp_BExp_ID());
							ps.setInt(4,a.getExp_C_ID());
							ps.setInt(5,a.getExp_ID());

							
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
					* Permet de modifier la date de l'Expedition dans la table Expedition
					* @param Exp_Date la date de l'Expedition à modifier 
					* @return nombre de lignes modifiées dans la table Expedition
					*/
					public int modifierDate(int Exp_ID ,Date Exp_Date)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE Expedition SET Exp_Date=? WHERE Exp_ID=?");
								ps.setDate(1,Exp_Date);
								ps.setInt(2,Exp_ID);
								
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
					* Permet de modifier le client d'Expedition dans la table Expedition
					* @param Exp_C_ID de le client d'Expedition à modifier
					* @return nombre de lignes modifiées dans la table Expedition
					*/
					public int modifierClient(int Exp_ID ,int Exp_C_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE Expedition SET Exp_C_ID=? WHERE Exp_ID=?");
								ps.setInt(1,Exp_C_ID);
								ps.setInt(2,Exp_ID);
								
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
					* Permet de modifier leBon d'Expeditiond'une Expedition dans la table Expedition
					* @param Exp_BExp_ID de le Bon d'Expeditiond'une Expedition à modifier
					* @return nombre de lignes modifiées dans la table Expedition
					*/
					public int modifierBonExpedition(int Exp_ID ,int Exp_BExp_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE Expedition SET Exp_BExp_ID=? WHERE Exp_ID=?");
								ps.setInt(1,Exp_BExp_ID);
								ps.setInt(2,Exp_ID);
								
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
					* Permet de modifier l'assemblage d'une Expedition dans la table Expedition
					* @param Exp_A_ID de l'assemblage d'une Expedition à modifier 
					* @return nombre de lignes modifiées dans la table Expedition
					*/
					public int modifierAssemblage(int Exp_A_ID ,int Exp_ID)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE Expedition SET Exp_A_ID=? WHERE Exp_D=?");
								ps.setInt(1,Exp_A_ID);
								ps.setInt(2,Exp_ID);
								
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
					 * Permet de supprimer une Expedition dans la table Expedition
					 * @param Exp_ID de la Expedition à supprimer
					 *@return null si aucune Expedition ne correspond à ce Exp_ID du Expedition 
					 */
					public int supprimer(int Exp_ID)
					{
						PreparedStatement ps=null;
						int retour=0;
						
						//connexion a la base de données
						try {
							ps = con.prepareStatement("DELETE FROM Expedition WHERE Exp_ID=?");
							ps.setInt(1, Exp_ID);
				
										
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
					 * Permet de récupérer une Expedition 
					 * @param Exp_ID est l'ID de la Expedition
					 * @return la Expedition
					 * @return null si aucune Expedition ne correspond à cet ID
					 */
					public static ExpeditionDAO getExpeditionDAO(int Exp_ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						ExpeditionDAO retour=null;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("SELECT * FROM Expedition WHERE Exp_ID LIKE ?");
							ps.setInt(1,Exp_ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new ExpeditionDAO ();
							

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
					 * Permet de récupérer toutes les Expeditions de la table
					 * @return la liste des Expeditions
					 */
					public List<ExpeditionDAO> getListExpeditionDAO()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<ExpeditionDAO> retour=new ArrayList<ExpeditionDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM Expedition");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new ExpeditionDAO ());
							

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
					 * Permet de récupérer toutes les Expeditions de la table pour UN assemblage
					 * @return la liste des Expeditions
					 */
					public List<ExpeditionDAO> getListExpeditionDAO(int Exp_A_ID)
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<ExpeditionDAO> retour=new ArrayList<ExpeditionDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM Expedition");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new ExpeditionDAO ());
							

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
						ExpeditionDAO ExpeditionDAO=new ExpeditionDAO();
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode ajouter");
						System.out.println("********************");
						
						//test de la méthode ajouter
						Expedition a=new Expedition();
						int retour= dao.ExpeditionDAO.ajouter(a);
						System.out.println(retour+ " lignes ajoutées");

						
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode supprimer");
						System.out.println("********************");
						
						//test de la méthode supprimer
						Date Exp_Date= null;
						int retour1= ExpeditionDAO.supprimer(Exp_Date);
						System.out.println(retour1+ " lignes supprimées");
						
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode getExpeditionDAO avec Exp_Date");
						System.out.println("********************");
						
						//test de la méthode getExpedition avec Exp_Date
						ExpeditionDAO a2=dao.ExpeditionDAO.getExpeditionDAO(Exp_Date);
						System.out.println(a2);

						
											
						
						System.out.println("\n********************");
						System.out.println("Test de la méthode getListExpeditionDAO");
						System.out.println("********************");
						
						//test de la méthode getListExpeditionDAO
						List<ExpeditionDAO> liste=ExpeditionDAO.getListExpeditionDAO();
						System.out.println(liste);
						
					}        **/
		}

