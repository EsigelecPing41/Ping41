package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modele.BonExpedition;
import dao.Connexion;


			/**
			 * Classe d'accès aux données contenues dans la table Bon de Expedition
			 * */

				public class BonExpeditionDAO {
					private static Connection con;
					
					//singleton attribut permettant de mettre en oeuvre le design pattern singleton
					private static BonExpeditionDAO singleton;
					private  BonExpeditionDAO() throws Exception
					{
						Connexion connect;
						connect = new Connexion();
						con = connect.getConnection();	
					}

					public BonExpeditionDAO getInstance() throws Exception
					{
						if(BonExpeditionDAO.singleton==null)
							singleton=new BonExpeditionDAO();
						return singleton;
						}
					
				
					/**
					 * Permet d'ajouter un BonExpedition 
					 * @param a BonExpedition à ajouter
					 * @return le nombre de lignes ajoutées dans la table
					 */
					public static int ajouter(BonExpedition a)
					{

						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("INSERT INTO BonExpeditionDAO (BExp_ID,BExp_Client,BExp_Date) VALUES (?,?,?)");
							ps.setInt(1,a.getBExp_ID());
							ps.setString(2,a.getBExp_Client());
							ps.setDate(3,(Date)a.getBExp_Date());

							
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
					* Permet de modifier la date d'un bon dans la table BonExpedition
					* @param BExp_Date de la date du bon à modifier 
					* @return nombre de lignes modifiées dans la table BonExpedition
					*/
					public int modifierDate (int BExp_ID ,Date BExp_Date)				
					{
						PreparedStatement ps = null;
						int retour=0;
					
						//connexion a la base de données
						try 
						{
							ps = con.prepareStatement("UPDATE BonExpedition SET BExp_Date=? WHERE BExp_ID=?");
							ps.setDate(1, BExp_Date);
							ps.setInt(2,BExp_ID);
							
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
					* Permet de modifier le fournisseur dans la table BonExpedition
					* @param BExp_Client de le fournisseur à modifier 
					* @return nombre de lignes modifiées dans la table BonExpedition
					*/
					public int modifierFournisseur (int BExp_ID ,String BExp_Client)
					{
							PreparedStatement ps = null;
							int retour=0;
						
							//connexion a la base de données
							try 
							{
								ps = con.prepareStatement("UPDATE BonExpedition SET BExp_Client=? WHERE BExp_ID=?");
								ps.setString(1,BExp_Client);
								ps.setInt(2,BExp_ID);
								
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
					 * Permet de supprimer un BonExpedition dans la table BonExpedition
					 * @param BExp_ID du Bon  à supprimer
					 *@return null si aucun Bon ne correspond à cet ID du BonExpedition
					 */
					public int supprimer(int BExp_ID)
					{
						PreparedStatement ps=null;
						int retour=0;
						
						//connexion a la base de données
						try {
							ps = con.prepareStatement("DELETE FROM BonExpedition WHERE BExp_ID=?");
							ps.setInt(1, BExp_ID);
				
										
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
					 * Permet de récupérer un BonExpedition d'un Bon 
					 * @param BExp_ID est l'ID du Bon à récupérer
					 * @return le Bon
					 * @return null si aucun Bon ne correspond à cet ID
					 */
					public static BonExpeditionDAO getBonExpeditionDAO(int BExp_ID)
					{					
						PreparedStatement ps = null;
						ResultSet rs=null;
						BonExpeditionDAO retour=null;
					
						//connexion a la base de données
						try {

							ps = con.prepareStatement("SELECT * FROM BonExpedition WHERE BExp_ID LIKE ?");
							ps.setInt (1,BExp_ID);
										
							//on execute la requete 
							rs=ps.executeQuery();
							if(rs.next())
								retour=new BonExpeditionDAO ();
							

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
					 * Permet de récupérer tous les Bons d'Expedition de la table
					 * @return la liste des Bons d'Expedition
					 */
					public List<BonExpeditionDAO> getListBonExpeditionDAO()
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonExpeditionDAO> retour=new ArrayList<BonExpeditionDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonExpedition");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonExpeditionDAO ());
							

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
					 * Permet de récupérer UN Bon d'Expedition de la table
					 * @return le Bon d'Expedition
					 */
					public List<BonExpeditionDAO> getListBonExpeditionDAO(int BExp_ID)
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonExpeditionDAO> retour=new ArrayList<BonExpeditionDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonExpedition");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonExpeditionDAO ());
							

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
					 * Permet de récupérer UN Bon d'Expedition de la table par rapport au Numero Dossier
					 * @return le Bon d'Expedition
					 */
					public List<BonExpeditionDAO> getListBonExpeditionDAO(String BExp_NumDossier)
					{
						PreparedStatement ps = null;
						ResultSet rs=null;
						List<BonExpeditionDAO> retour=new ArrayList<BonExpeditionDAO>();
					
						//connexion a la base de données
						try {
							ps = con.prepareStatement("SELECT * FROM BonExpedition");
													
							//on execute la requete 
							rs=ps.executeQuery();
							//on parcourt les lignes du resultat
							while(rs.next())
								retour.add(new BonExpeditionDAO ());
							

						} catch (Exception ee) {
							ee.printStackTrace();
						} finally {
							//fermeture du rs,preparedStatement et de la connexion
							try {if (rs != null)rs.close();} catch (Exception t) {}
							try {if (ps != null)ps.close();} catch (Exception t) {}
						}
						return retour;
					
					}
							
				
							
/**							//main permettant de tester la classe
							public static void main(int[] args){
								BonExpeditionDAO BonExpeditionDAO=new BonExpeditionDAO();
								
								System.out.println("\n********************");
								System.out.println("Test de la méthode ajouter");
								System.out.println("********************");
								
								//test de la méthode ajouter
								BonExpedition a=new BonExpedition();
								int retour= dao.BonExpeditionDAO.ajouter(a);
								System.out.println(retour+ " lignes ajoutées");

								
								
								System.out.println("\n********************");
								System.out.println("Test de la méthode supprimer");
								System.out.println("********************");
								
								//test de la méthode supprimer
								int BExp_ID= (Integer) null;
								int retour1= BonExpeditionDAO.supprimer(BExp_ID);
								System.out.println(retour1+ " lignes supprimées");
								
								
								System.out.println("\n********************");
								System.out.println("Test de la méthode getBonExpeditionDAO avec BExp_ID");
								System.out.println("********************");
								
								//test de la méthode getBonExpedition avec BExp_ID
								BonExpeditionDAO a2=dao.BonExpeditionDAO.getBonExpeditionDAO(BExp_ID);
								System.out.println(a2);

								
													
								
								System.out.println("\n********************");
								System.out.println("Test de la méthode getListBonExpeditionDAO");
								System.out.println("********************");
								
								//test de la méthode getListBonExpeditionDAO
								List<BonExpeditionDAO> liste=BonExpeditionDAO.getListBonExpeditionDAO();
								System.out.println(liste);
								
							}  **/
			       
				}







